# 桥接模式（Bridge）
桥接模式是将抽象部分与它的实现部分分离，使它们都可以独立地变化。

## Example
家用电器有空调、洗衣机、热水器等，其中又有格力、海尔、美的等品牌。如果用类来表示格力的空调，或者格力的洗衣机，甚至更多的品牌，更多的电器，都创建一个类来表示会很复杂。现在可以将品牌和电器进行抽象，将电器和品牌“桥接”起来。  

**ElectricAppliance**  
定义家用电器类的接口，提供基本操作，其实现交给子类实现。
```java
public interface ElectricAppliance {
    String description();
}
```
**AirConditioner**  
空调类，实现ElectricAppliance，在程序运行时，子类对象将替换其父类对象，提供给Abstraction具体的业务操作方法。
```java
public class AirConditioner implements ElectricAppliance {
    private final String name = "空调";
    @Override
    public String description() {
        return name;
    }
}
```
**Brand**  
品牌类，抽象的定义，并保存一个家用电器类的引用，将品牌和电器桥接起来。
```java
public abstract class Brand {
    protected ElectricAppliance electricAppliance;

    public Brand(ElectricAppliance electricAppliance) {
        this.electricAppliance = electricAppliance;
    }

    public abstract String description();
}
```
**Gree**  
具体品牌的类。
```java
public class Gree extends Brand {
    private final String name = "格力";

    public Gree(ElectricAppliance electricAppliance) {
        super(electricAppliance);
    }

    @Override
    public String description() {
        return name + electricAppliance.description();
    }

}
```
**Main**  
```java
Brand gree = new Gree(new AirConditioner());
System.out.println(gree2.description());  //格力空调
```