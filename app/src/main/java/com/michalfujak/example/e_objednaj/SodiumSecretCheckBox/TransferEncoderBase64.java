package com.michalfujak.example.e_objednaj.SodiumSecretCheckBox;

import android.util.Base64;

public class TransferEncoderBase64
{
    // variable
    String encodeHash;
    String encodeHashUrl;
    byte[] decodeDefault;
    byte[] decodeUrl;

    /**
     * construct
     */
    public TransferEncoderBase64()
    {
        // Construct
    }

    /**
     *
     * @param hashArray
     * @return encodeHash
     */
    public String encodeBase64(byte[] hashArray)
    {
        // return string
        encodeHash = Base64.encodeToString(hashArray, Base64.DEFAULT);
        return encodeHash;
    }

    /**
     *
     * @param hashArray
     * @return encodeHashUrl
     */
    public String encodeBase64Url(byte[] hashArray)
    {
        // return string
        encodeHashUrl = Base64.encodeToString(hashArray, Base64.URL_SAFE | Base64.NO_PADDING | Base64.NO_WRAP);
        return encodeHashUrl;
    }

    /**
     *
     * @param decode
     * @return decodeDefault byte[]
     */
    public byte[] decodeBase64(String decode)
    {
        decodeDefault = Base64.decode(decode, Base64.DEFAULT);
        return decodeDefault;
    }

    /**
     *
     * @param decode64Url
     * @return decodeUrl byte[]
     */
    public byte[] decodeBase64Url(String decode64Url)
    {
        decodeUrl = Base64.decode(decode64Url, Base64.URL_SAFE);
        return decodeUrl;
    }
}

