package com.fstar.designpattern.mediator;

public class PowerSupplier extends Colleague {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void turnOn() {
        System.out.println("通电！");
    }

    public void turnOff() {
        System.out.println("断电！");
    }

}
