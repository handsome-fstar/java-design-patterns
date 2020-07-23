package com.fstar.designpattern.factory_method;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product mike = factory.createProduct("Mike");
        Product jimmy = factory.createProduct("Jimmy");
        mike.use();
        jimmy.use();
    }
}
