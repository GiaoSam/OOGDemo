package com.example.fragmentdemo.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentdemo.R;

/**
 * Created by johnson on 17-9-6.
 */

public class PinkFragment extends Fragment {

    // Store instance variables
    private String title;
    private int page;

    // newIntance constructor for creating fragment with arguments
    public static PinkFragment newInstance(int page, String title) {
        PinkFragment pinkFragment = new PinkFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        pinkFragment.setArguments(args);
        return pinkFragment;
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
        View view = inflater.inflate(R.layout.pink_fragment, container, false);
//        TextView tv = (TextView) view.findViewById(R.id.loading_text);
//        tvLabel.setText(page + " -- " + title);
        return view;
    }
}
