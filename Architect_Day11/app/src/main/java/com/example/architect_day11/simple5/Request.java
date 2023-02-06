package com.example.architect_day11.simple5;

import java.util.concurrent.Callable;

public class Request implements Runnable, Comparable<Request> {
    @Override
    public int compareTo(Request o) {
        return 0;
    }

    @Override
    public void run() {
        System.out.println("run Request");
    }
}
