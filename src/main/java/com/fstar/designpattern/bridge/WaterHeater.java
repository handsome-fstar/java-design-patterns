package com.fstar.designpattern.bridge;

public class WaterHeater implements ElectricAppliance {
    private final String name = "热水器";
    @Override
    public String description() {
        return name;
    }
}
