package com.example.architect_day11.day14.simple1;

public class RMBAdapter {
    private float mRmb;

    public RMBAdapter(float mRmb) {
        this.mRmb = mRmb;
    }

    public float getRmb() {
        return mRmb;
    }

    public float getUsd(){
        return mRmb / 5.6f;
    }
}
