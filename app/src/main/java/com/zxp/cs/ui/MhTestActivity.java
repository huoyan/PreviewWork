package com.zxp.cs.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.cs.R;
import com.zxp.cs.util.FastBlur;

public class MhTestActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh_test);

        imageView = findViewById(R.id.img);
        Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.white1);
        Bitmap bitmap = FastBlur.blurBitmap(this,bmp1,24f);

        imageView.setImageBitmap( bitmap);
        imageView.setAlpha(0.5f);
    }
}