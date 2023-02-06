package com.example.architect_day11.day14.observer_mode.simple1;

public class WXUser implements IWXUser{

    private String name;

    public WXUser(String name) {
        this.name = name;
    }

    @Override
    public void push(String article) {
        System.out.println(name+" receive an article:"+article);
    }
}
