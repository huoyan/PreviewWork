package com.zxp.myapplication.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.myapplication.R;
import com.zxp.myapplication.util.SpannableStringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 进行可变字符串的视图显示
 */
public class ApannableStringActivity extends AppCompatActivity {

    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.text2)
    TextView text2;
    @BindView(R.id.text3)
    TextView text3;
    @BindView(R.id.text4)
    TextView text4;
    @BindView(R.id.text5)
    TextView text5;
    @BindView(R.id.text6)
    TextView text6;
    @BindView(R.id.text7)
    TextView text7;
    @BindView(R.id.text8)
    TextView text8;
    @BindView(R.id.text9)
    TextView text9;
    @BindView(R.id.edit1)
    EditText edit1;
    @BindView(R.id.edit2)
    EditText edit2;
    @BindView(R.id.button1)
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apannable_string_setting);
        ButterKnife.bind(this);
        initViewData();
    }

    private void initViewData() {
        setText1();
        setText2();
        setText3();
        setText4();
        setText5();
        setText6();
        setText7();
        setText8();
        setText9();
        setEdit1();
    }

    private void setEdit1() {
        SpannableString ss = new SpannableString("其实我是三方:周小平");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getColor(R.color.colorPrimary));
        ss.setSpan(foregroundColorSpan, 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        edit1.setText(ss);

    }

    //修改字颜色
    private void setText1() {
        SpannableString ss = new SpannableString("其实我是一个好人");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getColor(R.color.colorPrimary));
        ss.setSpan(foregroundColorSpan, 2, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text1.setText(ss);
    }

    //背景颜色
    private void setText2() {
        SpannableString ss = new SpannableString("其实我是一个好人");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getColor(R.color.colorPrimary));
        ss.setSpan(foregroundColorSpan, 2, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(getColor(R.color.colorAccent));
        ss.setSpan(backgroundColorSpan, 2, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text2.setText(ss);
    }

    //下划线和删除线
    private void setText3() {
        SpannableString ss = new SpannableString("其实我是一个好人");
        UnderlineSpan underlineSpan = new UnderlineSpan();//下划线span
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();//删除线
        ss.setSpan(underlineSpan, 3, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(strikethroughSpan, 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text3.setText(ss);
    }

    //变大
    private void setText4() {
        SpannableString ss = new SpannableString("其实我是一个好人");
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(30, true);
        ss.setSpan(absoluteSizeSpan, 3, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text4.setText(ss);
    }

    //缩小
    private void setText9() {
        SpannableString ss = new SpannableString("其实我是一个好人");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.5f);
        ss.setSpan(relativeSizeSpan, 3, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text9.setText(ss);
    }

    //加粗
    private void setText5() {
        SpannableString ss = new SpannableString("其实我是一个好人");
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
        ss.setSpan(styleSpan, 3, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text5.setText(ss);
    }

    //上标
    private void setText6() {
        SpannableString ss = new SpannableString("其实我是一个好人");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();//上标
        SubscriptSpan subscriptSpan = new SubscriptSpan();//下标
        //ss.setSpan(superscriptSpan,3,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(subscriptSpan, 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text6.setText(ss);
    }

    //图片
    private void setText7() {
        SpannableString ss = new SpannableString("其实我是一个好人");
        ImageSpan imageSpan = new ImageSpan(this, R.mipmap.ic_launcher);
        ss.setSpan(imageSpan, 2, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text7.setText(ss);
    }

    //点击事件
    private void setText8() {
        SpannableString ss = new SpannableString("其实我是一个好人");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(ApannableStringActivity.this, "点击了", Toast.LENGTH_SHORT).show();
            }
        };
        ss.setSpan(clickableSpan, 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text8.setText(ss);
        text8.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @OnClick(R.id.button1)
    public void onViewClicked() {

        SpannableString spannableString = SpannableStringUtil.getSpan(edit1,edit1.getText().toString());
        SpannableStringBuilder builder =  new SpannableStringBuilder();
        int index = edit2.getSelectionStart();
        Editable editable = edit2.getEditableText();
        editable.insert(index, spannableString);
        builder.append(edit2.getEditableText());
//        builder.append(spannableString);
        edit2.setText(builder);
//        edit2.setText(spannableString);
    }
}
