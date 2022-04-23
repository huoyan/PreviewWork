package com.zxp.myapplication.view;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zxp.myapplication.R;
import com.zxp.myapplication.util.UiUtil;


/**
 * 选择去导航弹框
 */
public class AppraiseRatingBarDialog extends BottomSheetDialog {

    private Context context;


    public AppraiseRatingBarDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mView = inflater.inflate(R.layout.dialog_appraise_layout, null);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        setContentView(mView,params);
//        getWindow().setLayout((int) (UiUtil.getScreenWidth((Activity) context) * 0.8), WindowManager.LayoutParams.WRAP_CONTENT);


//        getWindow().setAttributes(params);
    }

    public AppraiseRatingBarDialog(@NonNull Context context, int theme) {
        super(context, theme);
    }

    protected AppraiseRatingBarDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }



    public void show(Activity activity, Location location) {
        findViewById(R.id.cancel_button).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "腾讯地图");
            dismiss();
        });
        findViewById(R.id.content_1).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "高德地图");
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.gravity = Gravity.BOTTOM;
            params.width = (int) (UiUtil.getScreenWidth((Activity) context) * 0.8);
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.verticalMargin = -50;
            getWindow().setAttributes(params);
//            getWindow().setLayout((int) (UiUtil.getScreenWidth((Activity) context) * 0.8), ViewGroup.LayoutParams.WRAP_CONTENT);

        });
        findViewById(R.id.content_2).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "百度地图");
            dismiss();
        });
        findViewById(R.id.content_3).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "百度地图");
            dismiss();
        });
        findViewById(R.id.content_4).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "百度地图");
            dismiss();
        });
        findViewById(R.id.content_5).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "百度地图");
            dismiss();
        });
        findViewById(R.id.content_6).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "百度地图");
            dismiss();
        });

        findViewById(R.id.submit).setOnClickListener((v) -> {
            dismiss();
        });

        show();
    }
}