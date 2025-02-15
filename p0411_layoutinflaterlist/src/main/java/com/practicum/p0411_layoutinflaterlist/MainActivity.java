package com.practicum.p0411_layoutinflaterlist;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    String[] name = {"Иван", "Марья", "Петр", "Антон", "Даша", "Борис", "Костя","Игорь", "Оля", "Диана", "Николай", "Рома", "Виталий", "Света", "Максим", "Денис"};
    String[] position = {"Программер", "Бухгалтер", "Программер", "Программер", "Бухгалтер", "Директор", "Программер", "Охранник", "Секретарша", "Заместитель директора", "Охранник", "Инвестор", "Программер", "Тракторист", "Начальник СБ", "Ювелир"};
    int salary[] = {1300, 10000, 13000, 13000, 10000, 15000, 13000, 8000, 12000, 10000, 32000, 45000, 12000, 10000, 9000, 14000};
    int[] colors = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
         colors[0] = Color.parseColor("#559966CC");
         colors[1] = Color.parseColor("#55336699");

        LinearLayout linLayout = findViewById(R.id.linLayout);

        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = 0; i < name.length; i++) {
            Log.d("myLogs", "i = " + i);
            View item = ltInflater.inflate(R.layout.item, linLayout, false);

            TextView tvName = item.findViewById(R.id.tvName);
            tvName.setText(name[i]);

            TextView tvPosition = item.findViewById(R.id.tvPosition);
            tvPosition.setText("Должность: " + position[i]);

            TextView tvSalary = item.findViewById(R.id.tvSalary);
            tvSalary.setText("Оклад: " + String.valueOf(salary[i]));

            item.getLayoutParams().width = ActionBar.LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i % 2]);
            linLayout.addView(item);
        }
    }
}