package com.fstar.designpattern.proxy;

public class Printer implements Printable {
    public Printer() {
        heavyJob("正在生成Printer的实例");
    }

    public void print(String string) {
        System.out.println(string);
    }

    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("ok");
    }
}
