package com.carmudi.exam.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by cicciolina on 5/18/18.
 */

public class ExpandableHeightListView extends ListView {
    boolean expanded = false;

    public ExpandableHeightListView(Context context) {
        super(context);
    }

    public ExpandableHeightListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandableHeightListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(this.isExpanded()) {
            int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, expandSpec);
            ViewGroup.LayoutParams params = this.getLayoutParams();
            params.height = this.getMeasuredHeight();
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
