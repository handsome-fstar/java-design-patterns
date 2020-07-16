package com.fstar.designpattern.flyweight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    // 字符名字
    private char charname;
    // 大型字符对应的字符串(由'#' '.' '\n'组成)
    private String fontdata;
    // 构造函数
    public BigChar(char charname) {
        this.charname = charname;
        try {
            BufferedReader reader = new BufferedReader(
                new FileReader(System.getProperty("user.dir")
                        + "\\src\\main\\java\\com\\fstar\\designpattern\\flyweight\\big" + charname + ".txt")
            );
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontdata = buf.toString();
        } catch (IOException e) {
            e.printStackTrace();
            this.fontdata = charname + "?";
        }
    }
    // 显示大型字符
    public void print() {
        System.out.print(fontdata);
    }
}
