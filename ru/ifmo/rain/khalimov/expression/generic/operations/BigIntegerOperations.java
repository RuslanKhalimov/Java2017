package ru.ifmo.rain.khalimov.expression.generic.operations;

import ru.ifmo.rain.khalimov.expression.exceptions.DBZException;

import java.math.BigInteger;

public class BigIntegerOperations implements Operations<BigInteger> {
    public BigInteger add(BigInteger a, BigInteger b) throws Exception {
        return a.add(b);
    }

    public BigInteger subtract(BigInteger a, BigInteger b) throws Exception {
        return a.subtract(b);
    }

    public BigInteger multiply(BigInteger a, BigInteger b) throws Exception {
        return a.multiply(b);
    }

    public BigInteger divide(BigInteger a, BigInteger b) throws Exception {
        if (b.compareTo(BigInteger.ZERO) == 0) {
            throw new DBZException();
        }
        return a.divide(b);
    }

    public BigInteger parseT(String s) {
        return new BigInteger(s);
    }

    public BigInteger negate(BigInteger a) {
        return a.negate();
    }

    public BigInteger mod(BigInteger a, BigInteger b) throws Exception {
        if (b.equals(BigInteger.ZERO)) {
            throw new DBZException();
        }
        return a.subtract(a.divide(b).multiply(b));
    }

    public BigInteger abs(BigInteger a) throws Exception {
        return a.compareTo(BigInteger.ZERO) < 0 ? negate(a) : a;
    }
}
