package com.fstar.designpattern.strategy;

public class Main {
    public static void main(String[] args) {
        Traveler traveler1 = new Traveler(new TrainStrategy());
        traveler1.travel();
        Traveler traveler2 = new Traveler(new PlaneStrategy());
        traveler2.travel();
    }
}
