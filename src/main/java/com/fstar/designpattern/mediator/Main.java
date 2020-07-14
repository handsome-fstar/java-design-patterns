package com.fstar.designpattern.mediator;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Button button = new Button();
        Fan fan = new Fan();
        PowerSupplier powerSupplier = new PowerSupplier();
        mediator.setButton(button);
        mediator.setFan(fan);
        mediator.setPowerSupplier(powerSupplier);

        button.press();
        System.out.println("------------------");
        button.press();
    }
}
