package com.michalfujak.example.e_objednaj.SodiumSecretCheckBox;


import org.libsodium.jni.NaCl;
import org.libsodium.jni.Sodium;
import org.libsodium.jni.SodiumConstants;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

// Version class: 1.0.0.100 [ 6.8.2020 22:20 ]
//
// install sodium api
//
// library install
// implementation 'com.github.joshjdevl.libsodiumjni:libsodium-jni-aar:2.0.1'
//
// and [.update manifests]
//
// [.find]
// <application
//
// [.add after]
// android:allowBackup="true"
//
//
// native code, starting OnCreate
// Used to load the 'native-lib' library on application startup.
// static {
//         System.loadLibrary("sodiumjni");
//        }
//
//
public class TransferSodiumApplication
{
    // variable
    int sizeGenerateKey;

    public TransferSodiumApplication()
    {
        NaCl.sodium();
    }

    /**
     *
     * @return bufferNonceByteArray
     */
    public byte[] generateNonceByte()
    {
        int size = Sodium.crypto_box_noncebytes();

        byte[] buffer = new byte[size];
        Sodium.randombytes(buffer, size);

        return buffer;
    }

    /**
     *  param null
     * @return bufferPublicKey
     */
    public byte[] generatePublicKey()
    {
        sizeGenerateKey = Sodium.crypto_secretbox_keybytes();
        byte[] bufferPublicKey = new byte[sizeGenerateKey];
        Sodium.randombytes(bufferPublicKey, sizeGenerateKey);
        // return to array byte.
        return bufferPublicKey;
    }

    // EncryptMethod_sKey

    /**
     *
     * @param messageBytes
     * @param keyBytes
     * @return encryptData
     */
    public byte[] EncryptMethod_sKey(byte[] messageBytes, byte[] keyBytes)
    {
        // variable
        byte[] nonce = generateNonceByte();
        byte[] chipherText = new byte[Sodium.crypto_secretbox_macbytes() + messageBytes.length];

        Sodium.crypto_secretbox_easy(
                chipherText,
                messageBytes,
                messageBytes.length,
                nonce,
                keyBytes
        );

        byte[] encryptData = new byte[nonce.length + chipherText.length];
        System.arraycopy(nonce, 0, encryptData, 0, nonce.length);
        System.arraycopy(chipherText, 0, encryptData, nonce.length, chipherText.length);

        return encryptData;

    }

    /**
     *
     * @param encryptData
     * @param publicKey
     * @return
     */
    public byte[] DecryptMethod_sKey(byte[] encryptData, byte[] publicKey)
    {
        // Decrypted method, hash data
        byte[] nonce = new byte[SodiumConstants.NONCE_BYTES]; // crypto_box_SEALBYTES
        byte[] chipherTextByte2 = new byte[encryptData.length - nonce.length];

        int error_rc;

        // decryptrd
        byte[] decrypt = new byte[(chipherTextByte2.length - Sodium.crypto_secretbox_macbytes())];

        // write System.arrayCopy
        System.arraycopy(encryptData, 0, nonce, 0, nonce.length);
        System.arraycopy(encryptData, nonce.length, chipherTextByte2, 0, chipherTextByte2.length);
        //
        error_rc = Sodium.crypto_secretbox_open_easy(decrypt, chipherTextByte2, chipherTextByte2.length, nonce, publicKey);
        if(error_rc != 0)
        {
            // error
        }
        return decrypt;
    }

    /**
     *
     * @param crypto
     * @return cryptoMessage
     */
    public String transferCryptoByteToString(byte[] crypto)
    {
        // Convert to String
        String cryproMessage = new String(crypto, Charset.forName("UTF8"));
        return cryproMessage;
    }

    /**
     *
     * @param cryptoM
     * @return
     */
    public byte[] transferCryptoStringToByte(String cryptoM)
    {
        // Convert to byte[]
        return cryptoM.getBytes();
    }
}

