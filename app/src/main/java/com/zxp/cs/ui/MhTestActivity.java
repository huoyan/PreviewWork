package com.zxp.cs.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.zxp.cs.R;
import com.zxp.cs.util.FastBlur;

//模糊处理
public class MhTestActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageViewb;
    ConstraintLayout layout;
    TextView textView;
    private Handler handler = new Handler();

    private Runnable task = new Runnable() {
        public void run() {

//            try {


            // TODOAuto-generated method stub
            handler.postDelayed(this, 100);//设置延迟时间，此处是5秒
            //需要执行的代码
//            Bitmap bmp2 = getBitmap(textView);

            //获取当前屏幕的大小
            int width = getWindow().getDecorView().getRootView().getWidth();
            int height = getWindow().getDecorView().getRootView().getHeight();
            if (width<=0){
                return;
            }
            //生成相同大小的图片（用来存储截屏后生成的bitmap对象）
            Bitmap temBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            //找到当前页面的根布局（需要截屏的View）
            View view = layout;
            //设置缓存
//            view.setDrawingCacheEnabled(false);
            view.buildDrawingCache();
            //从缓存中获取当前屏幕的图片
//            temBitmap = view.getDrawingCache().copy(Bitmap.Config.ARGB_8888, false);
            temBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),
                    Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(temBitmap);
            view.draw(canvas);
//            Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.appraise_content_gray_bg_unselected);
            if (temBitmap != null) {
                Bitmap bitmap = FastBlur.blurBitmap(MhTestActivity.this,width, temBitmap, 24f);


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                        imageView.setAlpha(0.8f);
                    }
                });

            }
//            } catch (Exception e) {
//
//            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_test);

        textView = findViewById(R.id.text);
        imageView = findViewById(R.id.img);
        imageViewb = findViewById(R.id.imgk);
        layout = findViewById(R.id.layout);

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.post(task);//立即调用
            }
        }).start();

    }

    private Bitmap getBitmap(View v) {
        if (v.getWidth() <= 0) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        v.draw(canvas);
        return bitmap;
    }
}