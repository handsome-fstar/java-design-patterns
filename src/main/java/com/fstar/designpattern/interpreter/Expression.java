package com.fstar.designpattern.interpreter;

import java.util.List;

interface Expression {
    List<String> interpret(Context ctx);
}
