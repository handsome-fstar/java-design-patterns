package com.fstar.designpattern.abstract_factory;

import com.fstar.designpattern.abstract_factory.abstract_factory.TechFactory;
import com.fstar.designpattern.abstract_factory.abstract_product.Earphone;
import com.fstar.designpattern.abstract_factory.concrete_factory.AppleTechFactory;
import com.fstar.designpattern.abstract_factory.concrete_factory.MiTechFactory;

public class Main {
    public static void main(String[] args) {
        TechFactory appleTechFactory = new AppleTechFactory();
        Earphone earphone = appleTechFactory.sellEarPhone();
        earphone.describe();

        TechFactory miTechFactory = new MiTechFactory();
        miTechFactory.sellLaptop().describe();
    }
}
