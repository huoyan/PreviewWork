package com.zxp.cs.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.cs.R;
import com.zxp.cs.bean.UserBean;

/**
 * Created by cxf on 2018/10/24.
 */

public class PeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();
        UserBean userBean = intent.getParcelableExtra("Constants.USER_BEAN");
        if (userBean == null) {
            return;
        }
    }

}
