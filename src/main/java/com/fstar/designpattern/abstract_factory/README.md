# 抽象工厂模式（Abstract Factory）
抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，无须指定它们具体的类。  
## Example
抽象工厂模式的类比较多，主要分为4类：  
- AbstractFactory：抽象工厂角色，由“技术工厂”TechFactory类扮演。
- ConcreteFactory：具体工厂角色，由“苹果工厂”AppleTechFactory和“小米工厂”MiTechFactory来扮演。
- AbstractProduce：抽象产品角色，有耳机、手机、笔记本电脑。
- ConcreteProduce：具体产品角色，有苹果的手机、苹果的笔记本、小米的手机、小米的笔记本等。
**TechFactory**  
工厂的抽象，工厂有卖手机、卖笔记本、卖耳机的方法。
```java
public abstract class TechFactory {
    public abstract Phone sellPhone();
    public abstract Laptop sellLaptop();
    public abstract Earphone sellEarPhone();
}
```
**AppleTechFactory**  
苹果工厂的抽象
```java
public class AppleTechFactory extends TechFactory {
    @Override
    public Phone sellPhone() {
        return new ApplePhone();
    }

    @Override
    public Laptop sellLaptop() {
        return new AppleLaptop();
    }

    @Override
    public Earphone sellEarPhone() {
        return new AppleEarphone();
    }
}
```
**AppleLaptop**
苹果的笔记本
```java
public class AppleLaptop extends Laptop {
    @Override
    public void describe() {
        System.out.println("Mac book");
    }
}
```