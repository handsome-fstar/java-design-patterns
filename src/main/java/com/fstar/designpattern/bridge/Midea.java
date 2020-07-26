package com.fstar.designpattern.bridge;

public class Midea extends Brand {
    private final String name = "美的";
    public Midea(ElectricAppliance electricAppliance) {
        super(electricAppliance);
    }

    @Override
    public String description() {
        return name + electricAppliance.description();
    }
}
