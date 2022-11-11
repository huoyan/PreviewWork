package com.zxp.cs.util;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class TextViewSpanUtil {

    /**
     * 设置textView结尾...后面显示的文字和颜色
     *
     * @param context    上下文
     * @param textView   textview
     * @param minLines   最少的行数
     * @param originText 原文本
     * @param endText    结尾文字
     * @param endColorID 结尾文字颜色id
     * @param isExpand   当前是否是展开状态
     */
    public static void toggleEllipsize(final Context context,
                                       final TextView textView,
                                       final int minLines,
                                       final String originText,
                                       ClickableSpan jPushSpan,
                                       final String endText,
                                       final int endColorID,
                                       final boolean isExpand) {
        if (TextUtils.isEmpty(originText)) {
            return;
        }
        if (isExpand) {
            textView.setText(originText);
        } else {
            int paddingLeft = textView.getPaddingLeft();
            int paddingRight = textView.getPaddingRight();
            TextPaint paint = textView.getPaint();
            float moreText = paint.measureText("...全部");
            float availableTextWidth = (textView.getWidth() - paddingLeft - paddingRight) *
                    minLines - moreText - 50;
            CharSequence ellipsizeStr = TextUtils.ellipsize(originText, paint,
                    availableTextWidth, TextUtils.TruncateAt.END);
            if (ellipsizeStr.length() < originText.length()) {
                CharSequence temp = ellipsizeStr + endText;
                SpannableString ssb = new SpannableString(temp);
                ssb.setSpan(new ForegroundColorSpan(context.getResources().getColor
                                (endColorID)),
                        temp.length() - endText.length(), temp.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);


                ssb.setSpan(jPushSpan, ellipsizeStr.length()
                        , ellipsizeStr.length() + 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.setText(ssb);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                textView.setText(originText);
            }
        }
    }

}