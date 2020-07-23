package com.fstar.designpattern.abstract_factory.concrete_product;

import com.fstar.designpattern.abstract_factory.abstract_product.Earphone;

public class MiEarphone extends Earphone {
    @Override
    public void describe() {
        System.out.println("小米耳机");
    }
}
