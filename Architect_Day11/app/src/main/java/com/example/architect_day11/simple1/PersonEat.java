package com.example.architect_day11.simple1;

import android.util.Log;

public class PersonEat implements Eat{
    @Override
    public void eat() {
        Log.e("TAG","人吃菜");
    }
}
