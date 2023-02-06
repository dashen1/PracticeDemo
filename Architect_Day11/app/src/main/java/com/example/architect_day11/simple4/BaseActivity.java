package com.example.architect_day11.simple4;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1、设置布局
        setContentView();
        //2、初始化title
        if(flagTest())
        initTitle();
        //3、初始化view
        initView();
        //4、访问接口数据
        initData();
    }

    protected boolean flagTest(){
        return true;
    }

    protected abstract void setContentView();

    protected abstract void initTitle();

    protected abstract void initView();

    protected abstract void initData();

    public void startActivity(Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
