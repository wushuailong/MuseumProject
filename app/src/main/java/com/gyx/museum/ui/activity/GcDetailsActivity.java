package com.gyx.museum.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gyx.museum.R;
import com.gyx.museum.base.BaseActivity;
import com.gyx.museum.base.BasePresenter;
import com.gyx.museum.expandable.ExpandableLayout;
import com.gyx.museum.popupwindow.BwgVisitPopupwindow;
import com.gyx.museum.popupwindow.BwgZpInfoPopupwindow;
import com.gyx.museum.utils.AudioUtils;
import com.gyx.museum.utils.CommonUtil;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 内容：
 * Created by 关云秀 on 2017\12\2 0002.
 */

public class GcDetailsActivity extends BaseActivity {
    @BindView(R.id.info_tv)
    TextView infoTv;
    @BindView(R.id.tizhong_tv)
    TextView tizhongTv;
    @BindView(R.id.info_lv)
    LinearLayout infoLv;
    @BindView(R.id.more_img)
    ImageView moreImg;
    @BindView(R.id.share_img)
    ImageView shareImg;
    @BindView(R.id.collect_img)
    ImageView collectImg;
    @BindView(R.id.other_img)
    ImageView otherImg;
    @BindView(R.id.det_img)
    ImageView detImg;
    @BindView(R.id.fangda_img)
    ImageView fangdaImg;
    @BindView(R.id.zhishi_img)
    ImageView zhishiImg;
    @BindView(R.id.details_img)
    ImageView detailsImg;
    @BindView(R.id.dingwei_img)
    ImageView dingweiImg;
    @BindView(R.id.jieshuo_img)
    ImageView jieshuoImg;
    @BindView(R.id.root_lv)
    RelativeLayout rootLv;
    @BindView(R.id.expandLayout)
    ExpandableLayout expandableLayout;
    @BindView(R.id.detfd_img)
    ImageView detfdImg;
    BwgZpInfoPopupwindow bwgVisitPopupwindow;
    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_gcdetails;
    }

    @Override
    protected void initViews(){
    }

    @Override
    protected void updateViews() {

    }

    @Override
    protected BasePresenter onCreatePresenter() {
        return null;
    }
    @OnClick({R.id.more_img, R.id.share_img, R.id.collect_img, R.id.other_img, R.id.det_img,R.id.detfd_img, R.id.zhishi_img, R.id.details_img, R.id.dingwei_img, R.id.jieshuo_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.more_img:
                if (expandableLayout.isExpanded()) {
                    expandableLayout.collapse();
                } else {
                    expandableLayout.expand();
                }
                break;
            case R.id.share_img:
                new ShareAction(GcDetailsActivity.this)
                        .withText("hello")
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE)
                        .setCallback(shareListener)
                        .open();
                break;
            case R.id.collect_img:
                collectImg.setImageResource(R.mipmap.qx_xq_03_true);
                collectImg.startAnimation(AnimationUtils.loadAnimation(this, R.anim.collect_anim));
                break;
            case R.id.other_img:
                break;
            case R.id.det_img:
                detImg.setVisibility(View.GONE);
                fangdaImg.setVisibility(View.GONE);
                detfdImg.setVisibility(View.VISIBLE);
                detfdImg.startAnimation(AnimationUtils.loadAnimation(this,R.anim.bwg_img_anim_out));
               /* ArrayList<String> urls = new ArrayList<>();
                urls.add("aaaa");
                Intent intent = new Intent(this, ImagePagerActivity.class);
                // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
                intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls);
                intent.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, 0);
                intent.putExtra("flag", "1");
                startActivity(intent);
                overridePendingTransition(R.anim.bwg_img_anim_out,R.anim.bwg_img_anim_in);*/
                break;
            case R.id.detfd_img:
                detImg.setVisibility(View.VISIBLE);
                fangdaImg.setVisibility(View.VISIBLE);
                detfdImg.setVisibility(View.GONE);
                detfdImg.startAnimation(AnimationUtils.loadAnimation(this,R.anim.bwg_img_anim_in));
                break;
            case R.id.zhishi_img:
                bwgVisitPopupwindow = new BwgZpInfoPopupwindow(mContext,onClick);
                bwgVisitPopupwindow.show(rootLv);
                break;
            case R.id.details_img://细节
                //startActivity(new Intent(mContext,ImgViewpagerActivity.class));
                ArrayList<String> urls2 = new ArrayList<>();
                urls2.add("aaaa");
                urls2.add("33");
                Intent intent2 = new Intent(this, ImagePagerActivity.class);
                // 图片url,为了演示这里使用常量，一般从数据库中或网络中获取
                intent2.putExtra(ImagePagerActivity.EXTRA_IMAGE_URLS, urls2);
                intent2.putExtra(ImagePagerActivity.EXTRA_IMAGE_INDEX, 0);
                startActivity(intent2);
                break;
            case R.id.dingwei_img:

                break;
            case R.id.jieshuo_img:
                   SpeechSynthesizer speechSynthesizer = AudioUtils.getInstance().init(mContext); //初始化语音对象
                    speechSynthesizer.startSpeaking("今天我很高兴", mSynListener);
                break;
        }
    }
    public final View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //circleFragmentPresenter.onReward(mContext,userId,random);
            bwgVisitPopupwindow.dismiss();
        }
    };
    /***************************************语音播报*******************************************/
    private SynthesizerListener mSynListener = new SynthesizerListener() {
        //会话结束回调接口，没有错误时，error为null
        public void onCompleted(SpeechError error) {
            Log.d("mySynthesiezer:", "onCompleted ");
            //voiceFlag = 2;
            // idVoiceView.onProgressCompleted();
        }
        //缓冲进度回调
        //percent为缓冲进度0~100，beginPos为缓冲音频在文本中开始位置，endPos表示缓冲音频在文本中结束位置，info为附加信息。
        public void onBufferProgress(int percent, int beginPos, int endPos, String info) {
            Log.d("mySynthesiezer:", "onBufferProgress ");
        }
        //开始播放
        public void onSpeakBegin() {
        }

        //暂停播放
        public void onSpeakPaused() {
            Log.d("mySynthesiezer:", "onSpeakPaused ");
        }

        //播放进度回调
        //percent为播放进度0~100,beginPos为播放音频在文本中开始位置，endPos表示播放音频在文本中结束位置.
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
            //  voiceFlag = 1;
            // idVoiceView.setProgress(percent);
        }
        //恢复播放回调接口
        public void onSpeakResumed() {
            Log.d("mySynthesiezer:", "onSpeakResumed ");
        }
        //会话事件回调接口
        public void onEvent(int arg0, int arg1, int arg2, Bundle arg3) {
        }
    };
    /******************************************分享**************************************************/
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(mContext,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(mContext,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(mContext,"取消了",Toast.LENGTH_LONG).show();

        }
    };
}
