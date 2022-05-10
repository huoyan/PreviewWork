package com.zxp.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxp.myapplication.R;

import java.util.List;
import java.util.Map;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> listitem;

    public GridViewAdapter(Context context,List<Map<String, Object>> listitem) {
        this.context = context;
        this.listitem = listitem;
    }

    @Override
    public int getCount() {
        return listitem.size();
    }

    @Override
    public Object getItem(int position) {
        return listitem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_grid, null);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        TextView textView = (TextView) convertView.findViewById(R.id.text);

        Map<String, Object> map = listitem.get(position);
        imageView.setImageResource((Integer) map.get("image"));

        textView.setText(map.get("text") + "");
        return convertView;
    }

}
