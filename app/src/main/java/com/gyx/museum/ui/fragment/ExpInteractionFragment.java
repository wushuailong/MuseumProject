package com.gyx.museum.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseFragment;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.cardview.CardFragmentPagerAdapter;
import com.gyx.museum.cardview.CardItem;
import com.gyx.museum.cardview.CardPagerAdapter;
import com.gyx.museum.cardview.ShadowTransformer;
import com.gyx.museum.ui.activity.TyhdArActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.relex.circleindicator.CircleIndicator;

/**
 * 内容：体验互动
 * Created by 关云秀 on 2017\11\27 0027.
 */

public class ExpInteractionFragment extends BaseFragment {
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_expinteraction;
    }

    @Override
    protected void initViews() {
        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem(R.mipmap.tyhd_ar_img,R.mipmap.tyhd_ar_tv));
        mCardAdapter.addCardItem(new CardItem(R.mipmap.tyhd_vr_img,R.mipmap.tyhd_vr_tv));
        mCardAdapter.addCardItem(new CardItem(R.mipmap.tyhd_video_img,R.mipmap.tyhd_video_tv));
        mCardAdapter.addCardItem(new CardItem(R.mipmap.tyhd_wenc_img,R.mipmap.tyhd_wenc_tv));
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getChildFragmentManager(),
                dpToPixels(2, mContext));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
        mCardShadowTransformer.enableScaling(true);
        mFragmentCardShadowTransformer.enableScaling(true);
        indicator.setViewPager(mViewPager);
        mCardAdapter.setOnClick(new CardPagerAdapter.OnClick() {
            @Override
            public void OnClick(int position) {
                startActivity(new Intent(mContext, TyhdArActivity.class));
            }
        });
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

}
