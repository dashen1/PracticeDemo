package com.example.architect_day11.day14.observer_mode.simple3;

import com.example.architect_day11.day14.observer_mode.simple3.observable.WXAndroidObservable;
import com.example.architect_day11.day14.observer_mode.simple3.observer.WXUser;

public class Client {

    public static void main(String[] args) {
        WXAndroidObservable androidObservable = new WXAndroidObservable();
        WXUser coder1 = new WXUser("coder1");
        WXUser coder2 = new WXUser("coder2");
        androidObservable.addObserver(coder1);
        androidObservable.addObserver(coder2);
        androidObservable.setArticle("new world!");
    }
}
