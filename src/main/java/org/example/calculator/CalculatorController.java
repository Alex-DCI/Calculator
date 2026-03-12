package org.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CalculatorController {

    private String currentOutput = "0";
    private final char DECIMAL_SEPARATOR = new DecimalFormatSymbols(Locale.getDefault()).getDecimalSeparator();
    private boolean isNegative = false;
    private boolean reset = false;

    @FXML
    Label currentLabel, previousLabel;

    @FXML
    Button commaButton;

    @FXML
    public void initialize() {
        commaButton.setText(String.valueOf(DECIMAL_SEPARATOR));
    }

    @FXML
    private void press1() {
        updateCurrentLabel('1');
    }

    @FXML
    private void press2() {
        updateCurrentLabel('2');
    }

    @FXML
    private void press3() {
        updateCurrentLabel('3');
    }

    @FXML
    private void press4() {
        updateCurrentLabel('4');
    }

    @FXML
    private void press5() {
        updateCurrentLabel('5');
    }

    @FXML
    private void press6() {
        updateCurrentLabel('6');
    }

    @FXML
    private void press7() {
        updateCurrentLabel('7');
    }

    @FXML
    private void press8() {
        updateCurrentLabel('8');
    }

    @FXML
    private void press9() {
        updateCurrentLabel('9');
    }

    @FXML
    private void press0() {
        updateCurrentLabel('0');
    }

    @FXML
    private void pressPlusMinus() {
        isNegative = !isNegative;
        currentLabel.setText(getCurrentValue());
    }

    @FXML
    private void pressComma() {
        if (!currentOutput.contains(",")) {
            updateCurrentLabel(DECIMAL_SEPARATOR);
        }
    }

    @FXML
    private void pressEquals() {
        reset = true;
        BigDecimal literal1 = new BigDecimal(previousLabel.getText().substring(0, previousLabel.getText().length() - 1));
        BigDecimal literal2 = new BigDecimal(currentOutput);
        BigDecimal result = null;
        Operation operation;

        if (previousLabel.getText().endsWith("+")) {
            operation = Operation.SUM;
        } else if (previousLabel.getText().endsWith("-")) {
            operation = Operation.SUBTRACT;
        } else if (previousLabel.getText().endsWith("×")) {
            operation = Operation.MULTIPLY;
        } else {
            operation = Operation.DIVIDE;
        }

        if (operation == Operation.SUM) {
            result = literal1.add(literal2);
        } else if (operation == Operation.SUBTRACT) {
            result = literal1.subtract(literal2);
        } else if (operation ==  Operation.MULTIPLY) {
            result = literal1.multiply(literal2);
        } else if (operation == Operation.DIVIDE) {
            result = literal1.divide(literal2, new MathContext(15, RoundingMode.HALF_UP)).stripTrailingZeros();
        }

        currentOutput = result.toString();
        currentLabel.setText(currentOutput);
        previousLabel.setText("");
    }

    @FXML
    private void pressMultiply() {
        reset = true;
        previousLabel.setText(currentLabel.getText() + '×');
    }

    @FXML
    private void pressDivide() {
        reset = true;
        previousLabel.setText(currentLabel.getText() + '÷');
    }

    @FXML
    private void pressSum() {
        reset = true;
        previousLabel.setText(currentLabel.getText() + '+');
    }

    @FXML
    private void pressSubtract() {
        reset = true;
        previousLabel.setText(currentLabel.getText() + '-');
    }

    @FXML
    private void pressDivideOneByX() {

    }

    @FXML
    private void pressSquare() {

    }

    @FXML
    private void pressSquareRoot() {

    }

    @FXML
    private void pressPercent() {

    }

    @FXML
    private void pressClear() {

    }

    @FXML
    private void pressClearAll() {

    }

    @FXML
    private void pressBackspace() {

    }

    private void updateCurrentLabel(char toAdd) {
        if (reset) {
            currentOutput = String.valueOf(toAdd);
            reset = false;
            currentLabel.setText(currentOutput);
            return;
        }
        if (currentOutput.length() < 16) {
            if (currentOutput.equals("0")) {
                currentOutput = "";
            }
            currentOutput += toAdd;
            currentLabel.setText(currentOutput);
        }
    }

    private String getCurrentValue() {
        return isNegative ? '-' + currentOutput : currentOutput;
    }

}