package ru.ifmo.rain.khalimov.expression.generic.operations;

public class DoubleOperations implements Operations<Double> {
    public Double add(Double a, Double b)  throws Exception{
        return a + b;
    }

    public Double subtract(Double a, Double b)  throws Exception{
        return a - b;
    }

    public Double multiply(Double a, Double b)  throws Exception{
        return a * b;
    }

    public Double divide(Double a, Double b)  throws Exception{
        return a / b;
    }

    public Double parseT(String s) throws Exception {
        return Double.parseDouble(s);
    }

    public Double negate(Double a) {
        return -a;
    }

    public Double mod(Double a, Double b) throws Exception {
        return a % b;
    }

    public Double abs(Double a) throws Exception {
        return a < 0 ? negate(a) : a;
    }
}
