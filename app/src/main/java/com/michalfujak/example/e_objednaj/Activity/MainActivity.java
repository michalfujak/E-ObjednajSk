package com.michalfujak.example.e_objednaj.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.michalfujak.example.e_objednaj.Modul.ApplicationLogin;
import com.michalfujak.example.e_objednaj.Modul.ApplicationLoginSecret;
import com.michalfujak.example.e_objednaj.R;
import com.michalfujak.example.e_objednaj.Retrofit.IObjednajServiceClient;
import com.michalfujak.example.e_objednaj.SodiumSecretCheckBox.TransferEncoderBase64;
import com.michalfujak.example.e_objednaj.SodiumSecretCheckBox.TransferSodiumApplication;
import com.michalfujak.example.e_objednaj.Utils.Common;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.libsodium.jni.Sodium;
import org.libsodium.jni.SodiumJNI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("sodiumjni");
    }
    // native code, starting OnCreate

    // Initializable component
    RelativeLayout relativeStartActivity;
    TextView textViewAppPrivateKey;
    Button buttonContinue, buttonAdminSystem;
    // AdminDialogLogin
    ImageView adminDialogLoginClose;
    MaterialEditText adminDialogSecondPassword, adminDialogPrivatePassword;
    Button adminDialogButtonAuth;

    // AlertDialog.V7
    Dialog adminDialogLogin;

    // Retrofit service object
    IObjednajServiceClient IObjednajService;

    // Sodium variable
    private byte[] nonce;
    private byte[] base64NonceConvertToByte;
    private String base64Nonce;
    private String base64UrlNonce;
    private String base64UrlNonceReplace;
    private String cryptoSodiumOut;
    private String base64CryptoSodiumOut;
    private byte[] cryptoSodiumByte;
    //
    private byte[] heap_publicKey;
    private String messageKey2 = "Key2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        IObjednajService = Common.getAPIServerOne();
        // Sodium object
        TransferSodiumApplication transferSodium = new TransferSodiumApplication();
        TransferEncoderBase64 transferBase64bit = new TransferEncoderBase64();
        //
        // textViewAppPrivateKey = (TextView)findViewById(R.id.layout_start_private_key_text);
        // textViewAppPrivateKey.setText(generatePublicApplicationKey());
        // C++ 11
        // Example of a call to a native method
        // Log.e("Error", stringCryptoPrivateKey());
        // RelativeLayout action LongClick
        relativeStartActivity = (RelativeLayout)findViewById(R.id.relative_layout_starting_page);
        relativeStartActivity.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                buttonAdminSystem = (Button)findViewById(R.id.starting_button_admin);
                buttonAdminSystem.setVisibility(View.VISIBLE);
                return true;
            }
        });

        // Admin authorization
        buttonAdminSystem = (Button)findViewById(R.id.starting_button_admin);
        buttonAdminSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Admin Dialog LOGIN
                adminDialogLoginStart();
            }
        });

        // Callback Sodium library
        heap_publicKey = transferSodium.transferCryptoStringToByte(generatePublicApplicationKey());
        cryptoSodiumByte = transferSodium.EncryptMethod_sKey(transferSodium.transferCryptoStringToByte(messageKey2), heap_publicKey);
        // copy nonce
        nonce = transferSodium.copy_to_copy_nonce_public();
        // fine!
        base64CryptoSodiumOut = transferBase64bit.encodeBase64Url(cryptoSodiumByte);
        base64Nonce = transferBase64bit.encodeBase64Url(nonce);
        // Convert to byte, for Base64URL
        base64NonceConvertToByte = transferSodium.transferCryptoStringToByte(base64Nonce);
        // Out for read to retrofit
        // fine!
        base64UrlNonce = transferBase64bit.encodeBase64Url(base64NonceConvertToByte);
        base64UrlNonceReplace = transferBase64bit.replaceNonce(base64UrlNonce);

        // Error debugging
        // https://stackoverflow.com/questions/50452262/android-ndk-throwing-signal-sigsegv-invalid-address-in-debug-mode
        // NDK --> C++






        ApplicationLogin objAppLogin = new ApplicationLogin(base64CryptoSodiumOut, base64UrlNonceReplace);

        Call<ApplicationLoginSecret> callAppLoginSecret = IObjednajService.appLoginSecret(objAppLogin, base64UrlNonceReplace);
        callAppLoginSecret.enqueue(new Callback<ApplicationLoginSecret>() {
            @Override
            public void onResponse(Call<ApplicationLoginSecret> call, Response<ApplicationLoginSecret> response) {
                Toast.makeText(MainActivity.this, "" + response.code() + "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ApplicationLoginSecret> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("Error2", t.getMessage() + "  SystemInfo: " + t.toString());
                // update code, helper: https://stackoverflow.com/questions/39918814/use-jsonreader-setlenienttrue-to-accept-malformed-json-at-line-1-column-1-path
            }
        });
    }



    /**
     * function:   adminDialogLoginStart
     * param:      not
     * return:     null
     */
    private void adminDialogLoginStart()
    {
        adminDialogLogin = new Dialog(this);
        adminDialogLogin.setContentView(R.layout.admin_panel_login_dialog);
        adminDialogLoginClose = (ImageView) adminDialogLogin.findViewById(R.id.admin_dialog_login_close);
        adminDialogSecondPassword = (MaterialEditText) adminDialogLogin.findViewById(R.id.admin_dialog_login_auth_panel_field_second_pass);
        adminDialogPrivatePassword = (MaterialEditText) adminDialogLogin.findViewById(R.id.admin_dialog_login_auth_panel_field_primary_pass);
        adminDialogButtonAuth = (Button) adminDialogLogin.findViewById(R.id.admin_dialog_login_button_auth);

        //
        // Action button Close
        adminDialogLoginClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminDialogLogin.dismiss();
            }
        });

        //
        // Action event Button Admin.Dialog.Login.Button.Auth
        adminDialogButtonAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminDialogLoginLTE_Secure(adminDialogSecondPassword.getText().toString(), adminDialogPrivatePassword.getText().toString() );
            }
        });
        adminDialogLogin.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        adminDialogLogin.show();
    }

    /**
     * function:         adminDialogLoginLTE_Secure
     * param:            secondPassword
     * param:            privatePassword
     * return:           null
     */
    private void adminDialogLoginLTE_Secure(String secondPassword, String privatePassword)
    {
        // Call  native C++ 11 library...
        // adminDialogLoginAuthLTE_Protected(secondPassword, privatePassword);
    }




    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    // Default disabled
    // C++ 11 call Native method
    // public native String stringFromJNI();
    public native String generatePublicApplicationKey();
    // public native String stringHelperPublicKey();
    // public native Integer MatchRandomValue(Integer x, Integer y);
    private native String adminDialogLoginAuthLTE_Protected(String secondPass, String primaryPass);
}
