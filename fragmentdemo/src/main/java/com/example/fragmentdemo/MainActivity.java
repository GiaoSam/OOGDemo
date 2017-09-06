package com.example.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private RedFragment red;
    private YellowFragment yellow;
    private GreenFragment green;
    private BlueFragment blue;
    private PurpleFragment purple;

    private ImageButton redImgBtn;
    private ImageButton yellowImgBtn;
    private ImageButton greenImgBtn;
    private ImageButton blueImgBtn;
    private ImageButton purpleImgBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        // 设置默认的Fragment
        setDefaultFragment();
    }

    private void initView() {
        // 初始化 ImageButton 并设置监听，监听 context
        redImgBtn = (ImageButton) findViewById(R.id.id_red_button);
        redImgBtn.setOnClickListener(this);

        yellowImgBtn = (ImageButton) findViewById(R.id.id_yellow_button);
        yellowImgBtn.setOnClickListener(this);

        blueImgBtn = (ImageButton) findViewById(R.id.id_blue_button);
        blueImgBtn.setOnClickListener(this);

        greenImgBtn = (ImageButton) findViewById(R.id.id_green_button);
        greenImgBtn.setOnClickListener(this);

        purpleImgBtn = (ImageButton) findViewById(R.id.id_purple_button);
        purpleImgBtn.setOnClickListener(this);
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        yellow = new YellowFragment();
        // R.id.id_content_framelayout 即activity_main.xml中Fragments的布局位置的layout
        transaction.add(R.id.id_content_framelayout, yellow);
        transaction.commit();
        transaction = fm.beginTransaction();
        red = new RedFragment();

        transaction.replace(R.id.id_content_framelayout, red);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {

        // 开启Fragment
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

//        transaction.add()
        switch (view.getId())
        {
            case R.id.id_red_button:
                if (red == null)
                {
                    red = new RedFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content_framelayout, red);
                break;

            case R.id.id_yellow_button:
                if (yellow == null)
                {
                    yellow = new YellowFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content_framelayout, yellow);
                break;

            case R.id.id_green_button:
                if (green == null)
                {
                    green = new GreenFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content_framelayout, green);
                break;

            case R.id.id_blue_button:
                if (blue == null)
                {
                    blue= new BlueFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content_framelayout, blue);
                break;

            case R.id.id_purple_button:
                if (purple == null)
                {
                    purple = new PurpleFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content_framelayout, purple);
                break;
        }

        // transaction.addToBackStack();
        // 事务提交
        transaction.commit();
    }
}

/*
所有的Fragment都是依附于Activity的，所以通信起来并不复杂，大概归纳为：
a、如果你Activity中包含自己管理的Fragment的引用，可以通过引用直接访问所有的Fragment的public方法
b、如果Activity中未保存任何Fragment的引用，那么没关系，每个Fragment都有一个唯一的TAG或者ID,
   可以通过getFragmentManager.findFragmentByTag()或者findFragmentById()获得任何Fragment实例，然后进行操作。
c、在Fragment中可以通过getActivity得到当前绑定的Activity的实例，然后进行操作。

因为要考虑Fragment的重复使用，所以必须降低Fragment与Activity的耦合，
而且Fragment更不应该直接操作别的Fragment，毕竟Fragment操作应该由它的管理者Activity来决定。
*/
