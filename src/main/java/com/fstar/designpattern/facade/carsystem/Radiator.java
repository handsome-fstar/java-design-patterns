package com.fstar.designpattern.facade.carsystem;

public class Radiator {
    public void on() {
        System.out.println("散热器开启！");
    }

    public void off() {
        System.out.println("散热器关闭！");
    }

    public void setSpeed(int speed) {
        System.out.println("设置散热速度到：" + speed);
    }
}
