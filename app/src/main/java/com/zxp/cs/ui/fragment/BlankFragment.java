package com.zxp.cs.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.zxp.cs.R;

public class BlankFragment extends Fragment {


    private AppCompatTextView mLeftMenu;
    private String name;

    public BlankFragment(String name) {
        this.name = name;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        mLeftMenu = (AppCompatTextView) view.findViewById(R.id.tvTitle);
        mLeftMenu.setText(name);
        mLeftMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                        name,
                        Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
