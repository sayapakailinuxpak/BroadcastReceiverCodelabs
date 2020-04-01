package com.eldisprojectcodelabs.broadcastreceivercodelabs;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CustomReceiver customReceiver = new CustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent filter specifies the types of intents a component can receive
        //it's same like <intent-filter> in XML
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        //register and unregister the receiver using activity context
        MainActivity.this.registerReceiver(customReceiver, intentFilter);
    }


    //avoid memory leaks
    @Override
    protected void onDestroy() {
        MainActivity.this.unregisterReceiver(customReceiver);
        super.onDestroy();
    }
}
