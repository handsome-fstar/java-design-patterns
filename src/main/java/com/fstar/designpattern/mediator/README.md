# 中介者模式（Mediator）
中介者模式的目的就是降低各个类之间复杂的依赖性和耦合性，通过建立一个中介，让中介来负责对象之间的交互。
## Example
假设我们现在有一个简单的冷却系统，按钮按下就联通电源，联通电源后打开风扇。这时“按钮类”就需要依赖“电源类”，“电源类”就需要依赖“风扇类”。

为了解耦，我们创建一个中介Mediator来协调各个类，达到解耦的目的。

**按下开关后会去调用Monitor的press()**
```java
public class Button extends Colleague {
    private Mediator mediator;
    
    // 省略...

    public void press() {
        System.out.println("按了一下开关！");
        this.mediator.press();
    }
}
```

**Mediator的press()方法会去打开或关闭风扇**
```java
public class Mediator {
    // 省略...
    public void press() {
        if (fan.isOn()) {
            fan.turnOff();
        } else {
            fan.turnOn();
        }
    }
    // 省略...
}
```
**风扇在开启前会调用Monitor，让Monitor去打开电源**  
**风扇在关闭后会调用Monitor，让Monitor去关闭电源**
```java
public class Fan extends Colleague {

    // 省略...

    public void turnOn() {
        this.mediator.start();
        isOn = true;
        System.out.println("风扇打开了！");
    }

    public void turnOff() {
        isOn = false;
        this.mediator.stop();
        System.out.println("风扇关闭了！");
    }
}
```
**Monitor的开电源和关电源方法**
```java
public class Mediator {
    // 省略...
    public void start() {
        powerSupplier.turnOn();
    }

    public void stop() {
        powerSupplier.turnOff();
    }
    // 省略...
}
```
**电源类通电和断电的方法**
```java
public class PowerSupplier extends Colleague {

    // 省略...

    public void turnOn() {
        System.out.println("通电！");
    }

    public void turnOff() {
        System.out.println("断电！");
    }
}
```

现在我们就实现了中介者模式的实现，按钮、风扇、电源之间都不相互通讯，他们各自之间只关联Monitor，如果未来我们需要加入一个备用电源，我们只需要修改Monitor的逻辑，并不需要修改风扇和按钮。