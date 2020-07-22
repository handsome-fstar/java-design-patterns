package com.fstar.designpattern.adapter;

public class AC110 implements AC {
    private final int output = 110;
    @Override
    public int outputAC() {
        return this.output;
    }
}
