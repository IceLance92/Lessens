package ru.startandroid.p0101_listener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(this::onClick);
        btnCancel.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOk:
                tvOut.setText("Нажата кнопка ОК");
                break;
            case R.id.btnCancel:
                tvOut.setText("Нажата кнопка Cancel");
                break;
        }
    }
}