package com.fstar.designpattern.observer;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();

        System.out.println("----------------------");

        PCLNewsObservable observable = new PCLNewsObservable();
        PCLNewsObserver observer = new PCLNewsObserver();
        observable.addPropertyChangeListener(observer);
        observable.changeNews("new 1");
        observable.changeNews("new 2");
    }
}
