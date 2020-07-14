package com.fstar.designpattern.memento;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;                              // 所持金钱
    private List fruits = new ArrayList<>();        // 获得的水果
    private Random random = new Random();           // 随机数生成器
    private static String[] fruitsName = {          // 表示水果种类的数组
            "苹果", "葡萄", "香蕉", "橘子"
    };

    public Gamer(int money) {                       // 构造函数
        this.money = money;
    }

    public int getMoney() {                         // 获取当前所持金钱
        return money;
    }

    public void bet() {                             // 投掷骰子进行游戏
        int dice = random.nextInt(6) + 1;    // 投骰子
        if (dice == 1) {                            // 骰子结果为1时，增加所持金钱
            money += 100;
            System.out.println("所持金钱增加了。");
        } else if (dice == 2) {                     // 骰子结果为2时，所持金钱减半
            money /= 2;
            System.out.println("所持金钱减半了。");
        } else if (dice == 6) {                     // 骰子结果为6时，获得水果
            String fruit = getFruit();
            System.out.println("获得了水果(" + fruit + ")。");
            fruits.add(fruit);
        } else {                                    // 骰子结果为3、4. 5则什么都不会发生
            System.out.println("什么都没有发生。");
        }
    }

    public Memento createMemento() {                // 拍摄快照(存档)
        Memento memento = new Memento(money);
        Iterator iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = (String) iterator.next();
            if (fruit.startsWith("好吃的")) {        // 只保存好吃的水果
                memento.addFruit(fruit);
            }
        }
        return memento;
    }

    public void restoreMemento(Memento memento) {   // 撤销
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }

    private String getFruit() {                     // 获得一个水果
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "好吃的";
        }
        return prefix + fruitsName[random.nextInt(fruitsName.length)];
    }

    public String toString() {
        return "[money=" + money + ", fruits=" + fruits + "]";

    }
}
