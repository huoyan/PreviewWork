package com.zxp.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.growingio.android.sdk.collection.GrowingIO;
import com.zxp.myapplication.ui.ApannableStringActivity;
import com.zxp.myapplication.ui.PopUpTestActivity;
import com.zxp.myapplication.ui.TestZFlowActivity;
import com.zxp.myapplication.util.SystemUtils;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sslsjl)
    TextView sslsjl;
    @BindView(R.id.app_set)
    TextView appSet;
    @BindView(R.id.apannable)
    TextView apannable;
    @BindView(R.id.to_popup)
    TextView toPopup;
    @BindView(R.id.to_ck)
    TextView toCk;
    @BindView(R.id.to_rating_bar)
    TextView toRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        GrowingIO.getInstance().setPageName(this, "MainActivity");
    }

    @OnClick({R.id.sslsjl, R.id.app_set, R.id.apannable, R.id.to_popup, R.id.to_ck, R.id.to_rating_bar})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.sslsjl: {
                Intent intent = new Intent(this, TestZFlowActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.app_set: {
                SystemUtils.getAppDetailSettingIntent(this);
                break;
            }
            case R.id.apannable: {
                Intent intent = new Intent(this, ApannableStringActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.to_popup: {
                Intent intent = new Intent(this, PopUpTestActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.to_ck: {
                Intent intent=new Intent();
                intent.setComponent(new ComponentName(this, cn.com.changan.nev.MainActivity.class));
                startActivity(intent);
                break;
            }
            case R.id.to_rating_bar: {
//                Intent intent = new Intent(this, RatingBarTestActivity.class);
//                startActivity(intent);

                GrowingIO.getInstance().setUserId(Math.random()+"");
                GrowingIO.getInstance().track("ceshi");
                GrowingIO.getInstance().track("dianjishu");
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("djs",10);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                GrowingIO.getInstance().track("ceshi",jsonObject);
                break;
            }
        }
    }

}
