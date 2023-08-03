package com.app.lobotustask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.app.lobotustask.databinding.ActivityScreenOneBinding;
import com.app.lobotustask.databinding.ActivityScreenThreeBinding;

public class ScreenThreeActivity extends AppCompatActivity {
    ActivityScreenThreeBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityScreenThreeBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.state_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        b.spState.setAdapter(adapter);
    }
}