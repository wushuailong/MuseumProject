package com.gyx.museum.adapter;

import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyx.museum.R;

import java.util.List;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\5 0005.
 */

public class CollectItemAdapter extends BaseQuickAdapter<String> {
    public CollectItemAdapter(List<String> list) {
        super(R.layout.fragment_collect_item,list);
    }
    @Override
    protected void convert(final BaseViewHolder helper, String homeMenu) {
        //helper.setImageResource(R.id.icon_img,homeMenu.getImage());
        // helper.setText(R.id.title_tv,homeMenu.getDesp());
        Button delBtn = helper.getView(R.id.btnDelete);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnSwipeListener) {
                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
                    //((CstSwipeDelMenu) holder.itemView).quickClose();
                    mOnSwipeListener.onDel(helper.getAdapterPosition());
                }
            }
        });
    }
    /**
     * 和Activity通信的接口
     */
    public interface onSwipeListener {
        void onDel(int pos);
    }

    private onSwipeListener mOnSwipeListener;

    public onSwipeListener getOnDelListener() {
        return mOnSwipeListener;
    }

    public void setOnDelListener(onSwipeListener mOnDelListener) {
        this.mOnSwipeListener = mOnDelListener;
    }
}
