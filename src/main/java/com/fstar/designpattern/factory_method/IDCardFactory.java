package com.fstar.designpattern.factory_method;

public class IDCardFactory extends Factory {
    @Override
    public Product createProduct(String owner) {
        return new IDCard(owner);
    }
}
