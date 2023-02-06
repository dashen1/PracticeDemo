package com.example.architect_day11.day14.observer_mode.simple1;

public class WXAndroidObservable extends WXPublicObservable {

    private String article;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
        update(article);
    }
}
