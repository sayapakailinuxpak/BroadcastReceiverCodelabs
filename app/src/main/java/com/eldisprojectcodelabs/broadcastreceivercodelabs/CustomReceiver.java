package com.eldisprojectcodelabs.broadcastreceivercodelabs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import static com.eldisprojectcodelabs.broadcastreceivercodelabs.MainActivity.ACTION_CUSTOM_BROADCAST;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //get Intent that has been registered
        String intentAction = intent.getAction();

        if (intentAction != null){
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED :
                    toastMessage = "Power Connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED :
                    toastMessage = "Power Disconnected";
                    break;
                case ACTION_CUSTOM_BROADCAST :
                    toastMessage = "Custom Broadcast Received";
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }

    }
}
