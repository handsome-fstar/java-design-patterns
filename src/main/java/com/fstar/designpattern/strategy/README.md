# 策略模式（Strategy）
本质上，策略模式允许我们在运行时去改变一个类的算法。
## Example
旅行有不同的策略，比如坐飞机和坐火车。  
**TravelStrategy**  
定义一个旅游的策略。
```java
public interface TravelStrategy {
    public abstract void travelStrategy();
}
```
**PlaneStrategy**  
乘飞机的策略。
```java
public class PlaneStrategy implements TravelStrategy {
    @Override
    public void travelStrategy() {
        System.out.println("travel by plane");
    }
}
```
**Traveler**  
旅行者，保存一种策略，和执行一种策略。
```java
public class Traveler {
    private TravelStrategy travelStrategy;

    public Traveler(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void travel() {
        this.travelStrategy.travelStrategy();
    }
}
```
**Main**
```java
public class Main {
    public static void main(String[] args) {
        Traveler traveler1 = new Traveler(new TrainStrategy());
        traveler1.travel();
        Traveler traveler2 = new Traveler(new PlaneStrategy());
        traveler2.travel();
    }
}
```