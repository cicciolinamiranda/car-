package com.carmudi.exam.customview;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.carmudi.exam.R;

/**
 * Created by cicciolina on 5/18/18.
 */

public class SlidingSplashView extends FrameLayout {


    private ViewPager mViewPager;
    private ImageViewPagerAdapter mViewPagerAdapter;


    public SlidingSplashView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SlidingSplashView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(final Context context){
        LayoutInflater.from(context).inflate( R.layout.sliding_splash_view,this);
        mViewPager = findViewById( R.id.pager_splash);
        mViewPagerAdapter = new ImageViewPagerAdapter(context);



        mViewPager.setAdapter(mViewPagerAdapter);
        TabLayout tabLayout = findViewById( R.id.tabDots);
        tabLayout.setupWithViewPager(mViewPager,true);
    }

    public void addImage(String url){
        mViewPagerAdapter.addImage(url);
    }

}
