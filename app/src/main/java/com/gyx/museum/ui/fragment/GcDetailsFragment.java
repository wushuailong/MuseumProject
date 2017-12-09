package com.gyx.museum.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseFragment;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.ui.activity.MuseumClassifyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 内容：馆藏
 * Created by 关云秀 on 2017\12\5 0005.
 */

public class GcDetailsFragment extends BaseFragment {
    @BindView(R.id.image)
    ImageView image;
    public static GcDetailsFragment newInstance() {
        GcDetailsFragment fragment = new GcDetailsFragment();
        return fragment;
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_gcdetails;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    @OnClick(R.id.image)
    public void onClick() {
        startActivity(new Intent(mContext, MuseumClassifyActivity.class));
    }
}
