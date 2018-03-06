package ru.ifmo.rain.khalimov.expression.generic.operations;

import ru.ifmo.rain.khalimov.expression.exceptions.DBZException;
import ru.ifmo.rain.khalimov.expression.exceptions.OverflowException;

public class IntOperations implements Operations<Integer> {
    public Integer add(Integer a, Integer b) throws Exception {
        if (b > 0 && a + b < a || b < 0 && a + b > a) {
            throw new OverflowException();
        }
        return a + b;
    }

    public Integer subtract(Integer a, Integer b) throws Exception {
        if (b > 0 && a - b > a || b < 0 && a - b < a) {
            throw new OverflowException();
        }
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) throws Exception {
        if (a > b) {
            return multiply(b, a);
        }
        if (a < 0) {
            if (b < 0 && a < Integer.MAX_VALUE / b) {
                throw new OverflowException();
            }
            if (b > 0 && Integer.MIN_VALUE / b > a) {
                throw new OverflowException();
            }
        } else if (a > 0 && a > Integer.MAX_VALUE / b) {
            throw new OverflowException();
        }
        return a * b;
    }

    public Integer divide(Integer a, Integer b) throws Exception {
        if (b == 0) {
            throw new DBZException();
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new OverflowException();
        }
        return a / b;
    }

    public Integer parseT(String s) throws Exception {
        return Integer.parseInt(s);
    }

    public Integer negate(Integer a) throws Exception {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return -a;
    }

    public Integer mod(Integer a, Integer b) throws Exception {
        if (b == 0) {
            throw new DBZException();
        }
        return a % b;
    }

    public Integer abs(Integer a) throws Exception {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException();
        }
        return a < 0 ? negate(a) : a;
    }
}
