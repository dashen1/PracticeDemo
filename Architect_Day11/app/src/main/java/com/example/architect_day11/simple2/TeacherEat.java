package com.example.architect_day11.simple2;

import android.util.Log;

import com.example.architect_day11.simple1.Eat;

public class TeacherEat implements Eat {

    Eat eat;

    public TeacherEat(Eat eat) {
        this.eat = eat;
    }

    @Override
    public void eat() {
        Log.e("TAG","老师吃饭");
        eat.eat();
    }
}
