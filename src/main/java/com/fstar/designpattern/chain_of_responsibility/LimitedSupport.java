package com.fstar.designpattern.chain_of_responsibility;

public class LimitedSupport extends Support {
    private int limit;

    public LimitedSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        } else {
            return false;
        }
    }
}
