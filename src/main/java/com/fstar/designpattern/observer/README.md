# 观察者模式（Observer）
在观察者模式中有两个重要的角色，一个是**可被观察对象（observable ）**和**观察者（observers）**，当observable对象发生改变的时候，会通知所有的观察者。
## Example
### 基于Observer的实现例子
**Observer接口**  
这是一个“观察者”的接口，具体的观察者会实现这个接口。  
```java
public interface Observer {
    void update(NumberGenerator numberGenerator);
}
```
**NumberGenerator抽象类**  
NumberGenerator是“被观察类”的抽象，具体的被观察类，需要继承这个抽象类。  
observers字段中保存各个观察者，本例子中保存DigitObserver和GraphObserver。  
addObserver用于注册观察者，removeObserver用于删除观察者。  
notifyObservers会向所有的观察者发出通知，告诉他们我的值修改了。
```java
public abstract class NumberGenerator {
    private ArrayList observers = new ArrayList();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        Iterator iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer observer = (Observer) iterator.next();
            observer.update(this);
        }
    }

    public abstract int getNumber();

    public abstract void execute();
}
```
**RandomNumberGenerator**  
RandomNumberGenerator类是NumberGenerator抽象类的子类，主要就是生成随机数。  
当execute()被调用的时候，会循环生成10次随机数，每次生成的随机数都保存起来并通知观察者们。  
```java
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random();

    private int number;

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 10; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
```
**DigitObserver**  
DigitObserver类实现了Observer接口，他以数字的形式展示观察到的值。为了方便看清打印，使用Thread.sleep来降低程序运行速度。
```java
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("DigitObserver:" + numberGenerator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
**GraphObserver**  
GraphObserver类实现了Observer接口，他观察到的数字是多少，就打印多少个*。
```java
public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.print("GraphObserver:");
        int count = numberGenerator.getNumber();
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println("");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```
**Main**  
```java
NumberGenerator generator = new RandomNumberGenerator();
Observer observer1 = new DigitObserver();
Observer observer2 = new GraphObserver();
generator.addObserver(observer1);
generator.addObserver(observer2);
generator.execute();
```
### 基于PropertyChangeSupport的实现例子
在基于PropertyChangeSupport的实现中，Observable需要把PropertyChangeSupport作为自己的成员变量。在这个例子中PropertyChangeListener就充当了观察者的角色了。    
**PCLNewsObservable**    
```java
public class PCLNewsObservable {
    private String news;

    private PropertyChangeSupport support;

    public PCLNewsObservable() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void changeNews(String news) {
        support.firePropertyChange("news", this.news, news);
        this.news = news;
    }
}
```
**PCLNewsObserver**  
观察者对象需要实现 PropertyChangeListener 接口。
```java
public class PCLNewsObserver implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("数据改变了：" + evt.getNewValue().toString());
    }
}
```
**Main**  
```java
PCLNewsObservable observable = new PCLNewsObservable();
PCLNewsObserver observer = new PCLNewsObserver();
observable.addPropertyChangeListener(observer);
observable.changeNews("new 1");
observable.changeNews("new 2");
```