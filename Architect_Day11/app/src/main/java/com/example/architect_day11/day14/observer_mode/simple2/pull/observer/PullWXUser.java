package com.example.architect_day11.day14.observer_mode.simple2.pull.observer;

import com.example.architect_day11.day14.observer_mode.simple2.pull.observable.PullWXAndroidObservable;
import com.example.architect_day11.day14.observer_mode.simple2.pull.observable.PullWXPublicObservable;

public class PullWXUser implements IPullWXUser {

    private String name;

    public PullWXUser(String name) {
        this.name = name;
    }

    @Override
    public void pull(PullWXPublicObservable wxPublicObservable) {
        PullWXAndroidObservable androidObservable = (PullWXAndroidObservable) wxPublicObservable;
        System.out.println(name+" auto pull:"+androidObservable.getArticle());
    }
}
