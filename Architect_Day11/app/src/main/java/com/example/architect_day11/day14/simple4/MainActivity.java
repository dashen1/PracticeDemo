package com.example.architect_day11.day14.simple4;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.architect_day11.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CoderListView mListView;
    private List<String> items = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mListView = findViewById(R.id.coder_lv);
        for (int i = 0; i < 100; i++) {
            items.add(i+"");
        }
        //ListView需要的是View,后台返回数据，需要我们去适配

        //一般写法 for循环不断添加view
//        for (String item : items) {
//            TextView itemView = (TextView)LayoutInflater.from(this).inflate(R.layout.item_lv, null);
//            itemView.setText(item);
//            mListView.addView(itemView);
//        }

        mListView.setAdapter(new ListAdapter(items, this));
    }

}
