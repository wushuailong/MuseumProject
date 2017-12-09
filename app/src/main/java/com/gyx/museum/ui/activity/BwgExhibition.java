package com.gyx.museum.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyx.museum.R;
import com.gyx.museum.adapter.BwgExhibitionAdapter;
import com.gyx.museum.adapter.MuseumClassifyAdapter;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.service.DataService;
import com.gyx.museum.utils.CommonUtil;
import com.gyx.museum.widget.LoadStateManager;
import com.gyx.museum.widget.StaggerRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 内容：展览
 * Created by 关云秀 on 2017\12\4 0004.
 */

public class BwgExhibition extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener,SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.rlv)
    RecyclerView recyclerView;
    @BindView(R.id.swiper)
    SwipeRefreshLayout swipeRefreshLayout;
    BwgExhibitionAdapter bwgExhibitionAdapter;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_bwg_exhibition;
    }

    @Override
    protected void initViews() {
       initTitle(true,"展览");
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        bwgExhibitionAdapter = new BwgExhibitionAdapter(CommonUtil.getMenuActive(),mContext);
        recyclerView.setAdapter(bwgExhibitionAdapter);
        bwgExhibitionAdapter.setOnLoadMoreListener(this);
        bwgExhibitionAdapter.openLoadMore(5,true);
       // bwgExhibitionAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        bwgExhibitionAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                startActivity(new Intent(mContext,ZldetailsActivity.class));
            }
        });
    }

    @Override
    protected void updateViews() {
        mLoadStateManager.setState(LoadStateManager.LoadState.Success);

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    @Override
    public void onRefresh() {
        mLoadStateManager.setState(LoadStateManager.LoadState.Success);
        bwgExhibitionAdapter.setNewData(CommonUtil.getMenuActive());
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoadMoreRequested() {
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                bwgExhibitionAdapter.notifyDataChangedAfterLoadMore(CommonUtil.getMenuActive(), true);//更新数据
            }
        };
        handler.post(r);
    }
}
