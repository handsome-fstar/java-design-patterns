package com.fstar.designpattern.adapter;

public class ChinaPowerAdapter implements DC5Adapter {
    public static final int VOLTAGE = 220;

    @Override
    public boolean support(AC ac) {
        return ac.outputAC() == this.VOLTAGE;
    }

    @Override
    public int outputDC5V(AC ac) {
        int adapterInput = ac.outputAC();
        // 变压器...
        int adapterOutput = adapterInput / 44;
        System.out.println("使用ChinaPowerAdapter变压适配器，输入AC:" + adapterInput + "V" + "，输出DC:" + adapterOutput + "V");
        return adapterOutput;
    }
}
