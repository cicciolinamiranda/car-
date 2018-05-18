package com.carmudi.exam.customview;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cicciolina on 5/18/18.
 */

public abstract class ViewPagerAdapter extends PagerAdapter {

    public abstract View getItem(int position);


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View mItemView = getItem(position);
        container.addView(mItemView);
        return mItemView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==  object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
