package com.gyx.museum.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;

/**
 * 内容：
 * Created by 关云秀 on 2017\11\28 0028.
 */

public class StaggerRecyclerView extends RecyclerView {

    private OnLoadMoreListener onLoadMoreListener;
    private boolean isLoadingMore = false;
    private static final int TOLAST = 6;

    public StaggerRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                StaggeredGridLayoutManager layoutManager = null ;
                if(recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager){
                    layoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                }else{
                    return;
                }
                int[] positions = null;
                int[] into = layoutManager.findLastCompletelyVisibleItemPositions(positions);
                int lastPositon = Math.max(into[0],into[1]);
                for(int i = 0;i<into.length;i++){
                    Log.d("home","lastPositon ="+lastPositon +" | itemcount ="+layoutManager.getItemCount()+" | dx = "+dx+" | dy = "+dy);
                }

                if(!isLoadingMore && dy>0 && layoutManager.getItemCount()-lastPositon<=TOLAST){
                    //load more
                    isLoadingMore = true;
                    if(onLoadMoreListener!=null){
                        onLoadMoreListener.onLoadMore();
                    }

                }
            }
        });
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public void setLoadingMoreComplete(){
        isLoadingMore = false;
    }

    public  interface OnLoadMoreListener{
        void onLoadMore();
    }


}

