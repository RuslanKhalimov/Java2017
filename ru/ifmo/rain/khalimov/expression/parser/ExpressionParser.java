package ru.ifmo.rain.khalimov.expression.parser;

import ru.ifmo.rain.khalimov.expression.generic.operations.Operations;
import ru.ifmo.rain.khalimov.expression.operations.*;
import ru.ifmo.rain.khalimov.expression.exceptions.FormatException;

public class ExpressionParser<T> implements Parser<T> {
    private int i, balance;
    private String expression;
    private Operations<T> op;

    public ExpressionParser(Operations<T> op) {
        this.op = op;
    }

    public TripleExpression<T> parse(String expression) throws Exception {
        i = 0;
        balance = 0;
        this.expression = expression;
        return plusMinus();
    }

    private TripleExpression<T> plusMinus() throws Exception {
        TripleExpression<T> result = mulDiv();
        while (i < expression.length()) {
            if (expression.charAt(i) == '+') {
                i++;
                result = new CheckedAdd<>(result, mulDiv(), op);
            } else if (expression.charAt(i) == '-') {
                i++;
                result = new CheckedSubtract<>(result, mulDiv(), op);
            } else if (expression.charAt(i) == ')') {
                i++;
                balance--;
                if (balance == -1) {
                    throw new FormatException("No opening parenthesis");
                }
                return result;
            } else if (Character.isWhitespace(expression.charAt(i))) {
                i++;
            } else {
                throw new FormatException("Incorrect symbol");
            }
        }
        if (balance != 0) {
            throw new FormatException("No closing parenthesis");
        }
        return result;
    }

    private TripleExpression<T> mulDiv() throws Exception {
        TripleExpression<T> result = getNum();
        while (i < expression.length()) {
            if (expression.charAt(i) == '*') {
                i++;
                result = new CheckedMultiply<>(result, getNum(), op);
            } else if (expression.charAt(i) == '/') {
                i++;
                result = new CheckedDivide<>(result, getNum(), op);
            } else if (i + 3 <= expression.length() && expression.substring(i, i + 3).equals("mod")) {
                i += 3;
                return new Mod<>(result, getNum(), op);
            } else if (Character.isWhitespace(expression.charAt(i))) {
                i++;
            } else {
                return result;
            }
        }
        return result;
    }

    private TripleExpression<T> getNum() throws Exception {
        if (i == expression.length()) {
            throw new FormatException("Incorrect symbol");
        }
        if (expression.charAt(i) == '-') {
            i++;
            if (i == expression.length()) {
                throw new FormatException("Incorrect symbol");
            }
            return new CheckedNegate<>(getNum(), op);
        } else if (expression.charAt(i) == '(') {
            balance++;
            i++;
            return plusMinus();
        } else if (Character.isDigit(expression.charAt(i))) {
            int j = i;
            while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                i++;
            }
            return new Const<>(op.parseT(expression.substring(j, i)));
        } else if (expression.charAt(i) == 'x' || expression.charAt(i) == 'y' || expression.charAt(i) == 'z') {
            i++;
            return new Variable<>(expression.substring(i - 1, i), op);
        } else if (i + 6 <= expression.length() && expression.substring(i, i + 6).equals("square")) {
            i += 6;
            TripleExpression<T> arg = getNum();
            return new CheckedMultiply<>(arg, arg, op);
        } else if (i + 3 <= expression.length() && expression.substring(i, i + 3).equals("abs")) {
            i += 3;
            return new Abs<>(getNum(), op);
        } else if (Character.isWhitespace(expression.charAt(i))) {
            i++;
            return getNum();
        } else {
            throw new FormatException("Incorrect symbol");
        }
    }
}
