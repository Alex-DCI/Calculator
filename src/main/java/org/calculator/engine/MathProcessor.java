package org.calculator.engine;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MathProcessor {

    private final MathContext mc = new MathContext(30, RoundingMode.HALF_UP);

    public BigDecimal applyUnary(Operation op, BigDecimal value) {
        return switch(op) {
            case SQRT -> value.sqrt(mc);
            case SQUARE -> value.multiply(value, mc);
            default -> throw new IllegalArgumentException("Unsupported operation: " + op);
        };
    }

    public BigDecimal applyBinary(Operation op, BigDecimal a, BigDecimal b) {
        return switch (op) {
            case ADD -> a.add(b, mc);
            case SUBTRACT -> a.subtract(b, mc);
            case MULTIPLY -> a.multiply(b, mc);
            case DIVIDE -> a.divide(b, mc);
            default -> throw new IllegalArgumentException("Unsupported operation: " + op);
        };
    }
}
