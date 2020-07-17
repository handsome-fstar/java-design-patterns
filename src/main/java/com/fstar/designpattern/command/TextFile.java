package com.fstar.designpattern.command;

/**
 * Receiver
 */
public class TextFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public String open() {
        System.out.println("打开" + name);
        return "打开" + name;
    }

    public String close() {
        System.out.println("关闭" + name);
        return "关闭" + name;
    }
}
