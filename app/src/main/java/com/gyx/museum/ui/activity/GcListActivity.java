package com.gyx.museum.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.ui.fragment.BwgIntroduceFragment;
import com.gyx.museum.ui.fragment.BwgVisitInfoFragment;
import com.gyx.museum.ui.fragment.GcDetailsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import me.relex.circleindicator.CircleIndicator;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\5 0005.
 */

public class GcListActivity extends BaseActivity {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    List<Fragment> mFragments = new ArrayList<>();
    MyPagerAdapter fragmentAdapter;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_gclist;
    }

    @Override
    protected void initViews() {
        mFragments.add(GcDetailsFragment.newInstance());
        mFragments.add(GcDetailsFragment.newInstance());
        mFragments.add(GcDetailsFragment.newInstance());
        mFragments.add(GcDetailsFragment.newInstance());
        fragmentAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(fragmentAdapter);
        indicator.setViewPager(viewpager);


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
