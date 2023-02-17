package com.example.demo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new ChatFragment();
        }
        else if(position == 1){
            return new StatusFragment();
        }
        else if(position == 2){
            return new CallFragment();
        }
        else {
            return new ProfileFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "chats";
        }
        else if(position == 1){
            return "status";
        }
        else if(position == 2){
            return "calls";
        }
        else {
            return "Profile";
        }
    }
}
