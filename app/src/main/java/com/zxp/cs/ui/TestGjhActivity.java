package com.zxp.cs.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.cs.R;

import java.util.Locale;

public class TestGjhActivity extends AppCompatActivity {
    String str = "en"; //得到目前点击的语言环境 "zh" "en" 等
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_gjh);
    }

    public void toChange(View view) {
        str = "en";
        refreshLanguage();
    }
    public void toChange2(View view) {
        str = "zh";
        refreshLanguage();
    }


    //刷新显示配置
    public void refreshLanguage() {

        Resources localResources = getResources();  // 创建Resources对象
        //如果本地语言不等于现在的语言环境
        // 得到一个 配置Configuration对象
        Configuration localConfiguration = getUpdateLocalConfig(str);
        //得到自定义资源的对象
        DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
        //资源对象更新配置文件
        localResources.updateConfiguration(localConfiguration, localDisplayMetrics);
        recreate();
    }

    /**
     * 创建Configuration
     *
     * @param language
     * @return
     */
    public Configuration getUpdateLocalConfig(String language) {
        //得到本地资源配置对象
        Configuration localConfiguration = this.getResources().getConfiguration();
        //得到最新的语言环境Locale
        Locale localLocale = getLocale(language);
        //资源配置对象设置语言环境
        localConfiguration.locale = localLocale;
        return localConfiguration;
    }

    //创建新的Locale并覆盖原Locale
    public Locale getLocale(String language) {
        //根据传进来的语言 生成一个语言环境Locale
        Locale localeLocale = new Locale(language);
        //将传进来的语言环境变成本地默认的，进行更换前的准备，返回这个语言环境Locale
        Locale.setDefault(localeLocale);
        return localeLocale;
    }
}