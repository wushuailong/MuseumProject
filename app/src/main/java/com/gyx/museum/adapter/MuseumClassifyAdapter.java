package com.gyx.museum.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gyx.museum.R;
import com.gyx.museum.image.ImageManager;
import com.gyx.museum.model.ImageBean;
import com.gyx.museum.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容：
 * Created by 关云秀 on 2017\8\9 0009.
 */

public class MuseumClassifyAdapter extends BaseQuickAdapter<ImageBean> {
    private Context context;
    private List<Integer> mHeights = new ArrayList<>();;
    public MuseumClassifyAdapter(List<ImageBean> list, Context context) {
        super(R.layout.item_image_text,list);
        this.context = context;
    }
    @Override
    protected void convert(BaseViewHolder helper, ImageBean imageBean) {
        //helper.setImageResource(R.id.icon_img,homeMenu.getImage());
       // helper.setText(R.id.title_tv,homeMenu.getDesp());
    /*    int height=ImageUtil.getNewHeight(details.getWidth(),details.getHeight(),mItemWidth);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(mItemWidth, height);
        holder.ivPic.setLayoutParams(params);*/

        /*float ratio = ImageUtil.getAspectRatio(imageBean.getSource().getw.getWidth(), bean.getFile().getHeight());
        //长图 "width":440,"height":5040,
        holder.img_card_image.setAspectRatio(ratio);//设置宽高比*/
        ImageView imageView = helper.getView(R.id.imageview);
        int width = ((Activity)imageView.getContext()).getWindowManager().getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        //设置图片的相对于屏幕的宽高比
        params.width = width/2;
        params.height =  (int) (200 + Math.random() * 400) ;
        imageView.setLayoutParams(params);


        ImageManager.getInstance().loadImage(context,imageBean.getSource(),imageView);
    }
    public void getRandomHeight(List<ImageBean> mList){
        for(int i=0; i < mList.size();i++){
            //随机的获取一个范围为200-600直接的高度
            mHeights.add((int)(300+ Math.random()*400));
        }
    }
}
