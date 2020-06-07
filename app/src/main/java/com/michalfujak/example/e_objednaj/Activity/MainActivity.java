package com.michalfujak.example.e_objednaj.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.michalfujak.example.e_objednaj.R;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // C++ 11
        // Example of a call to a native method
        TextView tv = findViewById(R.id.testCppTextView);
        tv.setText(stringCryptoPrivateKey());
        Log.e("Error", stringCryptoPrivateKey());
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
