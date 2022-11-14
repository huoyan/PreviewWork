package com.zxp.cs.util; /**
 * Created by Lee on 2018/4/26.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class FastBlur {

    //图片缩放比例
    private static final float BITMAP_SCALE = 0.4f;

    /**
     * 模糊图片的具体方法
     *
     * @param context 上下文对象
     * @param image   需要模糊的图片
     * @return 模糊处理后的图片
     */
    public static Bitmap blurBitmap(Context context,int width, Bitmap image, float blurRadius) {
        //创建一个缩小后的bitmap
        Bitmap inputBitmap = Bitmap.createScaledBitmap(image, width, 200, false);
        //创建将在ondraw中使用到的经过模糊处理后的bitmap
        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap);

        //创建RenderScript，ScriptIntrinsicBlur固定写法
        RenderScript rs = RenderScript.create(context);
        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));

        //根据inputBitmap，outputBitmap分别分配内存
        Allocation tmpIn = Allocation.createFromBitmap(rs, inputBitmap);
        Allocation tmpOut = Allocation.createFromBitmap(rs, outputBitmap);

        //设置模糊半径取值0-25之间，不同半径得到的模糊效果不同
        blurScript.setRadius(15);
        blurScript.setInput(tmpIn);
        blurScript.forEach(tmpOut);

        //得到最终的模糊bitmap
        tmpOut.copyTo(outputBitmap);
        return outputBitmap;
    }
}
