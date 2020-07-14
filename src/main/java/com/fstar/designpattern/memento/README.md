# 备忘录模式（Memento）
备忘录模式为程序提供了可撤销的解决方案。我们可以把一个对象的状态保存起来，在需要恢复的时候可以把他恢复出来。  
## Example
这是一个收集水果和获取金钱的投骰子游戏，游戏规则很简单，当骰子为1的时候，金钱增加；当骰子为2的时候，金钱减少；当骰子为6的时候，玩家获得水果。如果玩家的钱得的比较多，那么就存档，如果玩家钱输的比较多，那么就去读取之前的存档。  
**Memento类**  
这个类就是玩家存档的类，保存了现在的金钱和水果。
```java
public class Memento {
    int money;                          // 所持金钱
    ArrayList fruits;                   // 获得的水果

    Memento(int money) {                // 构造函数 （wide interface）
        this.money = money;
        this.fruits = new ArrayList();
    }

    public int getMoney() {             // 获取当前所持金钱（narrow interface）
        return money;
    }

    void addFruit(String fruit) {       // 添加水果 （wide interface）
        fruits.add(fruit);
    }

    List getFruits() {                  // 获取当前所持有水果 （wide interface）
        return (List) fruits.clone();
    }

}
```
**Gamer类**  
玩家类也保存金钱和水果，并且提供了createMemento方法用来存档，restoreMemento用来撤销。
```java
public class Gamer {
    private int money;                              // 所持金钱
    private List fruits = new ArrayList<>();        // 获得的水果
    private Random random = new Random();           // 随机数生成器
    private static String[] fruitsName = {          // 表示水果种类的数组
            "苹果", "葡萄", "香蕉", "橘子"
    };
    
    // 省略...

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

    // 省略...
}

```
**Main**  
金币多的时候就存档，金币少了就反悔撤销，哈哈哈。
```java
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