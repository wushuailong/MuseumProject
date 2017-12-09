package com.gyx.museum.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\3 0003.
 */

public class BwgIntroduceActivity extends BaseActivity {
    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.time_tv)
    TextView timeTv;
    @BindView(R.id.time_info_tv)
    TextView timeInfoTv;
    @BindView(R.id.visit_tv)
    TextView visitTv;

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
    }
}
