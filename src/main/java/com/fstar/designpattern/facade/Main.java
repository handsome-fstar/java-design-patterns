package com.fstar.designpattern.facade;

public class Main {
    public static void main(String[] args) {
        CarEngineFacade carEngineFacade = new CarEngineFacade();
        carEngineFacade.startEngine();
        System.out.println("--------------------");
        carEngineFacade.stopEngine();
    }
}
