# 原型模式（Prototype）
原型模式通常是当我们已经有了一个类的实例（原型），然后我们通过拷贝去创建一个新的类。  
拷贝又分**深拷贝**和**浅拷贝**，浅拷贝只是将原来对象的引用地址拷贝到新对象，新旧对象引用的是同一块内存空间。通常当对象里的值是固定的、不会改变的时候用使用浅拷贝。深拷贝是将这个对象里的值之一复制，开辟一块新的内存空间去创建一个类。通常当对象里的值不固定的时候，会使用深拷贝。
## Example
在一些游戏里，会把树或者建筑物作为背景，当需要渲染多颗树的时候，不需要直接去创建，可以直接复制原来的树，去更新位置和改变颜色就可以了。这个例子将采用深拷贝的方式。  
**Tree**
树的抽象类，子类需要自己实现拷贝的方法。
```java
public abstract class Tree {
    private double mass;
    private double height;
    private Position position;

    public Tree(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }

    public abstract Tree copy();

    // 省略 get set
}
```
**PineTree**  
松树，实现了父类的拷贝方法。
```java
public class PineTree extends Tree {
    private String type;

    public PineTree(double mass, double height) {
        super(mass, height);
        this.type = "Pine";
    }

    public String getType() {
        return type;
    }

    @Override
    public Tree copy() {
        PineTree pineTreeClone = new PineTree(this.getMass(), this.getHeight());
        pineTreeClone.setPosition(this.getPosition());
        return pineTreeClone;
    }
}
```
**PlasticTree**  
塑料树，实现了父类的拷贝方法。
```java
public class PlasticTree extends Tree {
    private String name;

    public PlasticTree(double mass, double height) {
        super(mass, height);
        this.name = "PlasticTree";
    }

    public String getName() {
        return name;
    }

    @Override
    public Tree copy() {
        PlasticTree plasticTreeClone = new PlasticTree(this.getMass(), this.getHeight());
        plasticTreeClone.setPosition(this.getPosition());
        return plasticTreeClone;
    }
}
```
**Main**
```java
public class Main {
    public static void main(String[] args) {
        // 塑料树
        PlasticTree plasticTree = new PlasticTree(100, 200);
        // 这是塑料树的位置
        plasticTree.setPosition(new Position(0, 0));
        // 拷贝塑料树
        PlasticTree anotherPlasticTree = (PlasticTree) plasticTree.copy();
        // 设置拷贝塑料数的位置
        anotherPlasticTree.setPosition(new Position(1, 1));

        // 拷贝数组里的树
        PineTree pineTree = new PineTree(150, 169);
        List<Tree> trees = Arrays.asList(plasticTree, pineTree);
        List<Tree> treeClones = trees.stream().map(Tree::copy).collect(toList());
    }
}
```