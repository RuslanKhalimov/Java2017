package ru.ifmo.rain.khalimov.expression.generic;

import ru.ifmo.rain.khalimov.expression.generic.operations.*;
import ru.ifmo.rain.khalimov.expression.operations.TripleExpression;
import ru.ifmo.rain.khalimov.expression.parser.ExpressionParser;

public class GenericTabulator implements Tabulator {
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        Operations<?> operation;

        switch (mode) {
            case "i":
                operation = new IntOperations();
                break;
            case "bi":
                operation = new BigIntegerOperations();
                break;
            case "d":
                operation = new DoubleOperations();
                break;
            case "f":
                operation = new FloatOperations();
                break;
            case "u":
                operation = new UIntOperations();
                break;
            case "b":
                operation = new ByteOperations();
                break;
            default:
                throw new Exception("Invalid mode " + mode);
        }

        return tabulate(expression, operation, x1, x2, y1, y2, z1, z2);
    }

    private <T> Object[][][] tabulate(String expression, Operations<T> operation, int x1, int x2, int y1, int y2, int z1, int z2) throws Exception {
        Object[][][] result = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        TripleExpression<T> parsedExpression = new ExpressionParser<>(operation).parse(expression);

        for (Integer i = x1; i <= x2; i++) {
            for (Integer j = y1; j <= y2; j++) {
                for (Integer k = z1; k <= z2; k++) {
                    try {
                        result[i - x1][j - y1][k - z1] = parsedExpression.evaluate(
                                operation.parseT(i.toString()), operation.parseT(j.toString()), operation.parseT(k.toString())
                        );
                    } catch (Exception e) {
                        result[i - x1][j - y1][k - z1] = null;
                    }
                }
            }
        }

        return result;
    }
}
