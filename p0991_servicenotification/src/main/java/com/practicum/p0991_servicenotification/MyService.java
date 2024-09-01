package com.practicum.p0991_servicenotification;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import java.util.concurrent.TimeUnit;

public class MyService extends Service {
    public String LOG_TAG = "myLogs";
    private NotificationManager notificationManager;
    private static final String Channel_id = "CHANNEL_ID";
    private static final int NOTIFY_ID = 1;


    @Override
    public void onCreate() {
        Log.d(LOG_TAG, "запускается onCreate");
        super.onCreate();
        notificationManager = (NotificationManager) getApplicationContext()
                .getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            Log.d(LOG_TAG, "запускается onStartCommand");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sendNotif();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void sendNotif() throws IllegalAccessException, InstantiationException {
        Log.d(LOG_TAG, "запустился sendNotif");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(MyService.this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.class.newInstance(), new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder notif = new NotificationCompat.Builder(getApplicationContext(), Channel_id)
                .setAutoCancel(false)
                .setSmallIcon(R.drawable.ic_launcher)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pIntent)
                .setContentTitle("Заголовок")
                .setContentText("какой то текст");
        createChannelIfNeeded(notificationManager);
        notificationManager.notify(NOTIFY_ID, notif.build());
    }
    public static void createChannelIfNeeded(NotificationManager manager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(Channel_id, Channel_id, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }
    public IBinder onBind(Intent arg0) {
        return null;
    }
}
