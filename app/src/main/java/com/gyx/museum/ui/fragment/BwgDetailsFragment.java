package com.gyx.museum.ui.fragment;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseFragment;
import com.gyx.museum.base.BasePresenter;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\5 0005.
 */

public class BwgDetailsFragment extends BaseFragment {
    public static BwgDetailsFragment newInstance() {
        BwgDetailsFragment fragment = new BwgDetailsFragment();
        return fragment;
    }
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_bwg_details;
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
}
