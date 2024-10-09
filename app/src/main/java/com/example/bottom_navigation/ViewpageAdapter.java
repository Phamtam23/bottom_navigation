package com.example.bottom_navigation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewpageAdapter extends FragmentStateAdapter {

    private final Fragment[] fragments;

    public ViewpageAdapter(@NonNull FragmentActivity fragmentActivity, Fragment[] fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int index) {
        return fragments[index];
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
