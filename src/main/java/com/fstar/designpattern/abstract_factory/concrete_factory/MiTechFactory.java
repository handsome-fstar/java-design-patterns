package com.fstar.designpattern.abstract_factory.concrete_factory;

import com.fstar.designpattern.abstract_factory.concrete_product.MiEarphone;
import com.fstar.designpattern.abstract_factory.concrete_product.MiLaptop;
import com.fstar.designpattern.abstract_factory.concrete_product.MiPhone;
import com.fstar.designpattern.abstract_factory.abstract_factory.TechFactory;
import com.fstar.designpattern.abstract_factory.abstract_product.Earphone;
import com.fstar.designpattern.abstract_factory.abstract_product.Laptop;
import com.fstar.designpattern.abstract_factory.abstract_product.Phone;

public class MiTechFactory extends TechFactory {
    @Override
    public Phone sellPhone() {
        return new MiPhone();
    }

    @Override
    public Laptop sellLaptop() {
        return new MiLaptop();
    }

    @Override
    public Earphone sellEarPhone() {
        return new MiEarphone();
    }
}
