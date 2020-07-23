package com.fstar.designpattern.builder;

public class Main {
    public static void main(String[] args) {
        // 直接new Computer对象，提供默认配置
        Computer computer = new Computer();
        System.out.println(computer);

        // 自定义配置
        Computer.Builder builder = new Computer.Builder();
        Computer computer1 = builder
                .CPU("3900X")
                .cooler("original cooler")
                .memory("16G")
                .graphicsCard("5700XT")
                .motherboard("X570")
                .build();
        System.out.println(computer1);

        Computer computer2 = new Computer.Builder()
                .CPU("i9")
                .cooler("water cooler")
                .memory("64G")
                .graphicsCard("2080TI")
                .motherboard("ROG")
                .build();
        System.out.println(computer2);
    }
}
