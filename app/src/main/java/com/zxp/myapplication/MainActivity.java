package com.zxp.myapplication;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.growingio.android.sdk.collection.GrowingIO;
import com.zxp.myapplication.ui.ApannableStringActivity;
import com.zxp.myapplication.ui.ButtonTestActivity;
import com.zxp.myapplication.ui.CjsTestActivity;
import com.zxp.myapplication.ui.GridViewActivity;
import com.zxp.myapplication.ui.PopUpTestActivity;
import com.zxp.myapplication.ui.ProgressActivity;
import com.zxp.myapplication.ui.RatingBarTestActivity;
import com.zxp.myapplication.ui.ScanQrActivity;
import com.zxp.myapplication.ui.SwitchActivity;
import com.zxp.myapplication.ui.TestZFlowActivity;
import com.zxp.myapplication.util.SystemUtils;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public static int REQUEST_CODE = 0x11;
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
    @BindView(R.id.to_button)
    TextView toButton;
    @BindView(R.id.to_cjs)
    TextView toCjs;
    @BindView(R.id.to_saoyisao)
    TextView toSaoyisao;
    @BindView(R.id.to_rating_bar)
    TextView toRatingBar;
    @BindView(R.id.to_switch)
    TextView toSwitch;
    @BindView(R.id.to_progress)
    TextView toProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //测试埋点
        GrowingIO.getInstance().setPageName(this, "MainActivity");
    }

    @OnClick({R.id.sslsjl, R.id.app_set, R.id.apannable, R.id.to_popup, R.id.to_ck,
            R.id.to_cjs,R.id.to_saoyisao, R.id.to_button, R.id.to_rating_bar
            ,R.id.to_switch,R.id.to_progress})
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

                break;
            }
            case R.id.to_cjs: {
                Intent intent=new Intent();
                intent.setClass(this, CjsTestActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.to_saoyisao: {
                //申请权限
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE);

                break;
            }
            case R.id.to_button: {
                Intent intent=new Intent();
                intent.setComponent(new ComponentName(this, ButtonTestActivity.class));
                startActivity(intent);
                break;
            }
            case R.id.to_rating_bar: {
                Intent intent = new Intent(this, RatingBarTestActivity.class);
                startActivity(intent);

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
            case R.id.to_switch: {
                Intent intent = new Intent(this, SwitchActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.to_progress: {
                Intent intent = new Intent(this, ProgressActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (permissions == null || grantResults == null) {
            return;
        }
        if (grantResults.length < 2 || grantResults[0] != PackageManager.PERMISSION_GRANTED || grantResults[1] != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        if (requestCode == REQUEST_CODE) {
            //权限申请成功，跳转到自定义扫码页面
            Intent intent = new Intent(MainActivity.this, ScanQrActivity.class);

            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    //     处理扫码结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt("result_type") == 1) {
                    String result = bundle.getString("result_string");
                    Log.e("扫描结果" , "result:"+result);

                } else if (bundle.getInt("result_type") == 2) {
                    Log.e("扫描结果" , "扫描失败:");
                }
            }
        }
    }


    public void toGrid(View view){
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }

}
