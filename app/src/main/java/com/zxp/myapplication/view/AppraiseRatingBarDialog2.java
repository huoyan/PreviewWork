package com.zxp.myapplication.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.zxp.myapplication.R;
import com.zxp.myapplication.util.UiUtil;


/**
 * 选择去导航弹框
 */
public class AppraiseRatingBarDialog2 extends PopupWindow {
    private static final String TAG = "PhotoPopupWindow";
    private View mView; // PopupWindow 菜单布局
    private Context mContext; // 上下文参数


    public AppraiseRatingBarDialog2(Activity context) {
        super(context);
        this.mContext = context;
        Init();
    }

    /**
     * 设置布局以及点击事件
     */
    private void Init() {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        mView = inflater.inflate(R.layout.dialog_appraise_layout, null);

        // 导入布局
        this.setContentView(mView);
        // 设置动画效果
//        this.setAnimationStyle(R.style.popwindow_anim_style);
        this.setWidth((int) (UiUtil.getScreenWidth((Activity) mContext) * 0.9));
        this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置可触
        this.setFocusable(true);

        ColorDrawable dw = new ColorDrawable(0x0000000);
        this.setBackgroundDrawable(dw);
        // 单击弹出窗以外处 关闭弹出窗
        mView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int height = mView.findViewById(R.id.layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
    }

    public void dismiss(){
        super.dismiss();
        if (mContext instanceof Activity) {

            WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
            lp.alpha = 1f; //0.0-1.0
            ((Activity) mContext).getWindow().setAttributes(lp);
        }
    }

    public void show(View rootView){
        showAtLocation(rootView,
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, UiUtil.dp2px(80));

        if (mContext instanceof Activity) {

            WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
            lp.alpha = 0.5f; //0.0-1.0
            ((Activity) mContext).getWindow().setAttributes(lp);
        }
        mView.findViewById(R.id.cancel_button).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "腾讯地图");
            dismiss();
        });
        mView.findViewById(R.id.content_1).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "高德地图");


        });
        mView.findViewById(R.id.content_2).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "百度地图");
            dismiss();
        });
        mView.findViewById(R.id.content_3).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "百度地图");
            dismiss();
        });
        mView.findViewById(R.id.content_4).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "百度地图");
            dismiss();
        });
        mView.findViewById(R.id.content_5).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "百度地图");
            dismiss();
        });
        mView.findViewById(R.id.content_6).setOnClickListener((v) -> {
//            Tools.toNavigation(activity, location, "百度地图");
            dismiss();
        });

        mView.findViewById(R.id.submit).setOnClickListener((v) -> {
            dismiss();
        });
    }
}