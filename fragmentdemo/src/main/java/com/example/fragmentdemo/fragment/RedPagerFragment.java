package com.example.fragmentdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ToxicBakery.viewpager.transforms.*;
import com.astuetz.PagerSlidingTabStrip;
import com.example.fragmentdemo.R;
import com.example.fragmentdemo.adapter.MyPagerAdapter;

/**
 * Created by johnson on 17-9-6.
 */

public class RedPagerFragment extends Fragment {

    private FragmentPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private PagerSlidingTabStrip tabsStrip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_layout, container, false);

        // 初始化 ViewPager
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPagerAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(1);
        // Animating the Scroll with PageTransformer:
        // Other transform types include AccordionTransformer, CubeInTransformer, RotateUpTransformer
        // ZoomInTransformer, FlipHorizontalTransformer, ScaleInOutTransformer and many others.
        viewPager.setPageTransformer(true, new CubeOutTransformer());

        // Give the PagerSlidingTabStrip the ViewPager
        tabsStrip = (PagerSlidingTabStrip) view.findViewById(R.id.viewPagerTabs);
        // Attach the view pager to the tab strip
        tabsStrip.setViewPager(viewPager);
        return view;
    }
}
