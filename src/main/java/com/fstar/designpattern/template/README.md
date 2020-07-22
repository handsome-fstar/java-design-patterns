# 模板模式（Template）
由一个抽象类定义一些固定的“模板”，它的子类可以按需要重写方法实现，调用时会按模板进行渲染。
## Example
**AbstractDisplay**  
这里定义了一个模板，也是一个抽象类。
```java
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // 模板
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
```
**CharDisplay**  
模板的实现。
```java
public class CharDisplay extends AbstractDisplay {
    private char ch;

    public CharDisplay(char ch) {
        this.ch = ch;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(this.ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
```
**StringDisplay**  
模板的实现。
```java
public class StringDisplay extends AbstractDisplay {
    private int width;
    private String string;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.length();
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
```
**Main**  
```java
public class Main {
    public static void main(String[] args) {
        AbstractDisplay display1 = new CharDisplay('A');
        display1.display();
        AbstractDisplay display2 = new StringDisplay(" Hello world ");
        display2.display();
    }
}
```