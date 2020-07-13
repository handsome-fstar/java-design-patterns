package com.fstar.designpattern.facade.carsystem;

public class CoolingController {
    // 默认散热器速度
    private static final int DEFAULT_RADIATOR_SPEED = 10;

    // 温度上限
    private int temperatureUpperLimit;

    // 散热器
    private Radiator radiator = new Radiator();

    // 温度传感器
    private TemperatureSensor temperatureSensor = new TemperatureSensor();

    public void setTemperatureUpperLimit(int temperatureUpperLimit) {
        System.out.println("设置温度的上限为：" + temperatureUpperLimit);
        this.temperatureUpperLimit = temperatureUpperLimit;
    }

    public void run() {
        System.out.println("冷却控制器准备好了！");
        radiator.setSpeed(DEFAULT_RADIATOR_SPEED);
    }

    public void cool(int maxAllowedTemp) {
        System.out.println("预设冷却最高允许温度为：" + maxAllowedTemp);
        temperatureSensor.getTemperature();
        radiator.on();
    }

    public void stop() {
        System.out.println("冷却控制器停止");
        radiator.off();
    }

}
