package com.example.architect_day11.simple1;

import android.util.Log;

public class TeacherEat implements Eat{
    @Override
    public void eat() {
        Log.e("TAG","老师吃饭");
    }
}
