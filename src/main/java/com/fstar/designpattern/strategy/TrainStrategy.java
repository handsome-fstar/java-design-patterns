package com.fstar.designpattern.strategy;

public class TrainStrategy implements TravelStrategy {
    @Override
    public void travelStrategy() {
        System.out.println("travel by train");
    }
}
