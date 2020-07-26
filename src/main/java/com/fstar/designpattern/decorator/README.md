# 装饰器模式（Decorator）
装饰器模式允许向一个现有的对象添加新的功能，同时又不改变其结构。
## Example
显示一段字符串，对它进行层层包装。  
**Display**  
显示字符串的抽象类。
```java
public abstract class Display {

    public abstract int getColumns();

    public abstract int getRows();

    public abstract String getRowText(int row);

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
}
```
**Border**  
一个外边框的抽象类。
```java
public abstract class Border extends Display {
    protected Display display;

    protected Border(Display display) {
        this.display = display;
    }
}
```
**StringDisplay**
显示字符串具体的类。
```java
public class StringDisplay extends Display {
    private String text;

    public StringDisplay(String text) {
        this.text = text;
    }

    @Override
    public int getColumns() {
        return text.getBytes().length;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return text;
        } else {
            return null;
        }
    }
}
```
**SideBoarder**  
在字符串左右两边加上字符的装饰。
```java
public class SideBoarder extends Border {
    private char borderChar;

    public SideBoarder(Display display, char ch) {
        super(display);
        this.borderChar = ch;
    }

    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
```
**FullBorder**  
在字符串上下左右都加一圈装饰。
```java
public class FullBorder extends Border {
    public FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else if (row == display.getRows() + 1) {
            return "+" + makeLine('-', display.getColumns()) + "+";
        } else {
            return "|" + display.getRowText(row - 1) + "|";
        }
    }

    private String makeLine(char ch, int count) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}
```