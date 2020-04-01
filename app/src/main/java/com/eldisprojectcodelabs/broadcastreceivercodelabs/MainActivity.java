package com.eldisprojectcodelabs.broadcastreceivercodelabs;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CustomReceiver customReceiver = new CustomReceiver(); //invoke receiver object
    public static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST"; //define action string
    Button buttonSendBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent filter specifies the types of intents a component can receive
        //it's same like <intent-filter> in XML
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        //register and unregister the receiver using activity context
        MainActivity.this.registerReceiver(customReceiver, intentFilter);

        buttonSendBroadcast = findViewById(R.id.button);
        buttonSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
                sendBroadcast(customBroadcastIntent);
                registerReceiver(customReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));



            }
        });


    }




    //avoid memory leaks
    @Override
    protected void onDestroy() {
        MainActivity.this.unregisterReceiver(customReceiver);
        super.onDestroy();
    }
}
