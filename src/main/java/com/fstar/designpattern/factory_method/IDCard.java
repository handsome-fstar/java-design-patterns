package com.fstar.designpattern.factory_method;

public class IDCard extends Product {
    private String owner;

    // 这个构造器没有使用public，不写默认只有本包的类可以使用
    // 只允许IDCardFactory来创建这个对象，不允许其他包的来直接创建
    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡");
    }
}
