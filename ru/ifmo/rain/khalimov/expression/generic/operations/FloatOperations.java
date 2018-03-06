package ru.ifmo.rain.khalimov.expression.generic.operations;

public class FloatOperations implements Operations<Float> {
    public Float add(Float a, Float b) throws Exception {
        return a + b;
    }

    public Float subtract(Float a, Float b) throws Exception {
        return a - b;
    }

    public Float multiply(Float a, Float b) throws Exception {
        return a * b;
    }

    public Float divide(Float a, Float b) throws Exception {
        return a / b;
    }

    public Float parseT(String s) throws Exception {
        return Float.parseFloat(s);
    }

    public Float negate(Float a) throws Exception {
        return -a;
    }

    public Float mod(Float a, Float b) throws Exception {
        return a % b;
    }

    public Float abs(Float a) throws Exception {
        return a < 0 ? negate(a) : a;
    }
}
