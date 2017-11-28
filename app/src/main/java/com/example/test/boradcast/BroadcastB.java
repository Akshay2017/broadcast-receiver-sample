package com.example.test.boradcast;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

/**
 * Created by SITH 5 on 11/18/2017.
 */

public class BroadcastB extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);


        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            Toast.makeText(context, "connected", Toast.LENGTH_SHORT).show();

        }else
        {
            Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
        }



        Toast.makeText(context, "B", Toast.LENGTH_SHORT).show();
    }
}
