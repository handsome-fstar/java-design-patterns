package com.fstar.designpattern.facade.carsystem;

public class AirFlowController {
    private AirFlowMeter airFlowMeter = new AirFlowMeter();

    public void takeAir() {
        airFlowMeter.getMeasurements();
        System.out.println("气流控制器开始提供气流！");
    }

    public void off() {
        System.out.println("气流控制器关闭");
    }
}
