package com.example.p1161_mngtasks1;

import android.content.Intent;
import android.view.View;

public class ActivityC extends MainActivity {
    public void onClick(View view) {
        startActivity(new Intent(this, ActivityD.class));
    }
}
