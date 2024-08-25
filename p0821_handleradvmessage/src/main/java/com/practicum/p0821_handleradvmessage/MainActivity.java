package com.practicum.p0821_handleradvmessage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";

    final int STATUS_NONE = 0; // не подключения
    final int STATUS_CONNECTING = 1; // подключаемся
    final int STATUS_CONNECTED = 2; // подключено
    final int STATUS_DOWNLOAD_START = 3; // загрузка началась
    final int STATUS_DOWNLOAD_FILE = 4; // файл загружен
    final int STATUS_DOWNLOAD_END = 5; // загрузка закончена
    final int STATUS_DOWNLOAD_NONE = 6; // нет файлов для загрузки

    Handler handler;

    TextView tvStatus;
    ProgressBar pbDownload;
    Button btnConnect;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tvStatus);
        pbDownload = findViewById(R.id.pbDownload);
        btnConnect = findViewById(R.id.btnConnect);

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case STATUS_NONE:
                        btnConnect.setEnabled(true);
                        tvStatus.setText("Нет подключения");
                        pbDownload.setVisibility(TextView.GONE);
                        break;
                    case STATUS_CONNECTING:
                        btnConnect.setEnabled(false);
                        tvStatus.setText("Подключение...");
                        break;
                    case STATUS_DOWNLOAD_START:
                        tvStatus.setText("Загрузка запущена " + msg.arg1 + " файлы");
                        pbDownload.setMax(msg.arg1);
                        pbDownload.setProgress(0);
                        pbDownload.setVisibility(TextView.VISIBLE);
                        break;
                    case STATUS_DOWNLOAD_FILE:
                        tvStatus.setText("Загрузка. слева " + msg.arg2 + " файлы");
                        pbDownload.setProgress(msg.arg1);
                        saveFile((byte[]) msg.obj);
                        break;
                    case STATUS_DOWNLOAD_END:
                        tvStatus.setText("Загрузка завершена");
                        break;
                    case STATUS_DOWNLOAD_NONE:
                        tvStatus.setText("Нету файлов для загрузки");
                        break;

                }
            };
        };
        handler.sendEmptyMessage(STATUS_NONE);
    }
    public void onclick(View view) {
        Thread t = new Thread(new Runnable() {
            Message msg;
            byte[] file;
            Random rand = new Random();
            @Override
            public void run() {
                try {
                    // устанавливаем подключение
                    handler.sendEmptyMessage(STATUS_CONNECTING);
                    TimeUnit.SECONDS.sleep(1);

                    // подключение установлено
                    handler.sendEmptyMessage(STATUS_CONNECTED);

                    // определяем кол-во файлов
                    TimeUnit.SECONDS.sleep(1);
                    int filesCount = rand.nextInt(5);

                    if (filesCount == 0) {
                        // сообщаем, что файлов для загрузки нет
                        handler.sendEmptyMessage(STATUS_DOWNLOAD_NONE);
                        // и отключаемся
                        TimeUnit.MILLISECONDS.sleep(1500);
                        handler.sendEmptyMessage(STATUS_NONE);
                        return;
                    }
                    // загрузка начинается
                    // создаем сообщение, с ифнормацией о количестве файлов
                    msg = handler.obtainMessage(STATUS_DOWNLOAD_START, filesCount, 0);
                    // отправляем
                    handler.sendMessage(msg);

                    for (int i = 1; i <= filesCount; i++) {
                        // загружается файл
                        file = downloadFile();
                        //создаем сообщение с информацией о порядковом номере
                        // файла,
                        // кол-вом оставшихся и самим файлом
                        msg = handler.obtainMessage(STATUS_DOWNLOAD_FILE, i, filesCount - i, file);
                        // отправляем
                        handler.sendMessage(msg);
                    }
                    // загрузка завершена
                    handler.sendEmptyMessage(STATUS_DOWNLOAD_END);

                    // отключаемся
                    TimeUnit.MILLISECONDS.sleep(1500);
                    handler.sendEmptyMessage(STATUS_NONE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
    byte[] downloadFile() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return new byte[1024];
    }
    void saveFile(byte[] file) {}
}