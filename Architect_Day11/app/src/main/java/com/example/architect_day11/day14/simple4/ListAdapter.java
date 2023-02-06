package com.example.architect_day11.day14.simple4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.architect_day11.R;

import java.util.List;

public class ListAdapter implements AdapterTarget{

    private List<String> mItems;
    private Context mContext;

    public ListAdapter(List<String> mItems, Context mContext) {
        this.mItems = mItems;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public View getView(int position, ViewGroup parent) {
        TextView itemView = (TextView)LayoutInflater.from(mContext).inflate(R.layout.item_lv, parent,false);
        itemView.setText(mItems.get(position));
        return itemView;
    }
}
