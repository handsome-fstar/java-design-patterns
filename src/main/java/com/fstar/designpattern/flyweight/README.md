# 享元模式（Flyweight）
主要用于减少创建对象的数量，以减少内存占用和提高性能。
## Example
当系统中有大量重复的对象时，我们可以把这些对象抽取出来，用一个HashMap来存储，当需要用的时候，直接去拿，而不是去创建。  
下面这个由“.”和“#”组成的大型数字，我们用它来表示系统中特别占用内存的对象，从0到9都有，比如我们需要打印一串数字，那么重复的数字在内存中只加载一次。   
```java
....######...... ......##........
..##......##.... ..######........
..##......##.... ......##........
..##......##.... ......##........
..##......##.... ......##........
..##......##.... ......##........
....######...... ..##########....
................ ................ 后面省略...
```
**BigChar**  
这个类就是根据需要的数字，去读取存在txt中的大型数字。在项目目录中，由11个txt文件，里面保存了0-9的数字还有“-”。
```java
public class BigChar {
    // 字符名字
    private char charname;
    // 大型字符对应的字符串(由'#' '.' '\n'组成)
    private String fontdata;
    // 构造函数
    public BigChar(char charname) {
        this.charname = charname;
        try {
            BufferedReader reader = new BufferedReader(
                new FileReader(System.getProperty("user.dir")
                        + "\\src\\main\\java\\com\\fstar\\designpattern\\flyweight\\big" + charname + ".txt")
            );
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontdata = buf.toString();
        } catch (IOException e) {
            e.printStackTrace();
            this.fontdata = charname + "?";
        }
    }
    // 显示大型字符
    public void print() {
        System.out.print(fontdata);
    }
}
```
**BigCharFactory**  
这个是生产大型数字的工厂，这个工厂的创建采用了单例模式。这个工厂维护了一个HashMap，每当生产出一个大型数字的时候，就放进HashMap里进行存储，之后需要大型数字的时候，都会来检查这个HashMap里面有没有，如果由就直接返回，没有就加载进来。这样就可以达到同样的对象节约内存占用的目的。
```java
public class BigCharFactory {
    // 管理已经生成的BigChar的实例
    private HashMap pool = new HashMap();
    // Singleton模式
    private static BigCharFactory singleton = new BigCharFactory();
    // 构造函数
    private BigCharFactory() {
    }
    // 获取唯一的实例
    public static BigCharFactory getInstance() {
        return singleton;
    }
    // 生成（共享）BigChar类的实例
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = (BigChar)pool.get("" + charname);
        if (bc == null) {
            bc = new BigChar(charname); // 生成BigChar的实例
            pool.put("" + charname, bc);
        }
        return bc;
    }
}
```
**BigString**  
这个类用来接收数字和显示数字
```java
public class BigString {
    // “大型字符”的数组
    private BigChar[] bigchars;
    // 构造函数
    public BigString(String string) {
        bigchars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }
    // 显示
    public void print() {
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i].print();
        }
    }
}
```
**Main**
```java
public static void main(String[] args) {
    BigString bs = new BigString("0871-8099999");
    bs.print();
}
```