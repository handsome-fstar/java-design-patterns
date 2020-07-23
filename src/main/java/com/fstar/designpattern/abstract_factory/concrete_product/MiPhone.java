package com.fstar.designpattern.abstract_factory.concrete_product;

import com.fstar.designpattern.abstract_factory.abstract_product.Phone;

public class MiPhone extends Phone {

    @Override
    public void describe() {
        System.out.println("小米手机");
    }

}
