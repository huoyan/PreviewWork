package com.zxp.cs.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.Layout;
import android.widget.TextView;

public class SystemUtils {

    /**
     * 跳转到权限设置界面
     */
    public static void getAppDetailSettingIntent(Context context){
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if(Build.VERSION.SDK_INT >= 9){
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        } else if(Build.VERSION.SDK_INT <= 8){
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName("com.android.settings","com.android.settings.InstalledAppDetails");
            intent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
        }
        context.startActivity(intent);
    }

    /**
     * 获取TextView某一个字符的坐标
     *
     * @parms tv
     * @parms index 字符下标
     * @return 返回的是相对坐标
     */
    public static int getTextViewSelectionBottomY(TextView tv, int index) {
        Layout layout = tv.getLayout();
        Rect bound = new Rect();
        int line = layout.getLineForOffset(index);
        layout.getLineBounds(line, bound);
        int yAxisBottom = bound.bottom;//字符底部y坐标
//        int yAxisTop = bound.top;//字符顶部y坐标
//        float xAxisLeft = layout.getPrimaryHorizontal(index);//字符左边x坐标
//        float xAxisRight = layout.getSecondaryHorizontal(index);//字符右边x坐标

        return yAxisBottom;

    }

    /**
     * 获取TextView某一个字符的坐标
     *
     * @parms tv
     * @parms index 字符下标
     * @return 返回的是相对坐标
     */
    public static float getTextViewSelectionBottomRightx(TextView tv,int index) {
        Layout layout = tv.getLayout();
        Rect bound = new Rect();
        int line = layout.getLineForOffset(index);
        layout.getLineBounds(line, bound);
//        int yAxisBottom = bound.bottom;//字符底部y坐标
//        int yAxisTop = bound.top;//字符顶部y坐标
//        float xAxisLeft = layout.getPrimaryHorizontal(index);//字符左边x坐标
        float xAxisRight = layout.getSecondaryHorizontal(index);//字符右边x坐标

        return  xAxisRight;

    }


}
