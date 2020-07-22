package com.fstar.designpattern.template;

public class Main {
    public static void main(String[] args) {
        AbstractDisplay display1 = new CharDisplay('A');
        display1.display();
        AbstractDisplay display2 = new StringDisplay(" Hello world ");
        display2.display();
    }
}
