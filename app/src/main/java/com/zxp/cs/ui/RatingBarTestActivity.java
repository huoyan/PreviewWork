package com.zxp.cs.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.cs.R;
import com.zxp.cs.view.AppraiseRatingBarDialog2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 评分弹出框测试页面
 */
public class RatingBarTestActivity extends AppCompatActivity {

    @BindView(R.id.rating_bar)
    RatingBar ratingBar;
    @BindView(R.id.pltc)
    Button pltc;
    private AppraiseRatingBarDialog2 dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar_test);

        ButterKnife.bind(this);

        ratingBar.setRating(3);
        ratingBar.setStepSize(1);
        ratingBar.setMax(10);
        ratingBar.setNumStars(8);
    }

    @OnClick({R.id.pltc})
    public void OnClick(View view){

        switch (view.getId()){
            case R.id.pltc:{
                dialog = new AppraiseRatingBarDialog2(this);
                View rootView = LayoutInflater.from(this).inflate(R.layout.activity_rating_bar_test, null);

                dialog.setFocusable(false);
                dialog.setOutsideTouchable(false);
                dialog.show(rootView);
                break;
            }
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event){
        if(dialog!=null&&dialog.isShowing()){
            return false;
        }
        return super.dispatchTouchEvent(event);
    }
}