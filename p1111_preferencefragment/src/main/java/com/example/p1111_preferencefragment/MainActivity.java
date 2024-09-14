package com.example.p1111_preferencefragment;


import android.preference.PreferenceActivity;


import java.util.List;

public class MainActivity extends PreferenceActivity {

    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_head, target);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return Fragment1.class.getName().equals(fragmentName)
                || Fragment2.class.getName().equals(fragmentName);
    }
}