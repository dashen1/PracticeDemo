package com.example.architect_day11.day14.simple4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;


public class CoderListView extends ScrollView {

    private LinearLayout mContainer;
    private AdapterTarget mAdapter;


    public CoderListView(Context context) {
        this(context,null);
    }

    public CoderListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CoderListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContainer = new LinearLayout(context);
        mContainer.setOrientation(LinearLayout.VERTICAL);
        addView(mContainer,0);
    }

    @Override
    public void addView(View child) {
        mContainer.addView(child);
    }

    public void setAdapter(ListAdapter adapter) {
        this.mAdapter = adapter;
        int count = mAdapter.getCount();
        for (int i = 0; i < count; i++) {
            View childView = mAdapter.getView(i, mContainer);
            addView(childView);
        }
    }
}
