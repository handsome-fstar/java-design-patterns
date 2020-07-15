package com.fstar.designpattern.state;

public class ReceivedState implements State {
    @Override
    public void next(Package pkg) {
        System.out.println("包裹已经签收，没有之后的状态拉！");
    }

    @Override
    public void prev(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("包裹已签收。");
    }

    @Override
    public String toString() {
        return "ReceivedState{}";
    }
}
