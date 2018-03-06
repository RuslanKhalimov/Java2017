package ru.ifmo.rain.khalimov.expression.generic.operations;

import ru.ifmo.rain.khalimov.expression.exceptions.DBZException;

public class ByteOperations implements Operations<Byte> {
    public Byte add(Byte a, Byte b) throws Exception {
        return (byte) (a + b);
    }

    public Byte subtract(Byte a, Byte b) throws Exception {
        return (byte) (a - b);
    }

    public Byte multiply(Byte a, Byte b) throws Exception {
        return (byte) (a * b);
    }

    public Byte divide(Byte a, Byte b) throws Exception {
        if (b == 0) {
            throw new DBZException();
        }
        return (byte) (a / b);
    }

    public Byte parseT(String s) throws Exception {
        return Byte.parseByte(s);
    }

    public Byte negate(Byte a) throws Exception {
        return (byte) -a;
    }

    public Byte mod(Byte a, Byte b) throws Exception {
        if (b == 0) {
            throw new DBZException();
        }
        return (byte) (a % b);
    }

    public Byte abs(Byte a) throws Exception {
        return a < 0 ? negate(a) : a;
    }
}
