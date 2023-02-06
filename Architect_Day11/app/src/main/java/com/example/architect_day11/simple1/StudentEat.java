package com.example.architect_day11.simple1;

import android.util.Log;

public class StudentEat implements Eat{
    @Override
    public void eat() {
        Log.e("TAG","学生吃菜");
    }
}
