package ru.ifmo.rain.khalimov.expression.operations;

import ru.ifmo.rain.khalimov.expression.generic.operations.Operations;

public class CheckedNegate<T> implements TripleExpression<T>{
    final TripleExpression<T> var;
    private Operations<T> op;

    public CheckedNegate(TripleExpression<T> x, Operations<T> op) {
        var = x;
        this.op = op;
    }

    public T evaluate(T x, T y, T z) throws Exception {
        return op.negate(var.evaluate(x, y, z));
    }
}
