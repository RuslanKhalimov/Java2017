package ru.ifmo.rain.khalimov.expression.operations;

import ru.ifmo.rain.khalimov.expression.generic.operations.Operations;

public class Abs<T> implements TripleExpression<T> {
    final private TripleExpression<T> expr;
    final private Operations<T> op;

    public Abs(TripleExpression<T> expr, Operations<T> op) {
        this.expr = expr;
        this.op = op;
    }

    public T evaluate(T x, T y, T z) throws Exception {
        return op.abs(expr.evaluate(x, y, z));
    }
}
