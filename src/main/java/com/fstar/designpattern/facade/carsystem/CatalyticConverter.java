package com.fstar.designpattern.facade.carsystem;

public class CatalyticConverter {
    public void on() {
        System.out.println("催化转化器开启，有害排放降低了！");
    }

    public void off() {
        System.out.println("催化转化器已关闭！");
    }
}
