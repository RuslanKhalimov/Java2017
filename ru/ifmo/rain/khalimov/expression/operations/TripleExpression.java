package ru.ifmo.rain.khalimov.expression.operations;

public interface TripleExpression<T> {
    T evaluate(T x, T y, T z) throws Exception;
}
