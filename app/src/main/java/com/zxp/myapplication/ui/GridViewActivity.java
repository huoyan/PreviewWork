package com.zxp.myapplication.ui;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.zxp.myapplication.R;
import com.zxp.myapplication.adapter.GridViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewActivity extends AppCompatActivity {

    private GridView gridView;

    private List<Map<String, Object>> data_list = new ArrayList<>();
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = { R.mipmap.ic_launcher,  R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,  R.mipmap.ic_launcher,  R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,  R.mipmap.ic_launcher,  R.mipmap.ic_launcher };
    private String[] iconName = { "通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声",
            "设置" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView= findViewById(R.id.djqy);
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.item_grid, from, to);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this,data_list);
        //配置适配器
//        gridView.setAdapter(sim_adapter);
        gridView.setAdapter(gridViewAdapter);

    }

    public List<Map<String, Object>> getData(){
        //cion和iconName的长度是相同的，这里任选其一都可以
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }

}