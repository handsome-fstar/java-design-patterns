# 命令模式（Command）
命令模式将执行需要的操作(命令)所需的所有数据封装在一个对象中，包括要调用的方法、方法的参数和方法所属的对象。  
命令模式涉及4个角色，分别是：Command、Invoker、Receiver、Client。
## Example
这个例子展示了一个文本文件的操作，TextFileOperation、OpenTextFileOperation、CloseTextFileOperation属于Command角色，其中TextFileOperation是其他两个的抽象接口。
```java
@FunctionalInterface
public interface TextFileOperation {
    String execute();
}
```  
一个命令（Command），就是一个对象，他包含了执行所需要的参数方法等信息。
```java
public class OpenTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    public OpenTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.open();
    }
}
```
```java
public class CloseTextFileOperation implements TextFileOperation {
    private TextFile textFile;

    public CloseTextFileOperation(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String execute() {
        return textFile.close();
    }
}
```
**TextFile**  
TextFile在这里扮演receiver角色，当Command调用execute()的时候，实际上调用的是这个类。
```java
public class TextFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public String open() {
        System.out.println("打开" + name);
        return "打开" + name;
    }

    public String close() {
        System.out.println("关闭" + name);
        return "关闭" + name;
    }
}
```
**TextFileOperationExecutor**  
TextFileOperationExecutor在这里扮演Invoker角色，Invoker知道如何执行一个给定的命令，但不知道命令是如何实现的。它只知道命令的接口。
```java
public class TextFileOperationExecutor {
    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }
}
```
**Main**  
Main类作为Client，他控制着命令（Command）去执行操作。
```java
public class Main {
    public static void main(String[] args) {
        TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
        textFileOperationExecutor.executeOperation(new OpenTextFileOperation(new TextFile("file.txt")));
        textFileOperationExecutor.executeOperation(new CloseTextFileOperation(new TextFile("file2.txt")));

        // Java8 Lambda
        textFileOperationExecutor.executeOperation(() -> new TextFile("file3.txt").open());

        // Java8 方法引用
        textFileOperationExecutor.executeOperation(new TextFile("file4.txt")::close);
    }
}
```