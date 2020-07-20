package com.fstar.designpattern.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("深入理解Java虚拟机"));
        bookShelf.appendBook(new Book("图解设计模式"));
        bookShelf.appendBook(new Book("并发编程的艺术"));
        bookShelf.appendBook(new Book("Think in Java"));
        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}
