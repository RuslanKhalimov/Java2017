package ru.ifmo.rain.khalimov.expression.operations;

public class Const<T> implements TripleExpression<T> {
    protected final T result;

    public Const(T a) {
        result = a;
    }

    public T evaluate(T x, T y, T z) {
        return result;
    }
}
