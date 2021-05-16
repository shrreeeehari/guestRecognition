package com.example.hotelstaff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Homepage extends AppCompatActivity {

    TextView devices, location, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        devices = findViewById(R.id.Devices);
        location = findViewById(R.id.Maps);
        profile = findViewById(R.id.Profile);

        devices.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setComponent(new ComponentName("com.samebits.beacon.locator","com.samebits.beacon.locator.ui.activity.MainNavigationActivity"));



                if (intent != null) {

                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {

                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setData(Uri.parse("market://details?id=" + "com.samebits.beacon.locator"));
                    startActivity(intent);
                }

            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFindUsing();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





    }


    public void openDevices() {

        try {
            Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage("com.radiusnetworks.locate");
            startActivity(intent);
        } catch (ActivityNotFoundException | NullPointerException e) {
            Toast.makeText(this, "There is no package available in android", Toast.LENGTH_LONG).show();
        }

    }



    private void openFindUsing() {
        Intent intent = new Intent(this, Location.class);
        startActivity(intent);
    }

    private void openProfile() {

        Intent intent = new Intent(this, UserProfile.class);
        startActivity(intent);
    }
}
