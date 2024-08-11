package com.practicum.p0601_alertdialogsimple;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    final int DIALOG_EXIT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    @SuppressLint("MissingSuperCall")
    public void onBackPressed() {
        // вызываем диалог
        showDialog(DIALOG_EXIT);
    }

    public void onclick(View view) {
        // вызываем диалог
        showDialog(DIALOG_EXIT);
    }
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_EXIT) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setCancelable(false);
            // заголовок
            adb.setTitle(R.string.exit);
            //сообщение
            adb.setMessage(R.string.save_data);
            // иконка
            adb.setIcon(android.R.drawable.ic_dialog_info);
            // кнопка положительного ответа
            adb.setPositiveButton(R.string.yes, myClickListener);
            // кнопка отрицательного ответа
            adb.setNegativeButton(R.string.no, myClickListener);
            // кнопка нейтрального ответа
            adb.setNegativeButton(R.string.cancel, myClickListener);
            adb.setCancelable(false);
            // создаем диалог
            return adb.create();
        }
        return super.onCreateDialog(id);
    }
    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                // Положительная кнопка
                case Dialog.BUTTON_POSITIVE:
                    saveData();
                    finish();
                    break;
                    // негативная кнопка
                case Dialog.BUTTON_NEGATIVE:
                    message();
                    //finish();
                    break;
                    // нейтральная кнопка
                case Dialog.BUTTON_NEUTRAL:
                    break;
        }
    }
    };
    void saveData() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
    }
    void message() {
        Toast.makeText(this, R.string.cancel, Toast.LENGTH_SHORT).show();
    }
}