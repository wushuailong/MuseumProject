package com.gyx.museum.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.ui.fragment.MyCollectConFragment;
import com.gyx.museum.ui.fragment.MyCollectHdConFragment;
import com.gyx.museum.ui.fragment.MyCollectZlConFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\6 0006.
 */

public class MyCollectActivity extends BaseActivity {
    @BindView(R.id.tablayout)
    SlidingTabLayout tablayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private ArrayList<Fragment> mFagments = new ArrayList<>();
    private String[] mTitles = {"展品", "展览","活动"};
    MyPagerAdapter adapter;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_my_collect;
    }

    @Override
    protected void initViews() {
        initTitle(true,"我的收藏");
        mFagments.add(MyCollectConFragment.newInstance());
        mFagments.add(MyCollectZlConFragment.newInstance());
        mFagments.add(MyCollectHdConFragment.newInstance());
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tablayout.setViewPager(viewPager, mTitles);
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
            return mFagments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFagments.get(position);
        }
    }
}
