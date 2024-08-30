package com.practicum.p0991_servicenotification;

import static com.practicum.p0991_servicenotification.R.drawable.ic_launcher;
import static com.practicum.p0991_servicenotification.R.drawable.ic_launcher_foreground;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;

import java.util.concurrent.TimeUnit;

public class MyService extends Service {

    NotificationManager nm;

    @Override
    public void onCreate() {
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendNotif();
        return super.onStartCommand(intent, flags, startId);
    }

    private void sendNotif() {

        Notification.Builder nBuilder = new Notification.Builder(this)
                .setContentTitle("Title of notification")
                .setContentText("Some context text here")
                .setSmallIcon(R.drawable.ic_sms_failed_black_18dp)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_sms_failed_black_48dp));


// 3-я часть Click on notification
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(MainActivity.FILE_NAME, "somefile.txt");
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        nBuilder.setContentIntent(pIntent);


        Notification notif = nBuilder.build();
// ставим флаг, чтобы уведомление пропало после нажатия
        notif.flags |= Notification.FLAG_AUTO_CANCEL;
        notif.defaults = Notification.DEFAULT_ALL;
        notif.number = 5;


// отправляем
        nm.notify(1, notif);
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }
}
