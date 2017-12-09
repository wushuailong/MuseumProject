package com.gyx.museum.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyx.museum.R;
import com.gyx.museum.adapter.BwgExhibitionAdapter;
import com.gyx.museum.adapter.HomeActiveAdapter;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.utils.CommonUtil;
import com.gyx.museum.widget.LoadStateManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\5 0005.
 */

public class HdListActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener,SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.rlv)
    RecyclerView recyclerView;
    @BindView(R.id.swiper)
    SwipeRefreshLayout swipeRefreshLayout;
    HomeActiveAdapter homeActiveAdapter;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_hd_list;
    }

    @Override
    protected void initViews() {
        initTitle(true,"活动");
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        homeActiveAdapter = new HomeActiveAdapter(getMenuActive());
        recyclerView.setAdapter(homeActiveAdapter);
        homeActiveAdapter.setOnLoadMoreListener(this);
        homeActiveAdapter.openLoadMore(5,true);
        // bwgExhibitionAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        homeActiveAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent  = new Intent(mContext, ZldetailsActivity.class);
                intent.putExtra("hdFlag","1");
                startActivity(intent);
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
    public List<String> getMenuActive(){
        List<String> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add("sss");
        }
        return  list;
    }

    @Override
    public void onRefresh() {
        homeActiveAdapter.setNewData(getMenuActive());
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoadMoreRequested() {
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                homeActiveAdapter.notifyDataChangedAfterLoadMore(getMenuActive(), true);//更新数据
            }
        };
        handler.post(r);
    }
}
