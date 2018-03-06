package ru.ifmo.rain.khalimov.expression.operations;

import ru.ifmo.rain.khalimov.expression.generic.operations.Operations;

public class Variable<T> implements TripleExpression<T> {
    final String var;
    Operations<T> op;

    public Variable(String x, Operations<T> op) {
        var = x;
        this.op = op;
    }

    public T evaluate(T x, T y, T z) {
        if (var.equals("x")) {
            return x;
        } else if (var.equals("y")) {
            return y;
        } else {
            return z;
        }
    }
}
