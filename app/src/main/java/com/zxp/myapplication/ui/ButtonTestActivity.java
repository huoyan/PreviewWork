package com.zxp.myapplication.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.myapplication.R;
import com.zxp.myapplication.view.RedTipTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 背景渐变和自定义右上角小红点
 */
public class ButtonTestActivity extends AppCompatActivity {

    @BindView(R.id.test1)
    RedTipTextView test1;
    @BindView(R.id.button1)
    TextView button1;
    @BindView(R.id.edit1)
    TextView edit1;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_test);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1: {
                i++;
                test1.setVisibility(i / 2);
                test1.setText(edit1.getText());
                break;
            }
        }
    }
}