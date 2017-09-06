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

public class ListAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {


    public ListAdapter(@LayoutRes int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.homepageTextView, item.getTitle());
        helper.setImageResource(R.id.mainImageView, item.getImageResource());
        helper.setImageResource(R.id.avatarImgView, item.getAvatarImgResource());

        // 加载网络图片
//        Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) RecyclerView.ViewHolder.getView(R.id.testImgView));

    }
}
