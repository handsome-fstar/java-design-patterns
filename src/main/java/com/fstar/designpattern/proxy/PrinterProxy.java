package com.fstar.designpattern.proxy;

public class PrinterProxy implements Printable {
    Printer realPrinter;
    public PrinterProxy() {
    }

    public void print(String string) {
        realize();
        realPrinter.print(string);
    }

    private synchronized void realize() {
        if (realPrinter == null) {
            realPrinter = new Printer();
        }
    }
}
