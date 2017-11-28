package com.example.test.boradcast;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Context mContext;
    private EditText editText;
    private TextView textView;
    private CoordinatorLayout coordinatorLayout;
    private Snackbar snackbar;
    @Override
    protected void onStart() {
        super.onStart();
       // registerReceiver(broadcastReceiver, new IntentFilter("TEST"));
        registerReceiver(new BroadCastA(),new IntentFilter("A"));
        registerReceiver(new BroadcastB(),new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        registerReceiver(broadcastReceiver, new IntentFilter("CONNECTIVITY_CHANGE"));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.reciver);
        mContext=MainActivity.this;
        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.textView2);
        coordinatorLayout=findViewById(R.id.clayout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("android.net.conn.CONNECTIVITY_CHANGE");
               // intent.putExtra("Name",editText.getText().toString());
                sendBroadcast(intent);

            }
        });
    }

    final BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
//            String name=intent.getStringExtra("Name");
//            textView.setText(name);

            ConnectivityManager connectivityManager= (ConnectivityManager) mContext.getSystemService(Service.CONNECTIVITY_SERVICE);


                NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()){

                        snackbar=Snackbar.make(coordinatorLayout,"Connected",Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }else
                    {
                        snackbar=Snackbar.make(coordinatorLayout,"Disconnected",Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }




            //Toast.makeText(MainActivity.this, "This is BroadcastReceiver", Toast.LENGTH_SHORT).show();

        }
    };

}
