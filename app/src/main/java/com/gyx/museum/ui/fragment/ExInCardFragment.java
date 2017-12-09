package com.gyx.museum.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseFragment;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.cardview.CardAdapter;
import com.gyx.museum.utils.CommonUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\7 0007.
 */

public class ExInCardFragment extends BaseFragment {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.cardView)
    CardView mCardView;
    Unbinder unbinder;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_tyhd_item;
    }

    @Override
    protected void initViews() {
        mCardView.setMaxCardElevation(mCardView.getCardElevation()
                * CardAdapter.MAX_ELEVATION_FACTOR);
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonUtil.showToast(mContext,"你好");
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
    public CardView getCardView() {
        return mCardView;
    }
}
