package com.fstar.designpattern.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PCLNewsObservable {
    private String news;

    private PropertyChangeSupport support;

    public PCLNewsObservable() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void changeNews(String news) {
        support.firePropertyChange("news", this.news, news);
        this.news = news;
    }
}
