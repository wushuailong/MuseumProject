package com.gyx.museum.ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyx.museum.R;
import com.gyx.museum.adapter.HomeActiveAdapter;
import com.gyx.museum.adapter.HomeMenuAdapter;
import com.gyx.museum.adapter.MyPagerAdapter;
import com.gyx.museum.base.BaseFragment;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.model.HomeMenu;
import com.gyx.museum.model.LoopImage;
import com.gyx.museum.ui.activity.BwgExhibition;
import com.gyx.museum.ui.activity.BwgIntroduceActivity;
import com.gyx.museum.ui.activity.BwgViewpagerActivity;
import com.gyx.museum.ui.activity.GcListActivity;
import com.gyx.museum.ui.activity.HdListActivity;
import com.gyx.museum.ui.activity.MuseumClassifyActivity;
import com.gyx.museum.ui.activity.MxWenwuActivity;
import com.gyx.museum.ui.activity.ZldetailsActivity;
import com.gyx.museum.utils.AudioUtils;
import com.gyx.museum.utils.CommonResUtil;
import com.gyx.museum.utils.CommonUtil;
import com.gyx.museum.utils.DensityUtil;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 内容：首页
 * Created by 关云秀 on 2017\11\27 0027.
 */

public class HomeFragment2 extends BaseFragment implements BaseQuickAdapter.RequestLoadMoreListener{

    @BindView(R.id.active_rlv)
    RecyclerView activeRlv;
    HomeMenuAdapter homeMenuAdapter;
    HomeActiveAdapter homeActiveAdapter;
    MarqueeView marqueeView;
    int mDistance = 0;
    int maxDistance = 255;//当距离在[0,255]变化时，透明度在[0,255之间变化]
    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_home2;
    }

    @Override
    protected void initViews() {
        activeRlv.setNestedScrollingEnabled(false);
        activeRlv.setLayoutManager(new LinearLayoutManager(mContext));
        homeActiveAdapter = new HomeActiveAdapter(getMenuActive());
        activeRlv.setAdapter(homeActiveAdapter);
        homeActiveAdapter.setOnLoadMoreListener(this);
        homeActiveAdapter.openLoadMore(5,true);
        homeActiveAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        addHeaderView();
        homeActiveAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                Intent intent  = new Intent(mContext, ZldetailsActivity.class);
                intent.putExtra("hdFlag","1");
                startActivity(intent);
            }
        });
       /* activeRlv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                mDistance += dy;
                float percent = mDistance * 1f / maxDistance;//百分比
                int alpha = (int) (percent * 255);
                int argb = Color.argb(alpha, 57, 174, 255);
                setSystemBarAlpha(alpha);
            }
        });*/
    }

    @Override
    protected void updateViews() {

    }

    /**
     * 头部标题
     */
    private void addHeaderView() {
        View headerView = getActivity().getLayoutInflater().inflate(R.layout.fragment_home_header, null);
        headerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        homeActiveAdapter.addHeaderView(headerView);
        //轮播图
        RollPagerView rollpager = headerView.findViewById(R.id.rollpager);
        final RecyclerView menuRlv = headerView.findViewById(R.id.menu_rlv);
        marqueeView = (MarqueeView)headerView.findViewById(R.id.marqueeView);
        rollpager.setHintView(new ColorPointHintView(mContext,
                getResources().getColor(R.color.yellow),
                Color.WHITE));
        rollpager.setAdapter(new MyPagerAdapter(getUrl(), mContext));
        //选项
        menuRlv.setLayoutManager(new GridLayoutManager(getActivity(), 4, GridLayoutManager.VERTICAL, false));
        homeMenuAdapter = new HomeMenuAdapter(CommonResUtil.getMenuList());
        menuRlv.setAdapter(homeMenuAdapter);
        marquee();
        rollpager.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(mContext, "点击了：：：" + position, Toast.LENGTH_SHORT).show();
            }
        });
        homeMenuAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                if(i == 0){
                    startActivity(new Intent(mContext, BwgViewpagerActivity.class));
                }else if(i == 1){
                    startActivity(new Intent(mContext, GcListActivity.class));
                }else if(i == 2){
                    startActivity(new Intent(mContext, BwgExhibition.class));
                }else if(i == 3){
                    startActivity(new Intent(mContext, HdListActivity.class));
                 /*   VideoDetailInfo info1 = new VideoDetailInfo();
                    info1.setTitle("视频");
                    info1.setVideoPath("http://baobab.wandoujia.com/api/v1/playUrl?vid=8340&editionType=normal");
                    VideoDetailActivity.start(mContext, info1);*/
                   // CommonUtil.showToast(mContext,"活动");
                }
                //noticeAdapter.getItem(i);
            }
        });
    }
    //跑马灯效果
    public void marquee(){
        List<String> info = new ArrayList<>();
        info.add("【赵忠祥】文物的“背后故事”");
        info.add("【赵忠祥】文物的“背后故事”");
        info.add("【赵忠祥】文物的“背后故事”");
        info.add("【赵忠祥】文物的“背后故事”");
        info.add("【赵忠祥】文物的“背后故事”");
        info.add("【赵忠祥】文物的“背后故事”");
        marqueeView.startWithList(info);
// 在代码里设置自己的动画
        marqueeView.startWithList(info, R.anim.anim_bottom_in, R.anim.anim_top_out);
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                startActivity(new Intent(mContext,MxWenwuActivity.class));
            }
        });
    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }

    public List<LoopImage> getUrl() {
        List<LoopImage> loopImages = new ArrayList<>();
        LoopImage loopImage = new LoopImage();
        loopImage.setRes(R.mipmap.lunbo_img01);
        loopImages.add(loopImage);
        LoopImage loopImage2 = new LoopImage();
        loopImage2.setRes(R.mipmap.lunbo_img01);
        loopImages.add(loopImage2);
        LoopImage loopImage3 = new LoopImage();
        loopImage3.setRes(R.mipmap.lunbo_img01);
        loopImages.add(loopImage3);
        return loopImages;
    }

    public List<String> getMenuActive(){
        List<String> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add("sss");
        }
        return  list;
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




/*    *//**
     * 设置标题栏背景透明度
     * @param alpha 透明度
     *//*
    private void setSystemBarAlpha(int alpha) {
        if (alpha >= 125) {
            alpha = 125;
        } else {
            //标题栏渐变。a:alpha透明度 r:红 g：绿 b蓝
//        titlebar.setBackgroundColor(Color.rgb(57, 174, 255));//没有透明效果
//        titlebar.setBackgroundColor(Color.argb(alpha, 57, 174, 255));//透明效果是由参数1决定的，透明范围[0,255]
            toolbar.getBackground().setAlpha(alpha);
        }
    }*/
}
