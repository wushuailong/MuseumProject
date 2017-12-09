package com.gyx.museum.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.ui.fragment.BwgDetailsFragment;
import com.gyx.museum.ui.fragment.BwgIntroduceFragment;
import com.gyx.museum.ui.fragment.GcDetailsPageFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.youngkaaa.yviewpager.YFragmentPagerAdapter;
import cn.youngkaaa.yviewpager.YViewPager;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\9 0009.
 */

public class GcDetailsPagerActivity extends BaseActivity {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    List<Fragment> mFragments = new ArrayList<>();
    MyPagerAdapter fragmentAdapter;
    private int listSize,positon;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_gcdetails_viewpager;
    }

    @Override
    protected void initViews() {
        listSize = getIntent().getIntExtra("listsize",0);
        positon = getIntent().getIntExtra("position",0);
        for(int i=0;i<listSize;i++) {
            mFragments.add(GcDetailsPageFragment.newInstance());
        }
        fragmentAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(fragmentAdapter);
        viewpager.setCurrentItem(positon);
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
