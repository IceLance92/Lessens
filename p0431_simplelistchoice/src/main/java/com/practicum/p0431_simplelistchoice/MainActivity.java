package com.practicum.p0431_simplelistchoice;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String LOG_TAG = "myLogs";

    ListView lvMain;
    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lvMain = findViewById(R.id.lvMain);
        // устанавливаем режим выбора пунктов списка
        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        // создаем адаптер, используя массив из файла ресурсов
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_list_item_multiple_choice);
        lvMain.setAdapter(adapter);

        Button btnChecked = findViewById(R.id.btnChecked);
        btnChecked.setOnClickListener(this);

        //получаем массив из файла ресурсов
        names = getResources().getStringArray(R.array.names);
    }
    public void onClick(View arg0) {
        // пишем в лог выделенный элемент
        Log.d(LOG_TAG, "checked: ");
        SparseBooleanArray sbArray = lvMain.getCheckedItemPositions();
        for (int i = 0; i < sbArray.size(); i++) {
            int key = sbArray.keyAt(i);
            if (sbArray.get(key))
                Log.d(LOG_TAG, names[key]);
        }
    }
}