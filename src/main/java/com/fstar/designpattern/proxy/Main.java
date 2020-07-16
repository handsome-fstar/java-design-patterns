package com.fstar.designpattern.proxy;

public class Main {
    public static void main(String[] args) {
        // 使用代理打印机去打印。
        Printable p1 = new PrinterProxy();
        p1.print("Hello world.");
        p1.print("Hello world.");
    }
}
