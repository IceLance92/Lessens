package com.practicum.p0961_servicebackbroadcast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyService extends Service {

    final String LOG_TAG = "myLogs";
    ExecutorService es;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "MyService onCreate");
        es = Executors.newFixedThreadPool(2);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "MyService onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "MyService onStartCommand");

        int time = intent.getIntExtra(MainActivity.PARAM_TIME, 1);
        int task = intent.getIntExtra(MainActivity.PARAM_TASK, 0);

        MyRun mr = new MyRun(startId, time, task);
        es.execute(mr);

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    class MyRun implements Runnable {
        int time;
        int startId;
        int task;

        public MyRun(int startId, int time, int task) {
            this.time = time;
            this.startId = startId;
            this.task = task;
            Log.d(LOG_TAG, "MyRun#" + startId + " start, time = " + time);
        }

        @Override
        public void run() {
            Intent intent = new Intent(MainActivity.BROADCAST_ACTION);
            Log.d(LOG_TAG, "MyRun#" + startId + " start, time = " + time);
        try {
                // сообщаем о старте задачи
                intent.putExtra(MainActivity.PARAM_TASK, task);
                intent.putExtra(MainActivity.PARAM_STATUS, MainActivity.STATUS_START);
                sendBroadcast(intent);

                // начинаем выполнение задачи
                TimeUnit.SECONDS.sleep(time);

                // сообщаем об окончании задачи
                intent.putExtra(MainActivity.PARAM_STATUS, MainActivity.STATUS_FINISH);
                intent.putExtra(MainActivity.PARAM_RESULT, time * 100);
                sendBroadcast(intent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop();
        }
        void stop() {
            Log.d(LOG_TAG, "MyRun#" + startId + " end, stopSelfResult(" + startId + ") = " + stopSelfResult(startId));
        }
    }
}
