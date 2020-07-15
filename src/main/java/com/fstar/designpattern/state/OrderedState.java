package com.fstar.designpattern.state;

public class OrderedState implements State {
    @Override
    public void next(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void prev(Package pkg) {
        System.out.println("已经是最初的状态了。");
    }

    @Override
    public void printStatus() {
        System.out.println("已下单，还没有交付物流。");
    }
}
