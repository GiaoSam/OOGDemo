package com.example.fragmentdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.fragmentdemo.fragment.OrangeFragment;
import com.example.fragmentdemo.fragment.PinkFragment;
import com.example.fragmentdemo.fragment.RedFragment;

/**
 * Created by johnson on 17-9-6.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;
    private String[] tabTitles = new String[] {"Pink", "Red", "Orange"};

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Returns the fragment to display for that page
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PinkFragment.newInstance(0, "Pink");
            case 1:
                return RedFragment.newInstance(1, "Red");
            case 2:
                return OrangeFragment.newInstance(2, "Orange");
            default:
                return null;
        }
    }

    /**
     * Returns total number of pages
     * @return
     */
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}