package com.practicum.p0631_alertdialogitemssingle;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";

    final int DIALOG_ITEMS = 1;
    final int DIALOG_ADAPTER = 2;
    final int DIALOG_CURSOR = 3;
    DB db;
    Cursor cursor;

    String data[] = {"one", "two", "three", "four"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // открываем подключение к БД
        db = new DB(this);
        db.open();
        cursor = db.getAllData();
        startManagingCursor(cursor);
    }

    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.btnItems:
                showDialog(DIALOG_ITEMS);
                break;
            case R.id.btnAdapter:
                showDialog(DIALOG_ADAPTER);
                break;
            case R.id.btnCursor:
                showDialog(DIALOG_CURSOR);
                break;
            default:
                break;
        }
    }
    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        switch (id) {
            // массив
            case DIALOG_ITEMS:
                adb.setTitle(R.string.items);
                adb.setSingleChoiceItems(data, -1, myClickListener);
                break;
                // адаптер
            case  DIALOG_ADAPTER:
                adb.setTitle(R.string.adapter);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_singlechoice, data);
                adb.setSingleChoiceItems(adapter, -1, myClickListener);
                break;
                // курсор
            case DIALOG_CURSOR:
                adb.setTitle(R.string.cursor);
                adb.setSingleChoiceItems(cursor, -1, DB.COLUMN_TXT, myClickListener);
                break;
        }
        adb.setPositiveButton(R.string.ok, myClickListener);
        return adb.create();
    }
    // обработчик нажатия на пункт списка диалога или кнопку
    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        @SuppressLint("SuspiciousIndentation")
        @Override
        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog)dialog).getListView();
            if (which == Dialog.BUTTON_POSITIVE)
                // выводим в лог позицию выбранного элемента
                Log.d(LOG_TAG, "pos = " + lv.getCheckedItemPosition());
            else
                // выводим в лог позицию нажатого элемента
            Log.d(LOG_TAG, "which = " + which);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}