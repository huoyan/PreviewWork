package com.zxp.cs.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.zxp.cs.R;

public class ViewPagerGallery extends Activity {

    private ViewPager mGalleryViewPager;

    private LinearLayout mViewPagerContainer;

    private int pagerWidth = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_gallery);

        mGalleryViewPager = (ViewPager)findViewById(R.id.gallery_viewpager);
        mViewPagerContainer = (LinearLayout)findViewById(R.id.gallery_viewpager_layout);

        pagerWidth =  (int) (getResources().getDisplayMetrics().widthPixels*3.0f/5.0f);
        mGalleryViewPager.measure(0, 0);
        ViewGroup.LayoutParams lp = mGalleryViewPager.getLayoutParams();
        if(lp==null)
        {
            lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        }else{
            lp.width = pagerWidth;
        }
        mGalleryViewPager.setLayoutParams(lp);//设置页面宽度为屏幕的3/5
        mGalleryViewPager.setOffscreenPageLimit(4);  //设置ViewPager至多缓存4个Pager页面，防止多次加载
        mGalleryViewPager.setPageMargin(50);  //设置Pager之间的间距
        mGalleryViewPager.setAdapter(new GalleryPagerAdapter());

        mGalleryViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (mViewPagerContainer != null)
                {
                    mViewPagerContainer.invalidate();  //更新超出区域页面，否则会出现页面缓存，导致页面效果不佳
                }
            }
        });
    }
    private class GalleryPagerAdapter extends PagerAdapter
    {
        @Override
        public int getCount()
        {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj)
        {
            return view==obj;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView((ImageView)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int resId = R.mipmap.ic_launcher;
            ImageView imageView = createImageView(resId);
            ((ViewPager)container).addView(imageView, position);
            return imageView;
        }


        public ImageView createImageView(int resId)
        {
            ImageView iv = new ImageView(ViewPagerGallery.this);
            ViewGroup.LayoutParams lp = iv.getLayoutParams();
            if(lp==null)
            {
                lp = new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
            }else{
                lp.width = pagerWidth;
                lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
            }
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setImageResource(resId);
            iv.setLayoutParams(lp);
            return iv;
        }
    }
}