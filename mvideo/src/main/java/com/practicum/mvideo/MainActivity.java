package com.practicum.mvideo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn10;
    Button btn11;
    Button btn12;
    Button btn13;
    Button btn14;
    Button btn15;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn14 = findViewById(R.id.btn14);
        btn15 = findViewById(R.id.btn15);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn11.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn1:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89255617625"));
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89154985828"));
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89616475888"));
                startActivity(intent);
                break;
            case R.id.btn4:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89130384618"));
                startActivity(intent);
                break;
            case R.id.btn5:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89259491676"));
                startActivity(intent);
                break;
            case R.id.btn6:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89775427387"));
                startActivity(intent);
                break;
            case R.id.btn7:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89257839784"));
                startActivity(intent);
                break;
            case R.id.btn8:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89162559887"));
                startActivity(intent);
                break;
            case R.id.btn9:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89999885698"));
                startActivity(intent);
                break;
            case R.id.btn10:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89250683474"));
                startActivity(intent);
                break;
            case R.id.btn11:
            intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:89169156206"));
            startActivity(intent);
            break;
            case R.id.btn12:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89652902415"));
                startActivity(intent);
                break;
            case R.id.btn13:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89268558815"));
                startActivity(intent);
                break;
            case R.id.btn14:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89017001839"));
                startActivity(intent);
                break;
            case R.id.btn15:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mstudy.mvideo.ru/_ems/"));
                startActivity(intent);
                break;
        }
    }
}