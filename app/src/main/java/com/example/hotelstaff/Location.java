package com.example.hotelstaff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Location extends AppCompatActivity {

    TextView Device_Number, Guest_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        Device_Number = findViewById(R.id.Device_Number);
        Guest_id = findViewById(R.id.Guest_id);

        Device_Number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDevices();
            }
        });

        Guest_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGuests();
            }
        });

    }


    private void openDevices() {
        Intent intent = new Intent(this, Devices.class);
        startActivity(intent);
    }

    private void openGuests() {
        Intent intent = new Intent(this, Guests.class);
        startActivity(intent);
    }

}
