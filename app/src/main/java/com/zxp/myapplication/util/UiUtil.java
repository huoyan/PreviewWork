package com.zxp.myapplication.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.zxp.myapplication.AppApplication;


public class UiUtil {

//    public static int sPlaceholderImage = R.drawable.shape_place_holder;

    public static int sScreenWidth = 0;
    public static int sScreenHeight = 0;

    public static int dp2px(double dp) {
        float scale = AppApplication.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }




    /**
     * 获取腾讯云图片存储缩略图url
     * 1 宽=高=屏幕宽
     * 2 宽=高=屏幕/2 /3
     * 3 宽=屏幕 高=宽/2
     * 88 文章详情页缩略图
     * 99 微信分享缩略图
     */
    public static String getTencentThumbUrl(String url, int mode) {
        if (mode == 1) {
            return url + "?imageView2/5/w/" + UiUtil.dp2px(240) + "/h/" + UiUtil.dp2px(240);
        } else if (mode == 2) {
            return url + "?imageView2/5/w/" + UiUtil.dp2px(120) + "/h/" + UiUtil.dp2px(120);
        } else if (mode == 3) {
            return url + "?imageView2/1/w/" + UiUtil.dp2px(240) + "/h/" + UiUtil.dp2px(120);
        } else if (mode == 888) {
            return url + "?imageView2/1/w/" + UiUtil.dp2px(120) + "/h/" + UiUtil.dp2px(120);
        } else if (mode == 99) {
            return url + "?imageView2/5/w/" + 120 + "/h/" + 120;
        } else {
            return url;
        }
    }


    /**
     * 显示键盘
     */
    public static void showKeyboard(EditText view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, 0);
    }

    /**
     * 隐藏键盘
     */
    public static void hideKeyboard(Activity context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        View v = context.getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    public static void setImmerseLayout(Activity context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = context.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.clearFlags(
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
                );
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }
    }

    public static int getStatusBarHeight() {
        try {
            Resources resources = AppApplication.getInstance().getResources();
            int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
            return resources.getDimensionPixelSize(resourceId);
        } catch (Exception ignore) {
            return dp2px(25.0);
        }
    }

    public static int getScreenWidth(Activity context) {
        if (sScreenWidth == 0) {
            DisplayMetrics metrics = new DisplayMetrics();
            context.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
            sScreenWidth = metrics.widthPixels;
        }
        return sScreenWidth;
    }

    public static int getScreenHeight(Activity context) {
        if (sScreenHeight == 0) {
            DisplayMetrics metrics = new DisplayMetrics();
            context.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
            sScreenHeight = metrics.heightPixels;
        }
        return sScreenHeight;
    }


    public static SpannableStringBuilder foregroundColorSpan(String content, int start, int end, int colorId) {
        if (end > content.length()) end = content.length();
        SpannableStringBuilder ssb = new SpannableStringBuilder(content);
        ssb.setSpan(new ForegroundColorSpan(colorId), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }


}