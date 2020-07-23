package com.fstar.designpattern.abstract_factory.abstract_factory;

import com.fstar.designpattern.abstract_factory.abstract_product.Earphone;
import com.fstar.designpattern.abstract_factory.abstract_product.Laptop;
import com.fstar.designpattern.abstract_factory.abstract_product.Phone;

public abstract class TechFactory {
    public abstract Phone sellPhone();
    public abstract Laptop sellLaptop();
    public abstract Earphone sellEarPhone();
}
