package com.zxp.cs.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.zxp.cs.R;

public class VideiTestActivity extends AppCompatActivity {

    PlayerView play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videi_test);//视频网址
        String url="http://ips.ifeng.com/video19.ifeng.com/video09/2014/06/16/1989823-102-086-0009.mp4";
        play = new PlayerView(this)
                .setTitle("欧耶")//视频名称
                .setScaleType(PlayStateParams.fillparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(url);
        play.startPlay();

    }
    @Override
    protected void onStop() {
        super.onStop();
        play.stopPlay();
    }
}

