package org.calculator.engine;

import java.math.BigDecimal;

public class CalculatorEngine {

    private final MathProcessor math = new MathProcessor();
    private final Formatter formatter = new Formatter();
    private final CalculatorState state = new CalculatorState();

    public void inputDigit(String digit) {

        state.appendDigit(digit);

    }

    public void applyUnary(Operation op) {

        BigDecimal value = state.getCurrentValue();
        BigDecimal result = math.applyUnary(op, value);
        state.setValue(result);

    }

    public void applyBinary(Operation op) {

        state.prepareBinary(op);

    }

    public void calculate() {

        BigDecimal result = math.applyBinary(state.getPendingOperation(), state.getStoredValue(),  state.getCurrentValue());
        state.setValue(result);
        state.clearPending();

    }

    public String getDisplay() {

        return formatter.format(state.getCurrentValue());

    }
}
