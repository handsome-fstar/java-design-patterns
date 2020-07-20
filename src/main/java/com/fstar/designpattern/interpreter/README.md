# 解释器模式（Interpreter）
解释器模式需要给定一种语言（比如SQL语言，或者我们自己定义一套语言），然后定义该语言语法的一种“表达示”，并且提供一个解释器来解释我们定义的这种“表达示”，从而执行给定的这种语言。
## Example
为了展示解释器模式的效果，我们将构建一套语法，用面向对象的方式去创建一个类似SQL的简单语法。然后用解释器去解释这个语法，并且执行返回结果。  
首先我们将定义Select、From、Where的表达式。  
**表达式的接口，提供一个解释方法**
```java
interface Expression {
    List<String> interpret(Context ctx);
}
```
**Select的表达式**  
```java
public class Select implements Expression {
    private String column;
    private From from;

    Select(String column, From from) {
        this.column = column;
        this.from = from;
    }

    @Override
    public List<String> interpret(Context ctx) {
        ctx.setColumn(column);
        return from.interpret(ctx);
    }
}
```
**From的表达式**  
```java
public class From implements Expression {
    private String table;
    private Where where;

    From(String table) {
        this.table = table;
    }

    From(String table, Where where) {
        this.table = table;
        this.where = where;
    }

    @Override
    public List<String> interpret(Context ctx) {
        ctx.setTable(table);
        if (where == null) {
            return ctx.search();
        }
        return where.interpret(ctx);
    }
}
```
**Where的表达式**  
```java
public class Where implements Expression {
    private Predicate<String> filter;

    Where(Predicate<String> filter) {
        this.filter = filter;
    }

    @Override
    public List<String> interpret(Context ctx) {
        ctx.setFilter(filter);
        return ctx.search();
    }
}
```
**Context**  
Context类提供了一个简单的数据库。
```java
class Context {
    private static Map<String, List<Row>> tables = new HashMap<>();
 
    static {
        List<Row> list = new ArrayList<>();
        list.add(new Row("John", "Doe"));
        list.add(new Row("Jan", "Kowalski"));
        list.add(new Row("Dominic", "Doom"));
 
        tables.put("people", list);
    }
 
    private String table;
    private String column;
    private Predicate<String> whereFilter;
 
    // ... 
 
    List<String> search() {

        List<String> result = tables.entrySet()
          .stream()
          .filter(entry -> entry.getKey().equalsIgnoreCase(table))
          .flatMap(entry -> Stream.of(entry.getValue()))
          .flatMap(Collection::stream)
          .map(Row::toString)
          .flatMap(columnMapper)
          .filter(whereFilter)
          .collect(Collectors.toList());
 
        clear();
 
        return result;
    }
}
```