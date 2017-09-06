package com.example.recyclerdemo.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.recyclerdemo.HomeItem;
import com.example.recyclerdemo.R;

import java.util.List;

/**
 * Created by johnson on 17-9-6.
 */

public class GridAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {
    public GridAdapter (@LayoutRes int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setImageResource(R.id.testGridImgView, item.getImageResource());
    }
}
