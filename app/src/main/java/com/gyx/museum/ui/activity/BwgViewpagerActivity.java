package com.gyx.museum.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.ui.fragment.BwgDetailsFragment;
import com.gyx.museum.ui.fragment.BwgIntroduceFragment;
import com.gyx.museum.ui.fragment.BwgVisitInfoFragment;
import com.gyx.museum.utils.CommonUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.youngkaaa.yviewpager.YFragmentPagerAdapter;
import cn.youngkaaa.yviewpager.YViewPager;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\3 0003.
 */

public class BwgViewpagerActivity extends BaseActivity {
    @BindView(R.id.viewpager)
    YViewPager viewpager;
    List<Fragment> mFragments = new ArrayList<>();
    FragmentAdapter fragmentAdapter;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_bwg_viewpager;
    }

    @Override
    protected void initViews() {
        //注册EventBus,先订阅才能传值
        EventBus.getDefault().register(this);
        mFragments.add(BwgIntroduceFragment.newInstance());
        mFragments.add(BwgDetailsFragment.newInstance());
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewpager.setAdapter(fragmentAdapter);
    }

    @Override
    protected void updateViews() {
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    class FragmentAdapter extends YFragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }


    }
    @Subscribe          //订阅事件FirstEvent
    public  void onEventMainThread(String str){
        viewpager.setCurrentItem(1);
    }

}
