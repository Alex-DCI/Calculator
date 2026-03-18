package org.example.calculator.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;
import org.example.calculator.Operation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class StandardCalculatorController {

    private String currentOutput = "0";
    private final char DECIMAL_SEPARATOR = new DecimalFormatSymbols(Locale.getDefault()).getDecimalSeparator();
    private boolean isNegative = false;
    private boolean reset = false;
    private final MathContext mathContext = new MathContext(30, RoundingMode.HALF_UP);

    @FXML
    Label currentLabel, previousLabel;

    @FXML
    Button commaButton;

    @FXML
    Button mCButton, mRButton, mPlusButton, mMinusButton, mSButton;

    @FXML
    MenuButton memoryMenuButton;

    @FXML
    public void initialize() {

        commaButton.setText(String.valueOf(DECIMAL_SEPARATOR));
        setTooltip(mCButton, "Clear all memory");
        setTooltip(mRButton, "Memory recall");
        setTooltip(mPlusButton, "Memory add");
        setTooltip(mMinusButton, "Memory subtract");
        setTooltip(mSButton, "Memory store");
        setTooltip(memoryMenuButton, "Memory");

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

        if (!currentOutput.contains(String.valueOf(DECIMAL_SEPARATOR))) {
            updateCurrentLabel(DECIMAL_SEPARATOR);
        }

    }

    @FXML
    private void pressEquals() {

        reset = true;
        BigDecimal literal1 = new BigDecimal(previousLabel.getText().substring(0, previousLabel.getText().length() - 1).replace(',', '.'));
        BigDecimal literal2 = new BigDecimal(currentOutput.replace(',', '.'));
        BigDecimal result;
        Operation operation;

        if (previousLabel.getText().endsWith("+")) {
            operation = Operation.SUM;
        } else if (previousLabel.getText().endsWith("-")) {
            operation = Operation.SUBTRACT;
        } else if (previousLabel.getText().endsWith("×")) {
            operation = Operation.MULTIPLY;
        } else if (previousLabel.getText().endsWith("÷")) {
            operation = Operation.DIVIDE;
        } else operation = Operation.PERCENT;

        if (operation == Operation.SUM) {
            result = literal1.add(literal2);
        } else if (operation == Operation.SUBTRACT) {
            result = literal1.subtract(literal2);
        } else if (operation ==  Operation.MULTIPLY) {
            result = literal1.multiply(literal2);
        } else if (operation == Operation.DIVIDE) {
            result = literal1.divide(literal2, mathContext).stripTrailingZeros();
        } else {
            result = literal1.divide(new BigDecimal(100), mathContext).stripTrailingZeros();
            result = result.multiply(literal2);
        }

        currentOutput = result.stripTrailingZeros().toPlainString();
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

        reset = true;
        BigDecimal result = BigDecimal.ONE.divide(new BigDecimal(currentOutput.replace(',', '.')), mathContext);
        currentOutput = result.stripTrailingZeros().toString();
        currentLabel.setText(currentOutput);
        previousLabel.setText("");

    }

    @FXML
    private void pressSquare() {

        reset = true;
        BigDecimal literal = new BigDecimal(currentOutput.replace(',', '.'));
        currentOutput = literal.multiply(literal).stripTrailingZeros().toString();
        currentLabel.setText(currentOutput);
        previousLabel.setText("");

    }

    @FXML
    private void pressSquareRoot() {
        reset = true;
        BigDecimal literal = new BigDecimal(currentOutput.replace(',', '.'));
        currentOutput = literal.sqrt(mathContext).stripTrailingZeros().toString();
        currentLabel.setText(currentOutput);
        previousLabel.setText("");
    }

    @FXML
    private void pressPercent() {
        reset = true;
        previousLabel.setText(currentLabel.getText() + '%');
    }

    @FXML
    private void pressClear() {
        pressClearEntry();
        previousLabel.setText("");
    }

    @FXML
    private void pressClearEntry() {
        currentLabel.setText("0");
        currentOutput = "0";
    }

    @FXML
    private void pressBackspace() {
        currentOutput = currentOutput.substring(0, currentOutput.length() - 1);
        if (currentOutput.isEmpty()) {
            currentOutput = "0";
        }
        currentLabel.setText(currentOutput);
    }

    private void updateCurrentLabel(char toAdd) {

        if (reset) {
            currentOutput = String.valueOf(toAdd);
            reset = false;
            currentLabel.setText(currentOutput);
        } else if (currentOutput.length() < 16) {
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

    private void setTooltip(ButtonBase button, String text) {
        Tooltip tooltip = new Tooltip(text);
        tooltip.setShowDelay(Duration.millis(500));
        button.setTooltip(tooltip);
    }
}