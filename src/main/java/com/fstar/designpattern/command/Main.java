package com.fstar.designpattern.command;

/**
 * Client
 */
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
