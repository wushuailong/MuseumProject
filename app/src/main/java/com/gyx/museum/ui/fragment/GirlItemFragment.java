package com.gyx.museum.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.gyx.museum.R;
import com.gyx.museum.adapter.GirlItemAdapter;
import com.gyx.museum.base.BaseFragment;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.base.baseadapter.OnItemClickListeners;
import com.gyx.museum.base.baseadapter.OnLoadMoreListener;
import com.gyx.museum.base.baseadapter.ViewHolder;
import com.gyx.museum.model.GirlItemData;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Author: Othershe
 * Time: 2016/8/17 10:57
 */
public class GirlItemFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    private int PAGE_COUNT = 1;
    private String mSubtype;
    private int mTempPageCount = 2;

    private GirlItemAdapter mGirlItemAdapter;

    private boolean isLoadMore;//是否是底部加载更多

    @BindView(R.id.type_item_recyclerview)
    RecyclerView mRecyclerView;

    @BindView(R.id.type_item_swipfreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_type_item_layout;
    }

    @Override
    protected void initViews() {
        /*EventBus.getDefault().register(this);

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        //实现首次自动显示加载提示
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });

        mGirlItemAdapter = new GirlItemAdapter(mContext, new ArrayList<GirlItemData>(), true);
        mGirlItemAdapter.setLoadingView(R.layout.load_loading_layout);
        mGirlItemAdapter.setOnItemClickListener(new OnItemClickListeners<GirlItemData>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, GirlItemData girlItemData, int position) {
                Intent intent = new Intent(mActivity, GirlDetailActivity.class);
                intent.putExtra("girl_item_data", girlItemData);
                startActivity(intent);
            }
        });

        mGirlItemAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                if (PAGE_COUNT == mTempPageCount && !isReload) {
                    return;
                }
                isLoadMore = true;
                PAGE_COUNT = mTempPageCount;
                fetchData();
            }
        });

        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//可防止Item切换
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mGirlItemAdapter);*/
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }


    @Override
    public void onRefresh() {
        isLoadMore = false;
        PAGE_COUNT = 1;
        mTempPageCount = 2;
       // fetchData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dataEvent(List<GirlItemData> data) {
        if (!data.get(0).getSubtype().equals(mSubtype)) {
            return;
        }
        if (isLoadMore) {
            if (data.size() == 0) {
              //  mGirlItemAdapter.setLoadEndView(R.layout.load_end_layout);
            } else {
                mTempPageCount++;
                mGirlItemAdapter.setLoadMoreData(data);
            }
        } else {
            mGirlItemAdapter.setNewData(data);
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }


}
