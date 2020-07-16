# 代理模式（Proxy）
代理模式允许我们创建一个中间人对象去控制其他对象。
##Example
在这个例子里，我们有一个打印机和一个代理打印机，打印机和代理打印机都可以进行打印操作。他们都实现了一个共同的Printable接口。  
**Printable**  
```java
public interface Printable {
    public abstract void print(String string);
}
```
**Printer**  
Printer类的构造器会调用heavyJob()方法，heavyJob()延迟5秒钟用来模拟这个类启动非常复杂。
```java
public class Printer implements Printable {
    public Printer() {
        heavyJob("正在生成Printer的实例");
    }

    public void print(String string) {
        System.out.println(string);
    }

    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.print(".");
        }
        System.out.println("ok");
    }
}
```
**PrinterProxy**  
在调用PrinterProxy类的print()方法去打印的时候，会先调用realize()方法去生成Print的实例，这样就实现了代理功能，使用代理打印机去操作真实的打印机。
```java
public class PrinterProxy implements Printable {
    Printer realPrinter;
    public PrinterProxy() {
    }

    public void print(String string) {
        realize();
        realPrinter.print(string);
    }

    private synchronized void realize() {
        if (realPrinter == null) {
            realPrinter = new Printer();
        }
    }
}
```
**Main**  
当第一次打印的时候，需要一个耗时的加载，但是第二次打印的时候就可以直接打印，这也是代理模式的另一个优点，当需要的时候才去加载（懒加载），之后就不需要再加载就直接打印了。
```java
public class Main {
    public static void main(String[] args) {
        // 使用代理打印机去打印。
        Printable p1 = new PrinterProxy();
        p1.print("Hello world.");
        p1.print("Hello world.");
    }
}
```