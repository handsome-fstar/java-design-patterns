package com.fstar.designpattern.decorator;

public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world.");
        Display b2 = new SideBoarder(b1, '#');
        Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();
        Display b4 = new SideBoarder(
                new FullBorder(
                        new FullBorder(
                                new FullBorder(
                                        new SideBoarder(
                                                new FullBorder(
                                                        new StringDisplay(" This is awesome ")
                                                ), '*')
                                )
                        )
                ), '/'
        );
        b4.show();
    }
}
