package com.example.architect_day11.day14.observer_mode.simple1;

public class Client {

    public static void main(String[] args) {
        WXAndroidObservable wxAndroidObservable = new WXAndroidObservable();
        WXUser wxUser1 = new WXUser("coder1");
        WXUser wxUser2 = new WXUser("coder2");
        wxAndroidObservable.register(wxUser1);
        wxAndroidObservable.register(wxUser2);
        wxAndroidObservable.update("new article");
    }
}
