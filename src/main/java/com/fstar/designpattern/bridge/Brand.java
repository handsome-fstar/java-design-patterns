package com.fstar.designpattern.bridge;

public abstract class Brand {
    protected ElectricAppliance electricAppliance;

    public Brand(ElectricAppliance electricAppliance) {
        this.electricAppliance = electricAppliance;
    }

    public abstract String description();
}
