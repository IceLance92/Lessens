package com.example.p1121_dynamicactionbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    final int MENU_ID = 1;

    CheckBox chbAddDel;
    CheckBox chbVisible;

    Fragment frag1;
    Fragment frag2;
    Fragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        frag = frag1 = new Fragment1();
        frag2 = new Fragment2();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        menu.setGroupVisible(R.id.groupVsbl, chbVisible.isChecked());
        if (chbAddDel.isChecked()) {
            menu.add(0, MENU_ID, 0, R.string.menu_item1)
                    .setIcon(android.R.drawable.ic_delete)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS
                            | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        } else {
            menu.removeItem(MENU_ID);
        }
        return true;
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chbAddDel:
            case R.id.chbVisible:
                invalidateOptionsMenu();
                break;
            case R.id.btnFrag:
                frag = (frag == frag1) ? frag2 : frag1;
                getSupportFragmentManager().beginTransaction().replace(R.id.cont, frag)
                        .commit();
                break;
            default:
                break;
        }
    }
}