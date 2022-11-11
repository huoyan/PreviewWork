package com.zxp.cs.ui;

import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.cs.R;
import com.zxp.cs.util.TextViewSpanUtil;

public class TextSsActivity extends AppCompatActivity {

    private TextView content;
    private TextView sure;
    private EditText shuru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_ss);
        content = findViewById(R.id.content);
        sure = findViewById(R.id.sure);
        shuru = findViewById(R.id.shuru);

        sure.setOnClickListener(v -> {
            content.setText(shuru.getText());
            setMaxLines(3);
        });

    }

    private void setMaxLines(int maxLines) {
        ClickableSpan jPushSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                content.setMaxLines(Integer.MAX_VALUE);
                setMaxLines(100);
            }

            //去除连接下划线
            @Override
            public void updateDrawState(TextPaint ds) {
                /**set textColor**/
                ds.setColor(TextSsActivity.this.getColor(R.color.blue));
                /**Remove the underline**/
                ds.setUnderlineText(false);
            }
        };

        TextViewSpanUtil.toggleEllipsize(this,
                content, maxLines,
                shuru.getText().toString(), jPushSpan,
                "全文",
                R.color.blue, false);
    }
}