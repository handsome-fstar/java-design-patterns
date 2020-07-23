# 模板方法模式（Factory Method）
模板方法定义一个创建对象的接口，但是类的实例化交给子类。
## Example
这个例子以一个制作身份证的工厂来演示模板方法模式。  
**Factory**  
工厂的抽象类，只定义创建产品的抽象，具体的创建由子类来实现。
```java
public abstract class Factory {
    public abstract Product createProduct(String owner);
}
```
**Product**  
产品的抽象，只包含一个使用的use()方法。
```java
public abstract class Product {
    public abstract void use();
}
```
**IDCardFactory**  
具体的工厂类，也就是创建对象的类。
```java
public class IDCardFactory extends Factory {
    @Override
    public Product createProduct(String owner) {
        return new IDCard(owner);
    }
}
```
**IDCard**
具体的产品类。
```java
public class IDCard extends Product {
    private String owner;

    // 这个构造器没有使用public，不写默认只有本包的类可以使用
    // 只允许IDCardFactory来创建这个对象，不允许其他包的来直接创建
    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡");
    }
}
```
**Main**
```java
public static void main(String[] args) {
    Factory factory = new IDCardFactory();
    Product mike = factory.createProduct("Mike");
    Product jimmy = factory.createProduct("Jimmy");
    mike.use();
    jimmy.use();
}
```
**输出**
```java
制作Mike的ID卡
制作Jimmy的ID卡
使用Mike的ID卡
使用Jimmy的ID卡
```