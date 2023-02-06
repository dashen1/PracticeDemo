package com.example.architect_day11.day14.observer_mode.simple2.pull.observable;

import com.example.architect_day11.day14.observer_mode.simple2.pull.observer.IPullWXUser;

import java.util.ArrayList;
import java.util.List;

public class PullWXPublicObservable {
    public List<IPullWXUser> mWXUsers;

    public PullWXPublicObservable() {
        this.mWXUsers = new ArrayList<>();
    }

    public void register(IPullWXUser wxUser){
        mWXUsers.add(wxUser);
    }

    public void unregister(IPullWXUser wxUser){
        mWXUsers.remove(wxUser);
    }

    public void update(String article){
        for (IPullWXUser mWXUser : mWXUsers) {
            mWXUser.pull(this);
        }
    }
}
