# 状态模式（State）
在没有学习状态模式之前，要表示一个类的状态，我通常会在这个类里加入一个state字段，用数字或字符串来区别状态，例如1表示已下单、2表示已发货、3表示已收货。在这样的情况下，如果状态的改变需要触发其他方法时，就需要写很多if/else去判断现在的状态，状态越多越繁琐。  
有了状态模式以后，把每一个状态以一个单独的类来表示，不同的状态负责触发不同的行为，而且在添加新状态的时候也很方便，无需修改原来的逻辑。  
## Example
假设我们网购下单，有一个已下单的状态，当包裹发货了以后有一个已发货的状态，收货以后有一个已收货的状态。  
**Package**  
这就是我们的包裹类，一开始的状态默认是已下单OrderedState。
```java
public class Package {
    private State state = new OrderedState();

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}
```
**OrderedState**  
已下单的状态类
```java
public class OrderedState implements State {
    @Override
    public void next(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void prev(Package pkg) {
        System.out.println("已经是最初的状态了。");
    }

    @Override
    public void printStatus() {
        System.out.println("已下单，还没有交付物流。");
    }
}
```
**DeliveredState**  
已发货的状态类
```java
public class DeliveredState implements State {
    @Override
    public void next(Package pkg) {
        pkg.setState(new ReceivedState());
    }

    @Override
    public void prev(Package pkg) {
        pkg.setState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("物流已发出，还没有签收！");
    }
}
```  
**ReceivedState**  
已签收的状态类
```java
public class ReceivedState implements State {
    @Override
    public void next(Package pkg) {
        System.out.println("包裹已经签收，没有之后的状态拉！");
    }

    @Override
    public void prev(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("包裹已签收。");
    }

    @Override
    public String toString() {
        return "ReceivedState{}";
    }
}
```
**Main**
```java
public static void main(String[] args) {
    Package pkg = new Package();
    pkg.printStatus();

    pkg.nextState();
    pkg.printStatus();

    pkg.nextState();
    pkg.printStatus();

    pkg.nextState();
    pkg.printStatus();
}
```
**输出**
```java
已下单，还没有交付物流。
物流已发出，还没有签收！
包裹已签收。
包裹已经签收，没有之后的状态拉！
包裹已签收。
```