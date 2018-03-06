package ru.ifmo.rain.khalimov.expression.generic.operations;

public interface Operations<T> {
    T add(T a, T b) throws Exception;

    T subtract(T a, T b) throws Exception;

    T multiply(T a, T b) throws Exception;

    T divide(T a, T b) throws Exception;

    T parseT(String s) throws Exception;

    T negate(T a) throws Exception;

    T mod(T a, T b) throws Exception;

    T abs(T a) throws Exception;
}
