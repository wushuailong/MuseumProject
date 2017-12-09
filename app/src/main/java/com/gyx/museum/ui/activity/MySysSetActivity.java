package com.gyx.museum.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：系统 设置
 * Created by 关云秀 on 2017\12\7 0007.
 */

public class MySysSetActivity extends BaseActivity {
    @BindView(R.id.my_bind_lv)
    LinearLayout myBindLv;
    @BindView(R.id.my_update_lv)
    LinearLayout myUpdateLv;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_my_sysset;
    }

    @Override
    protected void initViews() {
        initTitle(true, "系统设置");
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @OnClick({R.id.my_bind_lv, R.id.my_update_lv})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_bind_lv:
                startActivity(new Intent(mContext,MyBindPhoneActivity.class));
                break;
            case R.id.my_update_lv:
                startActivity(new Intent(mContext,MyUpdatePassActivity.class));
                break;
        }
    }
}
