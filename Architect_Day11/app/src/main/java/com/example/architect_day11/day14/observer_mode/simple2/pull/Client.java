package com.example.architect_day11.day14.observer_mode.simple2.pull;

import com.example.architect_day11.day14.observer_mode.simple2.pull.observable.PullWXAndroidObservable;
import com.example.architect_day11.day14.observer_mode.simple2.pull.observer.PullWXUser;

public class Client {

    public static void main(String[] args) {
        PullWXAndroidObservable wxAndroidObservable = new PullWXAndroidObservable();
        PullWXUser wxUser1 = new PullWXUser("coder1");
        PullWXUser wxUser2 = new PullWXUser("coder2");
        wxAndroidObservable.register(wxUser1);
        wxAndroidObservable.register(wxUser2);
        wxAndroidObservable.setArticle("hello world");
    }
}
