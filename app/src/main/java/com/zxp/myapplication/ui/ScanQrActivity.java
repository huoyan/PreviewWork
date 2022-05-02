package com.zxp.myapplication.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.hmsscankit.OnLightVisibleCallBack;
import com.huawei.hms.hmsscankit.OnResultCallback;
import com.huawei.hms.hmsscankit.RemoteView;
import com.huawei.hms.ml.scan.HmsScan;
import com.zxp.myapplication.R;

/**
 *   二维码扫描
 */
public class ScanQrActivity extends AppCompatActivity {


    private RemoteView remoteView;
    int mSceenWidth;
    int mSceenHeight;
    View line;

    FrameLayout frameLayout;

    ImageView flushBtn;
    /**
     *   手电筒图片
     */
    private int[] img = {R.mipmap.flashlight_on, R.mipmap.flashlight_off};
    final int SCAN_FRAME_SIZE = 340;
    private TranslateAnimation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scan_qr);
        line = findViewById(R.id.scan_qr_line);
        frameLayout = findViewById(R.id.scan_qr_rim);
        flushBtn = findViewById(R.id.flush_btn);


        //1.设置扫码识别区域，您可以按照需求调整参数
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float density = dm.density;
        //2.获取屏幕尺寸
        mSceenWidth = getResources().getDisplayMetrics().widthPixels;
        mSceenHeight = getResources().getDisplayMetrics().heightPixels;

        int scanFrameSize = (int) (SCAN_FRAME_SIZE * density);

        //3.声明 viewfinder'的 矩形,在布局中间
        //设置扫描区域(可选,矩形可以为空,如果不配置,默认是中心的布局)
        Rect rect = new Rect();
        rect.left = mSceenWidth / 2 - scanFrameSize / 2;
        rect.right = mSceenWidth / 2 + scanFrameSize / 2;
        rect.top = mSceenHeight / 2 - scanFrameSize / 2;
        rect.bottom = mSceenHeight / 2 + scanFrameSize / 2;


        //初始化RemoteView，并通过如下方法设置参数:
        // setContext()（必选）传入context、setBoundingBox()设置扫描区域、
        // setFormat()设置识别码制式，设置完毕调用build()方法完成创建
        remoteView = new RemoteView.Builder().setContext(this).setBoundingBox(rect).setFormat(HmsScan.ALL_SCAN_TYPE).build();
        //将自定义view加载到activity
        remoteView.onCreate(savedInstanceState);

        remoteView.setOnLightVisibleCallback(new OnLightVisibleCallBack() {
            @Override
            public void onVisibleChanged(boolean visible) {
                if(visible){
                    flushBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        remoteView.setOnResultCallback(new OnResultCallback() {
            @Override
            public void onResult(HmsScan[] result) {
                //获取到扫码结果HmsScan，判断结果是否有效
                if (result != null && result.length > 0 && result[0] != null && !TextUtils.isEmpty(result[0].getOriginalValue())) {
                    //成功
                    setVibrator();
                    Intent resultIntent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putInt("result_type",1);
                    bundle.putString("result_string", result[0].originalValue);
                    resultIntent.putExtras(bundle);
                    ScanQrActivity.this.setResult(RESULT_OK, resultIntent);
                    ScanQrActivity.this.finish();

                } else {
                    //失败
                    setVibrator();
                    Intent resultIntent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putInt("result_type", 2);
                    bundle.putString("result_string", "");
                    resultIntent.putExtras(bundle);
                    ScanQrActivity.this.setResult(RESULT_OK, resultIntent);
                    ScanQrActivity.this.finish();


                }
            }
        });
        remoteView.onCreate(savedInstanceState);
        //添加 remoteView 到Framelayout布局中
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        //绑定相机预览布局

        frameLayout.addView(remoteView, params);

        setFlashOperation();
    }
    /**
     *  震动
     */
    private void setVibrator() {

        Vibrator vibrator = (Vibrator)this.getSystemService(this.VIBRATOR_SERVICE);
        vibrator.vibrate(300);
    }

    /**
     *  开启闪光灯
     */
    private void setFlashOperation() {
        flushBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (remoteView.getLightStatus()) {
                    remoteView.switchLight();
                    flushBtn.setImageResource(img[1]);
                } else {
                    remoteView.switchLight();
                    flushBtn.setImageResource(img[0]);
                }
            }
        });
    }
    @Override
    protected void onResume() {

        super.onResume();

        if (remoteView!= null){

            remoteView.onResume();
        }

        if (animation == null){
            animation = new TranslateAnimation(0, 0, 0, 720);
        }

        line.setVisibility(View.VISIBLE);

        animation.setDuration(2000);

        animation.setRepeatCount(-1);

        line.startAnimation(animation);

        animation.start();

    }
    //管理 remoteView 生命周期
    @Override
    protected void onStart() {
        super.onStart();
        if (remoteView!= null){
            remoteView.onStart();
        }

    }

    @Override
    protected void onPause() {

        super.onPause();

        animation.cancel();
        if (remoteView!= null){

            remoteView.onPause();
        }

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        if (remoteView!= null){

            remoteView.onDestroy();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (remoteView!= null){

            remoteView.onStop();
        }
    }


}