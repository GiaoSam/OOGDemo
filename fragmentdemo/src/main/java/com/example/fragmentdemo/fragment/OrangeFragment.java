package com.example.fragmentdemo.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentdemo.R;

/**
 * Created by johnson on 17-9-6.
 */

public class OrangeFragment extends Fragment {
    private String title;
    private int page;

    // newIntance constructor for creating fragment with arguments
    public static OrangeFragment newInstance(int page, String title) {
        OrangeFragment orangeFragment = new OrangeFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        orangeFragment.setArguments(args);
        return orangeFragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.orange_fragment, container, false);
//        TextView tv = (TextView) view.findViewById(R.id.loading_text);
//        tvLabel.setText(page + " -- " + title);
        return view;
    }
}
