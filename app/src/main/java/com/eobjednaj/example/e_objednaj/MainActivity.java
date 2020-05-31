package com.eobjednaj.example.e_objednaj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.libsodium.jni.Sodium;

public class MainActivity extends AppCompatActivity {


    // Component initializable
    Button buttonContinue, buttonAdmin;
    RelativeLayout relativeStarting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Start click continue
        buttonContinue = (Button)findViewById(R.id.starting_button_continue);
        relativeStarting = (RelativeLayout)findViewById(R.id.relative_layout_starting_page);

        // button.continue.click
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authorizationStart();
            }
        });

        relativeStarting.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                viewPanelAdminButton(getString(R.string.public_key));
                return false;
            }
        });
    }

    public void authorizationStart()
    {
        Toast.makeText(this, "Starting Authorization...", Toast.LENGTH_LONG).show();
    }

    public void viewPanelAdminButton(String key)
    {
        buttonAdmin = (Button)findViewById(R.id.starting_button_admin);
        buttonAdmin.setVisibility(View.VISIBLE);
        Toast.makeText(this, "Key: " + key + "", Toast.LENGTH_LONG).show();
    }
}