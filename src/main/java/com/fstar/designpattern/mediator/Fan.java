package com.fstar.designpattern.mediator;

public class Fan extends Colleague {
    private Mediator mediator;
    private boolean isOn = false;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        this.mediator.start();
        isOn = true;
        System.out.println("风扇打开了！");
    }

    public void turnOff() {
        isOn = false;
        this.mediator.stop();
        System.out.println("风扇关闭了！");
    }
}
