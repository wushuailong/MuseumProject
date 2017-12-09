package com.gyx.museum.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyx.museum.R;
import com.gyx.museum.adapter.CollectItemAdapter;
import com.gyx.museum.adapter.MxWenwuAdapter;

import com.gyx.museum.base.BaseFragment;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.ui.activity.GcDetailsActivity;
import com.gyx.museum.utils.CommonUtil;
import com.gyx.museum.widget.ItemOffsetDecoration;
import com.gyx.museum.widget.LoadStateManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\6 0006.
 */

public class MyCollectConFragment extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener,SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.rv_list)
    RecyclerView recyclerView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    CollectItemAdapter collectItemAdapter;
    List<String> list = new ArrayList<>();
    //MyAdapter myAdapter;
    public static MyCollectConFragment newInstance() {
        MyCollectConFragment fragment = new MyCollectConFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_my_collect_con;
    }

    @Override
    protected void initViews() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
  /*      myAdapter = new MyAdapter(mContext,getMenuActive());
        recyclerView.setAdapter(myAdapter);*/
        collectItemAdapter = new CollectItemAdapter(getMenuActive());
        recyclerView.setAdapter(collectItemAdapter);
        collectItemAdapter.setOnLoadMoreListener(this);
        collectItemAdapter.openLoadMore(5,true);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(mContext, R.dimen.height_2);
        recyclerView.addItemDecoration(itemDecoration);
        collectItemAdapter.setOnDelListener(new CollectItemAdapter.onSwipeListener() {
            @Override
            public void onDel(int pos) {
              //  list.remove(pos);
                collectItemAdapter.remove(pos);
               // collectItemAdapter.setNewData(list);
               // collectItemAdapter.notifyDataSetChanged();
              //  CommonUtil.showToast(mContext,"点击了删除");
            }
        });
        // bwgExhibitionAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
     /*   recyclerView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(MainActivity.this, "** " + mList.get(position) + " **", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick(int position) {
                //collectItemAdapter.removeItem(position);
                CommonUtil.showToast(mContext,"删除了");
            }
        });*/
    }
    public List<String> getMenuActive(){
        for(int i=0;i<10;i++){
            list.add("sss");
        }
        return  list;
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
        collectItemAdapter.setNewData(getMenuActive());
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoadMoreRequested() {
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                collectItemAdapter.notifyDataChangedAfterLoadMore(getMenuActive(), true);//更新数据
            }
        };
        handler.post(r);
    }
}
