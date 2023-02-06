package com.example.architect_day11.day14.observer_mode.simple3.observable;

import java.util.Observable;

public class WXAndroidObservable extends Observable {

    private String article;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
        //更新文章
        setChanged();
        notifyObservers(article);
    }
}
