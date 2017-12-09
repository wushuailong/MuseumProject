package com.gyx.museum.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyx.museum.R;
import com.gyx.museum.adapter.HomeActiveAdapter;
import com.gyx.museum.adapter.MxWenwuAdapter;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.widget.ItemOffsetDecoration;
import com.gyx.museum.widget.LoadStateManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 内容：明星说文物
 * Created by 关云秀 on 2017\12\5 0005.
 */

public class MxWenwuActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener,SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.rlv)
    RecyclerView recyclerView;
    @BindView(R.id.swiper)
    SwipeRefreshLayout swipeRefreshLayout;
    MxWenwuAdapter wenwuAdapter;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_mxsww;
    }

    @Override
    protected void initViews() {
       initTitle(true,"明星说文物");
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        recyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
        wenwuAdapter = new MxWenwuAdapter(getMenuActive());
        recyclerView.setAdapter(wenwuAdapter);
        wenwuAdapter.setOnLoadMoreListener(this);
        wenwuAdapter.openLoadMore(5,true);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(mContext, R.dimen.height_2);
        recyclerView.addItemDecoration(itemDecoration);

        // bwgExhibitionAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        wenwuAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                 startActivity(new Intent(mContext,GcDetailsActivity.class));
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
        wenwuAdapter.setNewData(getMenuActive());
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoadMoreRequested() {
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                wenwuAdapter.notifyDataChangedAfterLoadMore(getMenuActive(), true);//更新数据
            }
        };
        handler.post(r);
    }
}
