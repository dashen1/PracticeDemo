package com.example.architect_day11.day14.observer_mode.simple4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.architect_day11.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Observer<Member>{

    private static String TAG = "MainActivity";

    private ListView mMemberLv;
    private List<Member> mMembers;
    private BaseAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_insurance);
        mMemberLv = (ListView) findViewById(R.id.member_lv);
        mMembers = new ArrayList<>();
        setAdapter();

        DatabaseManager.getInstance().register(this);
    }

    private void setAdapter() {
        if (mAdapter == null) {
            mAdapter = new BaseAdapter() {
                @Override
                public int getCount() {
                    return mMembers.size();
                }

                @Override
                public Object getItem(int position) {
                    return mMembers.get(position);
                }

                @Override
                public long getItemId(int position) {
                    return position;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    TextView nameTv = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.insurance_item_lv, parent, false);
                    nameTv.setText(mMembers.get(position).getName());
                    return nameTv;
                }
            };

            mMemberLv.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void addMember(View view) {
        Intent intent = new Intent(this, InsuranceActivity.class);
        startActivity(intent);
        //startActivityForResult(intent,10);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        System.out.println("hello world");
//        System.out.println(data.getExtras().getString("key"));
//    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void update(Member member) {
        Log.e(TAG, "name = "+member.getName());
        mMembers.add(member);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DatabaseManager.getInstance().unregister(this);
    }
}
