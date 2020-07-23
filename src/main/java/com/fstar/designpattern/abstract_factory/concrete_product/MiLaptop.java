package com.fstar.designpattern.abstract_factory.concrete_product;

import com.fstar.designpattern.abstract_factory.abstract_product.Laptop;

public class MiLaptop extends Laptop {

    @Override
    public void describe() {
        System.out.println("小米笔记本");
    }

}
