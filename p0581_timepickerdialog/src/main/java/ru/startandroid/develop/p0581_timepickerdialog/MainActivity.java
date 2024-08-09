package ru.startandroid.develop.p0581_timepickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int DIALOG_TIME = 1;
    int myHour = 14;
    int myMinute = 35;
    TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvTime = findViewById(R.id.tvTime);
    }
    public void onlick(View view) {
        showDialog(DIALOG_TIME);
    }
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this,
                    myCallBack,
                    myHour,
                    myMinute,
                    true);
            return tpd;
        }
        return super.onCreateDialog(id);
    }
    TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            tvTime.setText("Time is " + myHour + " hors " + myMinute + " minutes");
        }
    };
}