# 迭代器模式（Iterator）
迭代器模式用于在数据集合中按照顺序遍历集合。
## Example
该例子是遍历书架中的书。  
**Aggregate**  
在Aggregate接口中声明的方法只有一个iterator()方法。该方法会生成一个用于遍历
集合的迭代器。
```java
public interface Aggregate {
    public abstract Iterator iterator();
}
```
**Iterator**  
迭代器接口
```java
public interface Iterator {
    public abstract boolean hasNext();

    public abstract Object next();
}
```
**Book**  
书本类
```java
public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```
**BookShelf**  
书架类，实现了Aggregate接口，这样书架就有了一个返回迭代器的方法。
```java
public class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
```
**BookShelfIterator**  
书架迭代器实现了迭代器方法，需要实现hasNext()方法和next()方法。
```java
public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
```
**Main**  
```java
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
```