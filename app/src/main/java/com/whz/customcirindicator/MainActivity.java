package com.whz.customcirindicator;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.whz.customcirindicator.view.CircleIndicator;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private CircleIndicator mIndicator;
    private ArrayList<View> mLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initEvent();
    }

    /**
     * 初始化View事件
     */
    private void initEvent() {
        mViewPager.setAdapter(new ViewPagerAdapter());
        mIndicator.setViewPager(mViewPager);
    }

    /**
     * 初始化View数据
     */
    private void initData() {
        mLists = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            View view = new View(this);
            view.setBackgroundColor(0xff000000 | random.nextInt(0x00ffffff));
            mLists.add(view);
        }
    }

    /**
     * 初始化View
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_viewpager);
        mIndicator = (CircleIndicator) findViewById(R.id.ci_indicator);
    }

    /**
     * ViewPager适配器
     */
    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mLists.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mLists.get(position));
            return mLists.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mLists.get(position));
        }
    }
}
