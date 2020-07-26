package com.fstar.designpattern.bridge;

public class Haier extends Brand {
    private final String name = "海尔";
    public Haier(ElectricAppliance electricAppliance) {
        super(electricAppliance);
    }

    @Override
    public String description() {
        return name + electricAppliance.description();
    }
}
