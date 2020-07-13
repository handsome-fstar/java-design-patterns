package com.fstar.designpattern.facade.carsystem;

public class FuelInjector {
    private FuelPump fuelPump = new FuelPump();

    public void on() {
        System.out.println("喷油器准备喷油！");
    }

    public void inject() {
        fuelPump.pump();
        System.out.println("开始喷油！");
    }

    public void off() {
        System.out.println("停止喷油！");
    }
}
