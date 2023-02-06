package com.example.architect_day11.day14.observer_mode.simple4;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.architect_day11.R;

public class InsuranceActivity extends AppCompatActivity {

    private EditText mNameEt,mAgeEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);
        mNameEt = (EditText)findViewById(R.id.name_et);
        mAgeEt = (EditText)findViewById(R.id.age_et);

    }

    public void add(View view) {
        //添加人员

        //插入到数据库

        DatabaseManager.getInstance().insert(new Member(mNameEt.getText().toString(),mAgeEt.getText().toString()));

        Toast.makeText(this, "added success", Toast.LENGTH_SHORT).show();
        //怎么去通知我们的主Activity去更新？
        //1、可以在关闭的时候setResult 会调用MainActivity的onActivityResult
        //2、可以利用EventBus去发送更新
        //3、还有就是当页面关闭的时候可以去读取数据库
        //4、利用观察者模式去更新我们的列表
    }


    public void finish(View view) {
//        Intent intent = new Intent();
//        intent.putExtra("key","value");
//        InsuranceActivity.this.setResult(10,intent);
        finish();
    }


}
