package com.fstar.designpattern.adapter;

public class JapanPowerAdapter implements DC5Adapter {
    public static final int VOLTAGE = 110;

    @Override
    public boolean support(AC ac) {
        return ac.outputAC() == this.VOLTAGE;
    }

    @Override
    public int outputDC5V(AC ac) {
        int adapterInput = ac.outputAC();
        //变压器...
        int adapterOutput = adapterInput / 22;
        System.out.println("使用JapanPowerAdapter变压适配器，输入AC:" + adapterInput + "V" + "，输出DC:" + adapterOutput + "V");
        return adapterOutput;
    }
}
