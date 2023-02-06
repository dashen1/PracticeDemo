package com.example.architect_day11.simple2;

import android.util.Log;

import com.example.architect_day11.simple1.Eat;

public class PersonEat implements Eat {
    @Override
    public void eat() {
        Log.e("TAG","人吃菜");
    }
}
