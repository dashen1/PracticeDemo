package com.example.architect_day11.simple3;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WrapRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //原来的RecyclerView.Adapter 并不支持头部和底部 所以进行扩展
    private RecyclerView.Adapter mRealAdapter;
    ArrayList<View> mHeaderViews;
    ArrayList<View> mFooterViews;

    public WrapRecyclerAdapter(RecyclerView.Adapter mRealAdapter) {
        this.mRealAdapter = mRealAdapter;
        mRealAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                notifyDataSetChanged();
            }
        });
        mHeaderViews = new ArrayList<>();
        mFooterViews = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        // mHeader头部返回头部的ViewHolder
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return createHeaderFooterViewHolder(mHeaderViews.get(position));
        }
        // mRealAdapter真实的返回真实的ViewHolder
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mRealAdapter != null) {
            adapterCount = mRealAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                return mRealAdapter.createViewHolder(parent, mRealAdapter.getItemViewType(position));
            }
        }
        // mFooter底部的返回底部的ViewHolder
        return createHeaderFooterViewHolder(mFooterViews.get(adjPosition-adapterCount));
    }

    private RecyclerView.ViewHolder createHeaderFooterViewHolder(View view) {
        return new RecyclerView.ViewHolder(view){};
    }

    private int getHeadersCount() {
        return mHeaderViews.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // mHeader头部返回头部的ViewHolder
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return;
        }
        Log.d("TAG","position:"+position);
        // mRealAdapter真实的返回真实的ViewHolder
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mRealAdapter != null) {
            adapterCount = mRealAdapter.getItemCount();
            if (adjPosition < adapterCount) {
                mRealAdapter.onBindViewHolder(holder, adjPosition);
            }
        }
        // mFooter底部的返回底部的ViewHolder
    }

    @Override
    public int getItemCount() {//头部+底部+真实的Adapter条数
        return mHeaderViews.size()+mFooterViews.size()+mRealAdapter.getItemCount();
    }

    @Override
    public int getItemViewType(int position) { // 直接把位置作为ViewType
        return position;
    }

    public void addHeaderView(View view){
        if(!mHeaderViews.contains(view)){
            mHeaderViews.add(view);
            notifyDataSetChanged();
        }
    }

    public void removeHeaderView(View view){
        if(mHeaderViews.contains(view)){
            mHeaderViews.remove(view);
            notifyDataSetChanged();
        }
    }

    public void addFooterView(View view){
        if(!mFooterViews.contains(view)){
            mFooterViews.add(view);
            notifyDataSetChanged();
        }
    }

    public void removeFooterView(View view){
        if(mFooterViews.contains(view)){
            mFooterViews.remove(view);
            notifyDataSetChanged();
        }
    }
}
