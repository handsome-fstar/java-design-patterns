package com.fstar.designpattern.adapter;

public interface DC5Adapter {
    boolean support(AC ac);
    int outputDC5V(AC ac);
}
