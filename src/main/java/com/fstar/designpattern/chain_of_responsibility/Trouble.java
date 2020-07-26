package com.fstar.designpattern.chain_of_responsibility;

public class Trouble {
    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public String toString() {
        return "[Trouble " + number + "]";
    }
}
