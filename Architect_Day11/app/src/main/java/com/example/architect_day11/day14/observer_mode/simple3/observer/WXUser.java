package com.example.architect_day11.day14.observer_mode.simple3.observer;

import com.example.architect_day11.day14.observer_mode.simple3.observable.WXAndroidObservable;

import java.util.Observable;
import java.util.Observer;

public class WXUser implements Observer {

    private String name;

    public WXUser(String name) {
        this.name = name;
    }

    //推、拉模式
    @Override
    public void update(Observable o, Object arg) {

        System.out.println(name+" 收到推送文章："+arg);
        WXAndroidObservable androidObservable = (WXAndroidObservable) o;
        System.out.println(name+" 主动拉去一篇文章："+androidObservable.getArticle());
    }
}
