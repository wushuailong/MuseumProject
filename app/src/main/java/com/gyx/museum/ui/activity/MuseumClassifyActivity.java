package com.gyx.museum.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyx.museum.R;
import com.gyx.museum.adapter.HomeActiveAdapter;
import com.gyx.museum.adapter.MuseumClassifyAdapter;
import com.gyx.museum.adapter.WaterFallAdapter;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.model.ImageBean;
import com.gyx.museum.service.DataService;
import com.gyx.museum.utils.CommonUtil;
import com.gyx.museum.widget.LoadStateManager;
import com.gyx.museum.widget.StaggerRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.R.attr.data;

/**
 * 功能：馆藏分类
 * Created by Administrator on 2017/11/27.
 */

public class MuseumClassifyActivity extends BaseActivity implements BaseQuickAdapter.RequestLoadMoreListener,SwipeRefreshLayout.OnRefreshListener{
    @BindView(R.id.rlv)
    StaggerRecyclerView recyclerView;
    @BindView(R.id.swiper)
    SwipeRefreshLayout swipeRefreshLayout;
    MuseumClassifyAdapter museumClassifyAdapter;
    List<ImageBean> listImage = new ArrayList<>();
    private int flag = 0;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_museum_classify;
    }

    @Override
    protected void initViews() {
        initTitle(true,"铜器");
        EventBus.getDefault().register(this);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        museumClassifyAdapter = new MuseumClassifyAdapter(listImage,mContext);
        recyclerView.setAdapter(museumClassifyAdapter);
        museumClassifyAdapter.setOnLoadMoreListener(this);
        museumClassifyAdapter.openLoadMore(5,true);
        DataService.startService(mContext, getMusem());
        museumClassifyAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        museumClassifyAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent = new Intent(mContext,GcDetailsPagerActivity.class);
                intent.putExtra("listsize",listImage.size());
                intent.putExtra("position",i);
                startActivity(intent);
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

    @Override
    public void onLoadMoreRequested() {
        flag = 1;
        DataService.startService(mContext, getMusem());
       /* Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                museumClassifyAdapter.getRandomHeight(getMusem());
                museumClassifyAdapter.notifyDataChangedAfterLoadMore(getMusem(), true);//更新数据

            }
        };
        handler.post(r);*/
    }
    @Override
    public void onRefresh() {
        flag = 0;
        DataService.startService(mContext, getMusem());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dataEvent(List<ImageBean> data) {
        swipeRefreshLayout.setRefreshing(false);
        if(flag == 0){
            mLoadStateManager.setState(LoadStateManager.LoadState.Success);
            museumClassifyAdapter.setNewData(data);
        }else{
            museumClassifyAdapter.notifyDataChangedAfterLoadMore(data, true);//更新数据
        }
    }



    public List<ImageBean> getMusem(){
        ImageBean imageBean = new ImageBean();
        imageBean.setTitle("【西周】大克鼎");
        imageBean.setCode("编号：YTH100");
        imageBean.setResource(R.mipmap.tq_img01);
        listImage.add(imageBean);
        ImageBean imageBean2 = new ImageBean();
        imageBean2.setTitle("【商】八牛贮贝器");
        imageBean2.setCode("编号：YTH100");
        imageBean2.setResource(R.mipmap.tq_img02);
        listImage.add(imageBean2);
        ImageBean imageBean3 = new ImageBean();
        imageBean3.setTitle("【商】兽面纹壶");
        imageBean3.setCode("编号：YTH100");
        imageBean3.setResource(R.mipmap.tq_img03);
        listImage.add(imageBean3);
        ImageBean imageBean4 = new ImageBean();
        imageBean4.setTitle("【清朝】白玉镂雕蟠龙 ");
        imageBean4.setCode("编号：YTH100");
        imageBean4.setResource(R.mipmap.tq_img04);
        listImage.add(imageBean4);
        ImageBean imageBean5 = new ImageBean();
        imageBean5.setTitle("【清朝】白玉镂雕蟠龙 ");
        imageBean5.setCode("编号：YTH100");
        imageBean5.setResource(R.mipmap.tq_img04);
        listImage.add(imageBean);
        listImage.add(imageBean2);
        listImage.add(imageBean3);
        listImage.add(imageBean4);
        listImage.add(imageBean);
        listImage.add(imageBean2);

        return listImage;
    }


}
