package com.zxp.cs.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zxp.cs.ui.fragment.BlankFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override

    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new BlankFragment("页面一");
            case 1:
                return new BlankFragment("页面二");
            default:
                return new BlankFragment("页面三");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

