package com.example.architect_day11.day14.simple3;

public class Adapter implements UsdTarget {
    private RMBAdapter rmbAdapter;

    public Adapter(RMBAdapter rmbAdapter) {
        this.rmbAdapter = rmbAdapter;
    }

    @Override
    public float getUsd() {
        return rmbAdapter.getRmb()/5.6f;
    }
}
