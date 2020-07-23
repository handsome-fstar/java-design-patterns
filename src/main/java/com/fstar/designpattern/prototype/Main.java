package com.fstar.designpattern.prototype;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
