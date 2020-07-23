package com.fstar.designpattern.abstract_factory.concrete_factory;

import com.fstar.designpattern.abstract_factory.concrete_product.AppleEarphone;
import com.fstar.designpattern.abstract_factory.concrete_product.AppleLaptop;
import com.fstar.designpattern.abstract_factory.concrete_product.ApplePhone;
import com.fstar.designpattern.abstract_factory.abstract_factory.TechFactory;
import com.fstar.designpattern.abstract_factory.abstract_product.Earphone;
import com.fstar.designpattern.abstract_factory.abstract_product.Laptop;
import com.fstar.designpattern.abstract_factory.abstract_product.Phone;

public class AppleTechFactory extends TechFactory {
    @Override
    public Phone sellPhone() {
        return new ApplePhone();
    }

    @Override
    public Laptop sellLaptop() {
        return new AppleLaptop();
    }

    @Override
    public Earphone sellEarPhone() {
        return new AppleEarphone();
    }
}
