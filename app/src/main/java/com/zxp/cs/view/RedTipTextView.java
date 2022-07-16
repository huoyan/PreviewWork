package com.zxp.cs.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.TextView;

import com.zxp.cs.R;
import com.zxp.cs.util.SystemUtils;
import com.zxp.cs.util.UiUtil;

/**
 * textView上的小红点
 *
 * @author Visual
 */
@SuppressLint("AppCompatCustomView")
public class RedTipTextView extends TextView {
    public static final int RED_TIP_INVISIBLE = 0;
    public static final int RED_TIP_VISIBLE = 1;
    public static final int RED_TIP_GONE = 2;
    private int tipVisibility = 0;

    public RedTipTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        init(null);
    }

    public RedTipTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        init(attrs);
    }

    public RedTipTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.RedTipTextView);
            tipVisibility = array.getInt(R.styleable.RedTipTextView_redTipsVisibility, 0);
            array.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        if (tipVisibility == 1) {
//            int width = getWidth();
//            int paddingRight = getPaddingRight();
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setStyle(Style.FILL_AND_STROKE);
            float x = SystemUtils.getTextViewSelectionBottomRightx(this, getText().length());
            float y = SystemUtils.getTextViewSelectionBottomY(this, getText().length());
            canvas.drawCircle(x + UiUtil.dp2px(20), y - UiUtil.dp2px(2), UiUtil.dp2px(3), paint);
        }
    }

    public void setVisibility(int visibility) {
        tipVisibility = visibility;
        invalidate();
    }
}