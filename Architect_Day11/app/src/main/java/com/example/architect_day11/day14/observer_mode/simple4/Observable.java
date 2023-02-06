package com.example.architect_day11.day14.observer_mode.simple4;

import java.util.ArrayList;
import java.util.List;

public class Observable<M, T extends Observer<M>> {
    private List<T> observables;

    public Observable() {
        observables = new ArrayList<>();
    }

    public void register(T observer){
        observables.add(observer);
    }

    public void unregister(T observer){
        observables.remove(observer);
    }

    public void addUpdate(M m){
        for (T observable : observables) {
            observable.update(m);
        }
    }
}
