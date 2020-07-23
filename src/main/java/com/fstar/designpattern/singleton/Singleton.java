package com.fstar.designpattern.singleton;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 */
public class Singleton {
    /**
     * volatile用于防止指令重排
     * 在创建对象时，分三步，1：分配内存空间，2：初始化对象，3：将对象实例指向分配的内存。
     * 由于计算机底层具有指令重排特性，可能创建过程会变成1、3、2
     * 若A线程执行完1、3，没有CPU时间了，那么B线程就会获取到一个未初始化的对象
     */
    private volatile static Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
