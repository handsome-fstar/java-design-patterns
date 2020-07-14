package com.fstar.designpattern.memento;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);           // 最初的所持金币数为100
        Memento memento = gamer.createMemento();       // 保存最初的状态
        for (int i = 0; i < 50; i++) {
            System.out.println("==== " + i);
            System.out.println("当前状态：" + gamer);
            gamer.bet();                               // 游戏开始
            System.out.println("所持金钱为" + gamer.getMoney() + "元。");
            // 决定如何处理Memento
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("     (这把游戏的金钱比上次存档的金钱多，必须存档！！！！)");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("     (输多了，不行不行，必须恢复之前的存档！！！)");
                gamer.restoreMemento(memento);
            }
            // 等待一段时间
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }
}
