package com.fstar.designpattern.interpreter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Context ctx = new Context();

        Expression query = new Select("name", new From("people"));
        List<String> result = query.interpret(ctx);
        System.out.println(result);

        Expression query2 = new Select("*", new From("people"));
        List<String> result2 = query2.interpret(ctx);
        System.out.println(result2);

        Expression query3 = new Select("name", new From("people", new Where(name -> name.toLowerCase().startsWith("d"))));
        List<String> result3 = query3.interpret(ctx);
        System.out.println(result3);
    }
}
