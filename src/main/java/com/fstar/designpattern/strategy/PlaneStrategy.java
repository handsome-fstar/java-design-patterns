package com.fstar.designpattern.strategy;

public class PlaneStrategy implements TravelStrategy {
    @Override
    public void travelStrategy() {
        System.out.println("travel by plane");
    }
}
