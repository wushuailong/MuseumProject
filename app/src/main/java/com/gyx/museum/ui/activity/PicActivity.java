package com.gyx.museum.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.gyx.museum.R;
import com.gyx.museum.adapter.PicAdapter;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PicActivity extends BaseActivity {
    @BindView(R.id.pic_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.indicator)
    TextView indicator;
    private View mView;
    private PicAdapter mPicAdapter;
    private List<String> mListUrl;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_pic;
    }

    @Override
    protected void initViews() {
        mListUrl = getIntent().getStringArrayListExtra("piclist");
        int currentPosition = getIntent().getIntExtra("position", 0);
        // updateToolBar();
        mPicAdapter = new PicAdapter(this, mListUrl);
        mViewPager.setAdapter(mPicAdapter);
        if (currentPosition != 0) {
            mViewPager.setCurrentItem(currentPosition);
        }
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

}
