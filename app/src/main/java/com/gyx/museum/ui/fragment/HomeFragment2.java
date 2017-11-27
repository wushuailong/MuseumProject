package com.gyx.museum.ui.fragment;

import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyx.museum.R;
import com.gyx.museum.adapter.HomeActiveAdapter;
import com.gyx.museum.adapter.HomeMenuAdapter;
import com.gyx.museum.adapter.MyPagerAdapter;
import com.gyx.museum.base.BaseFragment;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.model.HomeMenu;
import com.gyx.museum.model.LoopImage;
import com.gyx.museum.utils.CommonUtil;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;

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
    private double mDistanceY;
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
        activeRlv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //滑动的距离
                mDistanceY += dy;
                //toolbar的高度
                int toolbarHeight = toolbar.getBottom();

                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= toolbarHeight) {
                    float scale = (float) mDistanceY / toolbarHeight;
                    float alpha = scale * 255;
                    toolbar.setBackgroundColor(Color.argb((int) alpha, 128, 0, 0));
                } else {
                    //上述虽然判断了滑动距离与toolbar高度相等的情况，但是实际测试时发现，标题栏的背景色
                    //很少能达到完全不透明的情况，所以这里又判断了滑动距离大于toolbar高度的情况，
                    //将标题栏的颜色设置为完全不透明状态
                    toolbar.setBackgroundResource(R.color.colorPrimary);
                }

            }
        });
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
        RollPagerView rollpager = headerView.findViewById(R.id.rollpager);
        RecyclerView menuRlv = headerView.findViewById(R.id.menu_rlv);
        rollpager.setAdapter(new MyPagerAdapter(getUrl(), mContext));
        rollpager.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(mContext, "点击了：：：" + position, Toast.LENGTH_SHORT).show();
            }
        });
        menuRlv.setLayoutManager(new GridLayoutManager(getActivity(), 4, GridLayoutManager.VERTICAL, false));
        homeMenuAdapter = new HomeMenuAdapter(getMenuList());
        menuRlv.setAdapter(homeMenuAdapter);
        homeMenuAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                if(i == 0){
                    CommonUtil.showToast(mContext,"博物馆");
                }else if(i == 1){
                    CommonUtil.showToast(mContext,"馆藏");
                }else if(i == 2){
                    CommonUtil.showToast(mContext,"展览");
                }else if(i == 3){
                    CommonUtil.showToast(mContext,"活动");
                }
                //noticeAdapter.getItem(i);
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
        loopImage.setPath("http://www.saiwensida.com:8080/zhly/upload/loop/e2c084ff-1a47-4c00-b42c-8f993264464d.jpg");
        loopImages.add(loopImage);
        LoopImage loopImage2 = new LoopImage();
        loopImage2.setPath("http://www.saiwensida.com:8080/zhly/upload/loop/1b60af6b-3a84-4359-92d5-6cfd5cde6a74.jpg");
        loopImages.add(loopImage2);
        LoopImage loopImage3 = new LoopImage();
        loopImage3.setPath("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");
        loopImages.add(loopImage3);
        return loopImages;
    }
    public List<HomeMenu> getMenuList(){
        List<HomeMenu> list = new ArrayList<>();
        list.add(new HomeMenu(R.mipmap.icon_1,"博物馆"));
        list.add(new HomeMenu(R.mipmap.icon_1,"馆藏"));
        list.add(new HomeMenu(R.mipmap.icon_1,"展览"));
        list.add(new HomeMenu(R.mipmap.icon_1,"活动"));
        return  list;
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

}
