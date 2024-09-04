package com.practicum.p1041_fragmentlifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "MainActivity onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "MainActivity onDestroy");
    }
}