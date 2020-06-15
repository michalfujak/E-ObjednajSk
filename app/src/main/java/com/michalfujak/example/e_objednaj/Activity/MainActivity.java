package com.michalfujak.example.e_objednaj.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.michalfujak.example.e_objednaj.R;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    // Initializable component
    RelativeLayout relativeStartActivity;
    TextView textViewAppPrivateKey;
    Button buttonContinue, buttonAdminSystem;

    // AlertDialog.V7
    Dialog adminDialogLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //
        textViewAppPrivateKey = (TextView)findViewById(R.id.layout_start_private_key_text);
        textViewAppPrivateKey.setText(stringCryptoPrivateKey());
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
    }

    private void adminDialogLoginStart()
    {
        adminDialogLogin = new Dialog(this);
        //
        adminDialogLogin.setContentView(R.layout.admin_panel_login_dialog);
        adminDialogLogin.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        adminDialogLogin.show();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    // Default disabled
    // C++ 11 call Native method
    // public native String stringFromJNI();
    public native String stringCryptoPrivateKey();
    // public native String stringHelperPublicKey();
    // public native Integer MatchRandomValue(Integer x, Integer y);
}
