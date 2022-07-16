package com.zxp.cs.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.cs.R;
import com.zxp.cs.util.KeyBoardUtils;
import com.zxp.cs.util.SPUtils;
import com.zxp.cs.view.ClearEditText;
import com.zxp.cs.view.ZFlowLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * App 自定义搜索标签布局 测试页面
 */
public class TestZFlowActivity extends AppCompatActivity {

    @BindView(R.id.autoSearch)
    ClearEditText autoSearch;
    @BindView(R.id.button_search)
    Button buttonSearch;
    @BindView(R.id.history_fl)
    ZFlowLayout historyFl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_z_flow);
        ButterKnife.bind(this);
        autoSearch.setFocusable(true);
        autoSearch.setFocusableInTouchMode(true);
        autoSearch.requestFocus();
        InputMethodManager inputManager = (InputMethodManager)autoSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(autoSearch, 0);
    }

    @OnClick(R.id.button_search)
    public void onViewClicked() {

        if (KeyBoardUtils.isSoftShowing(TestZFlowActivity.this)) {
            KeyBoardUtils.hintKeyboard(TestZFlowActivity.this);
        }
        String searchKey = autoSearch.getText().toString();
        if (!isNullorEmpty(searchKey)) {
//            if (RegularUtils.hasEmoji(autoSearch.getText().toString())) {
//                //含有非法字符串
//            } else {
                //搜索
                String keyWord = autoSearch.getText().toString();
                if (!isNullorEmpty(keyWord)) {
                    SPUtils.getInstance(TestZFlowActivity.this).save(autoSearch.getText().toString());
                }
                initHistory();
//            }
        } else {
            //搜索为空
        }

    }

    private boolean isNullorEmpty(String str) {
        return str == null || "".equals(str);
    }
    /**
     * 初始化  历史记录列表
     */
    private void initHistory() {

        final String[] data = SPUtils.getInstance(TestZFlowActivity.this).getHistoryList();
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 10, 10, 10);

        historyFl.removeAllViews();
        for (int i = 0; i < data.length; i++) {
            if (isNullorEmpty(data[i])) {

                return;
            }
            //有数据往下走
            final int j = i;
            //添加分类块
            View paramItemView = getLayoutInflater().inflate(R.layout.adapter_search_keyword, null);
            TextView keyWordTv = paramItemView.findViewById(R.id.tv_content);
            keyWordTv.setText(data[j]);
            historyFl.addView(paramItemView, layoutParams);

            keyWordTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (KeyBoardUtils.isSoftShowing(TestZFlowActivity.this)) {
                        KeyBoardUtils.hintKeyboard(TestZFlowActivity.this);
                    }
                    autoSearch.setText(data[j]);
                    autoSearch.setSelection(data[j].length());//光标在最后
                    if (!isNullorEmpty(data[j])) {
                        SPUtils.getInstance(TestZFlowActivity.this).save(autoSearch.getText().toString());
                    }
                    //点击事件
                }
            });
            // initautoSearch();
        }
    }

    public void tuichu(View view){
        autoSearch.setText("");
        autoSearch.clearFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(autoSearch.getWindowToken(), 0);
        finish();
    }

}
