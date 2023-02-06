package com.example.architect_day11.day14.observer_mode.simple2.pull.observer;

import com.example.architect_day11.day14.observer_mode.simple2.pull.observable.PullWXPublicObservable;

public interface IPullWXUser {
    void pull(PullWXPublicObservable wxPublicObservable);
}
