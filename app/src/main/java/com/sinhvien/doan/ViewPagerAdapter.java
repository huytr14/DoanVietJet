package com.sinhvien.doan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment>fragmentArrayList=new ArrayList<>();
    private final ArrayList<String>fragmentTitle=new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CHistoryFragment();
            case 1:
                return new DpFragment();
            default:
                return new CHistoryFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int postion){
        String title="";
        switch (postion){
            case 0:
                title="HISTORY";
                break;
            case 1:
                title="DEPARTING SOON";
                break;
        }
        return title;
    }
}
