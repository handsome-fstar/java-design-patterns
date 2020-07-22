# 适配器模式（Adapter）
适配器模式是两个不兼容的接口之间的桥梁。
## Example
这个例子以中国220v交流电和日本110v交流电作为例子，用适配器模式，将电压转换为5v给手机充电。  
**AC**  
交流电的抽象类
```java
public interface AC {
    int outputAC();
}
```
**AC110**  
110v交流电
```java
public class AC110 implements AC {
    private final int output = 110;
    @Override
    public int outputAC() {
        return this.output;
    }
}
```
**AC220**  
220v交流电
```java
public class AC220 implements AC {
    private final int output = 220;
    @Override
    public int outputAC() {
        return this.output;
    }
}
```
**DC5Adapter**  
5v适配器的抽象类，outputDC5V(AC ac)方法接受高压电，并且由不同的子类来实现转换。
```java
public interface DC5Adapter {
    boolean support(AC ac);
    int outputDC5V(AC ac);
}
```
**ChinaPowerAdapter**
中国的手机适配器
```java
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
```
**JapanPowerAdapter**  
日本的手机适配器
```java
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
```
**Main**
```java
// 省略...
public static void main(String[] args) {
    Main main = new Main();
    AC chinaAC = new AC220();
    main.getDC5Adapter(chinaAC).outputDC5V(chinaAC);

    AC japanAC = new AC110();
    main.getDC5Adapter(japanAC).outputDC5V(japanAC);
}
```