package com.app.lobotustask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.app.lobotustask.databinding.ActivityScreenOneBinding;
import com.app.lobotustask.databinding.ActivityScreenTwoBinding;

public class ScreenTwoActivity extends AppCompatActivity {
ActivityScreenTwoBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityScreenTwoBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);
      b.mcClient1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomFragment.newInstance("","").show(
                        (ScreenTwoActivity.this).getSupportFragmentManager(), "fragment");
            }
        });
        b.mcClient2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomFragment.newInstance("","").show(
                        (ScreenTwoActivity.this).getSupportFragmentManager(), "fragment");
            }
        });

    }
}