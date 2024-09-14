package com.example.p1101_dialogfragment;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {

    DialogFragment dlg1;
    DialogFragment dlg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dlg1 = new Dialog1();
        dlg2 = new Dialog2();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDlg1:
                dlg1.show(getSupportFragmentManager(), "dlg1");
                break;
            case R.id.btnDlg2:
                dlg2.show(getSupportFragmentManager(), "dlg2");
                break;
            default:
                break;
        }
    }
}