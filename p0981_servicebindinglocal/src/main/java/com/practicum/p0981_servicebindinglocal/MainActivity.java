package com.practicum.p0981_servicebindinglocal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    boolean bound = false;
    ServiceConnection sConn;
    Intent intent;
    MyService myService;
    TextView tvInterval;
    long interval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInterval = findViewById(R.id.tvInterval);
        intent = new Intent(this, MyService.class);
        sConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder binder) {
                Log.d(LOG_TAG, "MainActivity onServiceConnected");
                myService = ((MyService.MyBinder)binder).getService();
                bound = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d(LOG_TAG, "MainActivity onServiceDisconnected");
                bound = false;
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(intent, sConn, 0);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!bound) return;
        unbindService(sConn);
        bound = false;
    }
    public void onClickStart(View view) {
        startService(intent);
    }
    public void onClickUp(View v) {
        if (!bound) return;
        interval = myService.upInterval(500);
        tvInterval.setText("interval = " + interval);
    }
    public void onClickDown(View v) {
        if (!bound) return;
        interval = myService.downInterval(500);
        tvInterval.setText("interval = " + interval);
    }
}