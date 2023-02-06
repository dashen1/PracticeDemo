package com.example.architect_day11.day14.simple3;

public class Client {

    public static void main(String[] args) {
        RMBAdapter rmbAdapter = new RMBAdapter(56);

        Adapter adapter = new Adapter(rmbAdapter);
        float usd = adapter.getUsd();
        System.out.println("rmb:"+usd);
    }
}
