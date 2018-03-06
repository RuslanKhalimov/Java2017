package ru.ifmo.rain.khalimov.expression.generic.operations;

import ru.ifmo.rain.khalimov.expression.exceptions.DBZException;

public class UIntOperations implements Operations<Integer> {
    public Integer add(Integer a, Integer b) throws Exception {
        return a + b;
    }

    public Integer subtract(Integer a, Integer b) throws Exception {
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) throws Exception {
        return a * b;
    }

    public Integer divide(Integer a, Integer b) throws Exception {
        if (b == 0) {
            throw new DBZException();
        }
        return a / b;
    }

    public Integer parseT(String s) throws Exception {
        return Integer.parseInt(s);
    }

    public Integer negate(Integer a) throws Exception {
        return -a;
    }

    public Integer mod(Integer a, Integer b) throws Exception {
        if (b == 0) {
            throw new DBZException();
        }
        return a % b;
    }

    public Integer abs(Integer a) throws Exception {
        return a < 0 ? negate(a) : a;
    }
}
