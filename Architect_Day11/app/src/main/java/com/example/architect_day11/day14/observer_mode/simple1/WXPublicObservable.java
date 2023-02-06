package com.example.architect_day11.day14.observer_mode.simple1;

import java.util.ArrayList;
import java.util.List;

public class WXPublicObservable {
    public List<IWXUser> mWXUsers;

    public WXPublicObservable() {
        this.mWXUsers = new ArrayList<>();
    }

    public void register(IWXUser wxUser){
        mWXUsers.add(wxUser);
    }

    public void unregister(IWXUser wxUser){
        mWXUsers.remove(wxUser);
    }

    public void update(String article){
        for (IWXUser mWXUser : mWXUsers) {
            mWXUser.push(article);
        }
    }
}
