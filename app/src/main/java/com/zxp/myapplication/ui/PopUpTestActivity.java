package com.zxp.myapplication.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.myapplication.R;
import com.zxp.myapplication.view.PopupFindSendScan;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopUpTestActivity extends AppCompatActivity {

    @BindView(R.id.test1)
    TextView textView1;
    private PopupFindSendScan popupFindSendScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_test);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.test1})
    public void onViewClicked(View view) {
        popupFindSendScan = new PopupFindSendScan(this);

//        popupFindSendScan.setFocusable(false);
//        popupFindSendScan.setOutsideTouchable(false);
        popupFindSendScan.show(textView1);
    }
}