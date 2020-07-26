package com.fstar.designpattern.bridge;

public class Gree extends Brand {
    private final String name = "格力";

    public Gree(ElectricAppliance electricAppliance) {
        super(electricAppliance);
    }

    @Override
    public String description() {
        return name + electricAppliance.description();
    }

}
