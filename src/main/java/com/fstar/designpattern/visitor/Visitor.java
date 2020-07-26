package com.fstar.designpattern.visitor;

public abstract class Visitor {

    public abstract void visit(File file);

    public abstract void visit(Directory directory);

}
