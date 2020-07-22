package com.fstar.designpattern.adapter;

import java.util.LinkedList;
import java.util.List;

public class Main {
    private List<DC5Adapter> adapters = new LinkedList<>();

    public Main() {
        this.adapters.add(new ChinaPowerAdapter());
        this.adapters.add(new JapanPowerAdapter());
    }

    public DC5Adapter getDC5Adapter(AC ac) {
        DC5Adapter dc5Adapter = null;
        for (DC5Adapter dc5 : adapters) {
            if (dc5.support(ac)) {
                dc5Adapter = dc5;
                break;
            }
        }
        if (dc5Adapter == null) {
            throw new IllegalArgumentException("没有找到合适的变压适配器");
        }
        return dc5Adapter;
    }

    public static void main(String[] args) {
        Main main = new Main();
        AC chinaAC = new AC220();
        main.getDC5Adapter(chinaAC).outputDC5V(chinaAC);

        AC japanAC = new AC110();
        main.getDC5Adapter(japanAC).outputDC5V(japanAC);
    }
}
