package com.example.exp_21_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(myBroadcastReceiver, new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        registerReceiver(myBroadcastReceiver, new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));
        registerReceiver(myBroadcastReceiver, new IntentFilter(Intent.ACTION_BATTERY_LOW));
        registerReceiver(myBroadcastReceiver, new IntentFilter(Intent.ACTION_BATTERY_OKAY));
        registerReceiver(myBroadcastReceiver, new IntentFilter(Intent.ACTION_REBOOT));
        registerReceiver(myBroadcastReceiver, new IntentFilter(Intent.ACTION_BOOT_COMPLETED));
        registerReceiver(myBroadcastReceiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcastReceiver);
    }
}