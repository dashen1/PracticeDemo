package com.example.architect_day11.day14.simple2;

public class Adapter extends RMBAdapter implements UsdTarget{

    public Adapter(float mRmb) {
        super(mRmb);
    }

    @Override
    public float getUsd() {
        return 0;
    }
}
