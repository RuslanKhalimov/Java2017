package ru.ifmo.rain.khalimov.expression.parser;

import ru.ifmo.rain.khalimov.expression.operations.TripleExpression;

public interface Parser<T> {
    TripleExpression<T> parse(String expression) throws Exception;
}
