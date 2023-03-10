package com.zxp.cs.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.cs.R;

public class ThreadExceptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_exception);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int ii = 10 / 0;
            }
        });
        thread.start();
    }
}