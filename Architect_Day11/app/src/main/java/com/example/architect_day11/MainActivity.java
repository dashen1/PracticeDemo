package com.example.architect_day11;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architect_day11.simple3.WrapRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WrapRecyclerView mRecycleView;
    private List<Integer> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItems = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mItems.add(i);
        }
        Log.d("TAG","items size:"+mItems.size());

        mRecycleView = (WrapRecyclerView) findViewById(R.id.recycler_view);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
//        RecyclerAdapter mRealAdapter = new RecyclerAdapter();
//        WrapRecyclerAdapter<Object> wrapRecyclerAdapter = new WrapRecyclerAdapter<>(mRealAdapter);
        mRecycleView.setAdapter(new RecyclerAdapter());
        View headerView = LayoutInflater.from(this).inflate(R.layout.layout_header_view, mRecycleView, false);
        mRecycleView.addHeaderView(headerView);
        //面向对象 最少知识原则
        //业务逻辑能分开就分开 中间层和底层能封装就封装
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_rv, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
            holder.text.setText("position ="+mItems.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItems.remove(position);
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            private TextView text;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.text);
            }
        }
    }
}