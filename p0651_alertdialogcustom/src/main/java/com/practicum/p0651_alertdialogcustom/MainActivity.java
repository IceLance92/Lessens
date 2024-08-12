package com.practicum.p0651_alertdialogcustom;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    final int DIALOG = 1;

    int btn;
    LinearLayout view;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    TextView tvCount;
    ArrayList<TextView> textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textViews = new ArrayList<>(10);
    }
    public void onclick(View view) {
        btn = view.getId();
        showDialog(DIALOG);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Custom dialog");
        // создаем view из dialog.xml
        view = (LinearLayout) getLayoutInflater().inflate(R.layout.dialog, null);
        // устанавливаем ее, как содержимое тела диалога
        adb.setView(view);
        // находим TextView для отображения кол-ва
        tvCount = (TextView) view.findViewById(R.id.tvCount);
        return adb.create();
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        if (id == DIALOG) {
            // находим TextView для отображения времени и показываем текущее время
            TextView tvTime = (TextView) dialog.getWindow().findViewById(R.id.tvTime);
            tvTime.setText(sdf.format(new Date(System.currentTimeMillis())));
            // если была нажата кнопка Добавить
            if (btn == R.id.btnAdd) {
                // создаем новое TextView, добавляем в диалог, указываем текст
                TextView tv = new TextView(this);
                view.addView(tv, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tv.setText("TextView " + (textViews.size() + 1));
                // добавляем новое TextView в коллекцию
                textViews.add(tv);
                // иначе
            } else {
                // если коллекция созданных TextView непуста
                if (textViews.size() > 0) {
                    // находим в коллекции последний TextView
                    TextView tv = textViews.get(textViews.size() - 1);
                    // удаляем из диалога
                    view.removeView(tv);
                    // удаляем из коллекции
                    textViews.remove(tv);
                }
            }
            // обновляем счетчик
            tvCount.setText("Кол-во TextView = " + textViews.size());
        }
    }
}