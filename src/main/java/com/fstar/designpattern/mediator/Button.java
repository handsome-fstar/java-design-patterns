package com.fstar.designpattern.mediator;

public class Button extends Colleague {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void press() {
        System.out.println("按了一下开关！");
        this.mediator.press();
    }
}
