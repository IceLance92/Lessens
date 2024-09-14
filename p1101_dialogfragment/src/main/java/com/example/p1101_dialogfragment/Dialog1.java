package com.example.p1101_dialogfragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Dialog1 extends DialogFragment implements View.OnClickListener {

    final String LOG_TAG = "myLogs";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog1, null);
        view.findViewById(R.id.btnYes).setOnClickListener(this);
        view.findViewById(R.id.btnNo).setOnClickListener(this);
        view.findViewById(R.id.btnMaybe).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Log.d(LOG_TAG, "Dialog 1: " + ((Button) view).getText());
        dismiss();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "Dialog 1: onDismiss");
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }
}
