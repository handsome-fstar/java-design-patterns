package com.fstar.designpattern.composite;

public class Main {

    public static void main(String[] args) {
        try {
            Entry entry = new Directory("designpattern");
            File app = new File("JavaDesignPatterns.java", 3);
            Directory designPattern = new Directory("DesignPattern");
            Directory abstractFactory = new Directory("AbstractFactory");
            File main = new File("Main.java", 20);

            entry.add(app);
            entry.add(designPattern);

            abstractFactory.add(main);
            designPattern.add(abstractFactory);

            entry.printList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
