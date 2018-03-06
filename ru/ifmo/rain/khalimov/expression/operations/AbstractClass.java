package ru.ifmo.rain.khalimov.expression.operations;

import ru.ifmo.rain.khalimov.expression.generic.operations.Operations;

public abstract class AbstractClass<T> implements TripleExpression<T> {
    private TripleExpression<T> left, right;
    protected Operations<T> op;

    protected abstract T binOperation(T first, T second) throws Exception;

    AbstractClass(TripleExpression<T> a, TripleExpression<T> b, Operations<T> op) {
        left = a;
        right = b;
        this.op = op;
    }

    public T evaluate(T x, T y, T z) throws Exception {
        return binOperation(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }
}
