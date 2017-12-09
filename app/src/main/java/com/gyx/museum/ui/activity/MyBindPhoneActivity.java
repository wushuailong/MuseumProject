package com.gyx.museum.ui.activity;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\7 0007.
 */

public class MyBindPhoneActivity extends BaseActivity {
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_mybindphone;
    }

    @Override
    protected void initViews() {
      initTitle(true,"绑定手机");
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
}
