package org.calculator.engine;

import java.math.BigDecimal;

public class CalculatorState {

    private BigDecimal currentValue = BigDecimal.ZERO;
    private BigDecimal storedValue = null;
    private Operation pendingOperation = null;
    private boolean resetInput = false;

    public void appendDigit(String digit) {

        if (resetInput) {
            currentValue = new BigDecimal(digit);
            resetInput = false;
        } else {
            currentValue = new BigDecimal(currentValue.toPlainString() + digit);
        }

    }

    public BigDecimal getCurrentValue() {

        return currentValue;

    }

    public void setValue(BigDecimal value) {

        currentValue = value;
        resetInput = true;

    }

    public void prepareBinary(Operation op) {

        storedValue = currentValue;
        pendingOperation = op;
        resetInput = true;

    }

    public void clearPending() {

        pendingOperation = null;
        storedValue = null;

    }

    public BigDecimal getStoredValue() {

        return storedValue;

    }

    public Operation getPendingOperation() {

        return pendingOperation;

    }

}
