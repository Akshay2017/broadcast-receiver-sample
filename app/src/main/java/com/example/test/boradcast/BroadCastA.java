package com.example.test.boradcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by SITH 5 on 11/18/2017.
 */

public class BroadCastA extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String name=intent.getStringExtra("Name");
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
    }
}
