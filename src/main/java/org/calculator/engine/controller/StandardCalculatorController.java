package org.calculator.engine.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.calculator.engine.CalculatorEngine;
import org.calculator.engine.Operation;

public class StandardCalculatorController {

    private final CalculatorEngine engine = new CalculatorEngine();
    @FXML
    private Label display;

    @FXML
    private void onDigit(ActionEvent e) {

        engine.inputDigit(((Button)e.getSource()).getText());
        updateDisplay();

    }

    @FXML
    private void onAdd() {

        engine.applyBinary(Operation.ADD);

    }

    @FXML
    private void onSubtract() {
        engine.applyBinary(Operation.SUBTRACT);
    }

    @FXML
    private void onMultiply() {
        engine.applyBinary(Operation.MULTIPLY);
    }

    @FXML
    private void onDivide() {
        engine.applyBinary(Operation.DIVIDE);
    }

    @FXML
    private void onEquals() {

        engine.calculate();
        updateDisplay();

    }

    private void updateDisplay() {
        display.setText(engine.getDisplay());
    }
}