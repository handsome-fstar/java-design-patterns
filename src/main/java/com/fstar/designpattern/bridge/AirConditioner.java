package com.fstar.designpattern.bridge;

public class AirConditioner implements ElectricAppliance {
    private final String name = "空调";
    @Override
    public String description() {
        return name;
    }
}
