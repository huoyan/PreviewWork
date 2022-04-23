package com.zxp.myapplication.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.zxp.myapplication.R;
import com.zxp.myapplication.util.UiUtil;


/**
 * 选择去查看发布扫一扫
 */
public class PopupFindSendScan extends PopupWindow {
    private static final String TAG = "PhotoPopupWindow";
    private View mView; // PopupWindow 菜单布局
    private Context mContext; // 上下文参数


    public PopupFindSendScan(Activity context) {
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
        mView = inflater.inflate(R.layout.popup_find_send_san, null);

        // 导入布局
        this.setContentView(mView);
        // 设置动画效果
        this.setAnimationStyle(R.style.popwindow_anim_style);
        this.setWidth((int) (UiUtil.getScreenWidth((Activity) mContext) * 0.4));
        this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置可触
        this.setFocusable(true);

        ColorDrawable dw = new ColorDrawable(0x0000000);
        this.setBackgroundDrawable(dw);
        // 单击弹出窗以外处 关闭弹出窗
//        mView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                int height = mView.findViewById(R.id.layout).getTop();
//                int y = (int) event.getY();
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    if (y < height) {
//                        dismiss();
//                    }
//                }
//                return true;
//            }
//        });
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
                Gravity.TOP|Gravity.RIGHT, UiUtil.dp2px(20), UiUtil.dp2px(160));

        if (mContext instanceof Activity) {
            WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
            lp.alpha = 0.5f; //0.0-1.0
            ((Activity) mContext).getWindow().setAttributes(lp);
        }

    }
}