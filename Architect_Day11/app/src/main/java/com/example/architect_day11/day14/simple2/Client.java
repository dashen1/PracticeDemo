package com.example.architect_day11.day14.simple2;

public class Client {

    public static void main(String[] args) {
        RMBAdapter rmbAdapter = new RMBAdapter(56);

        float rmb = rmbAdapter.getRmb();
        System.out.println("rmb:"+rmb);
    }
}
