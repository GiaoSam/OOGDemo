package com.example.recyclerdemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.example.recyclerdemo.adapter.GridAdapter;
import com.example.recyclerdemo.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CLICK";

    private RecyclerView mRecyclerView;
    private List<HomeItem> mDatas;

    private ImageButton listButton;
    private ImageButton gridButton;

    private Context context;
    private ListAdapter listAdapter;
    private GridAdapter gridAdapter;

    private RecyclerView.LayoutManager gridManager;
    private RecyclerView.LayoutManager listManager;

    private int[] avatarImgResourceArray = {
            R.drawable.audio, R.drawable.chat,
            R.drawable.clock, R.drawable.downloads,
            R.drawable.rack, R.drawable.satellite,
            R.drawable.smartphone,
            R.drawable.audio, R.drawable.chat,
            R.drawable.clock, R.drawable.downloads,
            R.drawable.rack, R.drawable.satellite,
            R.drawable.smartphone
    };

    private int[] imageResourceArray = {
            R.drawable.model0, R.drawable.model1,
            R.drawable.model2, R.drawable.model3,
            R.drawable.model4, R.drawable.model5,
            R.drawable.model6,
            R.drawable.model0, R.drawable.model1,
            R.drawable.model2, R.drawable.model3,
            R.drawable.model4, R.drawable.model5,
            R.drawable.model6,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        initData();
        initView();

//      mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerView.setLayoutManager(listManager);
                mRecyclerView.setAdapter(listAdapter);
            }
        });

        gridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerView.setLayoutManager(gridManager);
                mRecyclerView.setAdapter(gridAdapter);
            }
        });
    }

    private void initView() {
        listAdapter = new ListAdapter(R.layout.home_page_item, mDatas);
        listAdapter.openLoadAnimation(new BaseAnimation() {
            @Override
            public Animator[] getAnimators(View view) {
                return new Animator[]{
                        ObjectAnimator.ofFloat(view, "scaleY", 1, 1.1f, 1),
                        ObjectAnimator.ofFloat(view, "scaleX", 1, 1.1f, 1)
                };
            }
        });
        listAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemClick: ");
                Toast.makeText(context, "onItemClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
        listManager = new LinearLayoutManager(this);

        gridAdapter = new GridAdapter(R.layout.test_grid_item, mDatas);
        gridAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        gridAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemClick: ");
                Toast.makeText(context, "onItemClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
        gridManager = new GridLayoutManager(this, 3);

        listButton = (ImageButton) findViewById(R.id.listButton);
        gridButton = (ImageButton) findViewById(R.id.gridButton);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mRecyclerView.setLayoutManager(gridManager);
        mRecyclerView.setAdapter(gridAdapter);
    }

    private void initData()
    {
        mDatas = new ArrayList<HomeItem>();

        for (int i = 0; i < imageResourceArray.length; i++)
        {
            HomeItem tempItem = new HomeItem();
            tempItem.setTitle(Integer.toString(i + 1));
            tempItem.setImageResource(imageResourceArray[i]);
            tempItem.setAvatarImgResource(avatarImgResourceArray[i]);
            mDatas.add(tempItem);
        }
    }

//    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
//    {
//
//        @Override
//        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
//        {
//            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
//                    MainActivity.this).inflate(R.layout.item_home, parent,
//                    false));
//            return holder;
//        }
//
//        @Override
//        public void onBindViewHolder(MyViewHolder holder, int position)
//        {
//            holder.iv.setImageResource(R.mipmap.ic_launcher);
//        }
//
//        @Override
//        public int getItemCount()
//        {
//            return mDatas.size();
//        }
//
//        class MyViewHolder extends RecyclerView.ViewHolder
//        {
//
//            ImageView iv;
//
//            public MyViewHolder(View view)
//            {
//                super(view);
//                iv = (ImageView) view.findViewById(R.id.id_num);
//            }
//        }
//    }
}
