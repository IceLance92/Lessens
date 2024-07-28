package com.practicum.p0421_simplelist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис", "Костя", "Игорь", "Анна", "Денис", "Андрей", "Света", "Настя", "Катя", "Игорь", "Ян", "Саша", "Прада", "Алексей", "Аня", "Артем", "Кира", "Жорик", "Ярик", "Кузя", "Кирилл", "Муся",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // находим список
        ListView lvMain = findViewById(R.id.lvMain);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.my_list_item, names);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);

    }
}