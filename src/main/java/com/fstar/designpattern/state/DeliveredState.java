package com.fstar.designpattern.state;

public class DeliveredState implements State {
    @Override
    public void next(Package pkg) {
        pkg.setState(new ReceivedState());
    }

    @Override
    public void prev(Package pkg) {
        pkg.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("物流已发出，还没有签收！");
    }
}
