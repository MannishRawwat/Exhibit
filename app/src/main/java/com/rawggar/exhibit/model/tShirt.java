package com.rawggar.exhibit.model;
//This is just added and should be shown in pull

//This is git version
public class tShirt {
    String url;
    String title;

    public tShirt(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
