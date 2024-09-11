package com.example.p1082_toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        DrawerLayout myDrawerLayout = findViewById(R.id.drawer_layout_id);

        NavigationView myNavigationView = findViewById(R.id.navigation_view_id);
        myNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.message_btn:
                        Toast.makeText(MainActivity.this, "Messages",
                                Toast.LENGTH_SHORT).show();
                        myDrawerLayout.close();
                        return true;
                    case R.id.maps_btn:
                        Toast.makeText(MainActivity.this, "Maps",
                                Toast.LENGTH_SHORT).show();
                        myDrawerLayout.close();
                        return true;
                }
                    return false;
            }
        });
        ActionBarDrawerToggle myToggle = new ActionBarDrawerToggle(this, myDrawerLayout, myToolbar, R.string.drawer_open, R.string.drawer_close);

        myDrawerLayout.addDrawerListener(myToggle);

        myToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.info_btn:
                Toast.makeText(this, "Button INFO is pressed",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.close_btn:
                Toast.makeText(this, "Button CLOSE is pressed",
                        Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}