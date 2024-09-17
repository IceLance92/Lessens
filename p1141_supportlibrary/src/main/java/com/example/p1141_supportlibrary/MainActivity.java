package com.example.p1141_supportlibrary;

import android.os.Bundle;
import android.view.Menu;

import androidx.activity.EdgeToEdge;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        MyFragment myFrag = new MyFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.cont, myFrag).commit()
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.class.getModifiers(), menu);
        return true;
    }
}