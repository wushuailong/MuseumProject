package com.gyx.museum.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyx.museum.R;
import com.gyx.museum.img_browse.HackyViewPager;
import com.gyx.museum.img_browse.ImageDetailFragment;
import com.gyx.museum.widget.Xcircleindicator;
import com.gyx.museum.widget.Xroundindicator;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/4/29.
 */
public class ImagePagerActivity extends FragmentActivity {
    private static final String STATE_POSITION = "STATE_POSITION";
    public static final String EXTRA_IMAGE_INDEX = "image_index";
    public static final String EXTRA_IMAGE_URLS = "image_urls";
    private Xcircleindicator mXcircleindicator;
    private HackyViewPager mPager;
    private int pagerPosition;
    private ImageView closeImg;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_detail_pager);
       // StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.black), true);
		/*pagerPosition = getIntent().getIntExtra(EXTRA_IMAGE_INDEX, 0);*/
		/*String[] urls = getIntent().getStringArrayExtra(EXTRA_IMAGE_URLS);*/


        pagerPosition =getIntent().getExtras().getInt(ImagePagerActivity.EXTRA_IMAGE_INDEX);

        ArrayList<String> urls = getIntent().getStringArrayListExtra(ImagePagerActivity.EXTRA_IMAGE_URLS);
        String flag = getIntent().getStringExtra("flag");

        mPager = (HackyViewPager) findViewById(R.id.pager);
        closeImg = (ImageView)findViewById(R.id.close_img) ;
        mXcircleindicator=(Xcircleindicator) findViewById(R.id.Xcircleindicator);
        if(!TextUtils.isEmpty(flag)){
            mXcircleindicator.setVisibility(View.GONE);
        }
        ImagePagerAdapter mAdapter = new ImagePagerAdapter(
                getSupportFragmentManager(), urls);
        mPager.setAdapter(mAdapter);


        //设置总共的页数
        mXcircleindicator.initData(mPager
                .getAdapter().getCount(), 0);
        //设置当前的页面
        mXcircleindicator.setCurrentPage(0);

        // 更新下标
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int arg0) {
              /*  CharSequence text = getString(R.string.viewpager_indicator,
                        arg0 + 1, mPager.getAdapter().getCount());
                indicator.setText(text);*/
                mXcircleindicator.setCurrentPage(arg0);
            }

        });
        if (savedInstanceState != null) {
            pagerPosition = savedInstanceState.getInt(STATE_POSITION);
        }

        mPager.setCurrentItem(pagerPosition);
        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_POSITION, mPager.getCurrentItem());
    }

    private class ImagePagerAdapter extends FragmentStatePagerAdapter {

        public List<String> fileList;

        public ImagePagerAdapter(FragmentManager fm, List<String> fileList) {
            super(fm);
            this.fileList = fileList;
        }

        @Override
        public int getCount() {
            return fileList == null ? 0 : fileList.size();
        }

        @Override
        public Fragment getItem(int position) {
            String url = fileList.get(position);
            return ImageDetailFragment.newInstance(url);
        }

    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.hold, R.anim.bwg_img_anim_in);
    }
}