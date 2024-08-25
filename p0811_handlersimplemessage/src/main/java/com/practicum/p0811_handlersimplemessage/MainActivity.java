package com.practicum.p0811_handlersimplemessage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";

    final int STATUS_NONE = 0; // нет подключения
    final int STATUS_CONNECTING = 1; // подключаемся
    final int STATUS_CONNECTED = 2; // подключено

    Handler h;

    TextView tvStatus;
    ProgressBar pbConnect;
    Button btnConnect;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tvStatus);
        btnConnect = findViewById(R.id.btnConnect);
        pbConnect = findViewById(R.id.pbConnect);

        h = new Handler() {
            public void handleMessage(android.os.Message msg) {
                switch (msg.what) {
                    case STATUS_NONE:
                        btnConnect.setEnabled(true);
                        tvStatus.setText("Нету подключения");
                        break;
                    case STATUS_CONNECTING:
                        btnConnect.setEnabled(false);
                        pbConnect.setVisibility(TextView.VISIBLE);
                        tvStatus.setText("Подключение...");
                        break;
                    case STATUS_CONNECTED:
                        pbConnect.setVisibility(TextView.GONE);
                        tvStatus.setText("Подключено");
                        break;
                }
            };
        };
        h.sendEmptyMessage(STATUS_NONE);
    }
    public void onclick(View view) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // устанавливаем подключение
                    h.sendEmptyMessage(STATUS_CONNECTING);
                    TimeUnit.SECONDS.sleep(2);

                    // установлено
                    h.sendEmptyMessage(STATUS_CONNECTED);

                    // выполняется какая-то работа
                    TimeUnit.SECONDS.sleep(3);

                    // разрываем подключение
                    h.sendEmptyMessage(STATUS_NONE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}