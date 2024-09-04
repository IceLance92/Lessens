package com.practicum.p1051_fragmentdynamic;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Fragment1 frag1;
    Fragment2 frag2;
    FragmentTransaction fTrans;
    CheckBox chbStack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = new Fragment1();
        frag2 = new Fragment2();

        chbStack = (CheckBox)findViewById(R.id.chbStack);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        fTrans = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btnAdd:
                if (!frag1.isAdded()) {
                    fTrans.remove(frag2);
                    fTrans.add(R.id.frgmCont, frag1);
                }
                break;
            case R.id.btnRemove:
                fTrans.remove(frag1);
                fTrans.remove(frag2);
                break;
            case R.id.btnReplace:
                if (!frag2.isAdded()) {
                    fTrans.replace(R.id.frgmCont, frag2);
                } else {
                    fTrans.replace(R.id.frgmCont, frag1);
                }
            default:
                break;
        }
        if (chbStack.isChecked()) fTrans.addToBackStack(null);
        fTrans.commit();
    }
}