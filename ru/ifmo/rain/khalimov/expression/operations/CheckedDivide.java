package ru.ifmo.rain.khalimov.expression.operations;

import ru.ifmo.rain.khalimov.expression.generic.operations.Operations;

public class CheckedDivide<T> extends AbstractClass<T> {
    public CheckedDivide(TripleExpression<T> a, TripleExpression<T> b, Operations<T> op) {
        super(a, b, op);
    }

    protected T binOperation(T first, T second) throws Exception {
        return op.divide(first, second);
    }
}
