package com.gyx.museum.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseFragment;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.ui.activity.VisitInfoActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\3 0003.
 */

public class BwgIntroduceFragment extends BaseFragment {
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.time_tv)
    TextView timeTv;
    @BindView(R.id.time_info_tv)
    TextView timeInfoTv;
    @BindView(R.id.visit_tv)
    TextView visitTv;
    public static BwgIntroduceFragment newInstance() {
        BwgIntroduceFragment fragment = new BwgIntroduceFragment();
        return fragment;
    }
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_bwg_introduce;
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


    @OnClick(R.id.visit_tv)
    public void onClick() {
        startActivity(new Intent(mContext,VisitInfoActivity.class));
       // EventBus.getDefault().post("点击了博物馆");
    }
}
