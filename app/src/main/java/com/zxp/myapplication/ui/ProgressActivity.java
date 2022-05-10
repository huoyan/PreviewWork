package com.zxp.myapplication.ui;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.myapplication.R;

public class ProgressActivity extends AppCompatActivity {

    private SeekBar seek_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        seek_bar = findViewById(R.id.seek_bar);
        seek_bar.setClickable(false);
        seek_bar.setFocusable(false);
        seek_bar.setEnabled(false);
    }
}