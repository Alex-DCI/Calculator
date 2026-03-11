package org.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.math.BigDecimal;

public class CalculatorController {
    @FXML
    Label label;
    BigDecimal total = new BigDecimal(0);
    String totalString = "0";

    @FXML
    private void press1(ActionEvent event) {
        total = total.multiply(BigDecimal.TEN).add(BigDecimal.ONE);
        totalString = total.toString();
        label.setText(totalString);
    }
    @FXML
    private void press2(ActionEvent event) {
        total = total.multiply(BigDecimal.TEN).add(BigDecimal.TWO);
        totalString = total.toString();
        label.setText(totalString);
    }
    @FXML
    private void press3(ActionEvent event) {
        total = total.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(3L));
        totalString = total.toString();
        label.setText(totalString);
    }
    @FXML
    private void press4(ActionEvent event) {
        total = total.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(4L));
        totalString = total.toString();
        label.setText(totalString);
    }
    @FXML
    private void press5(ActionEvent event) {
        total = total.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(5L));
        totalString = total.toString();
        label.setText(totalString);
    }
    @FXML
    private void press6(ActionEvent event) {
        total = total.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(6L));
        totalString = total.toString();
        label.setText(totalString);
    }
    @FXML
    private void press7(ActionEvent event) {
        total = total.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(7L));
        totalString = total.toString();
        label.setText(totalString);
    }
    @FXML
    private void press8(ActionEvent event) {
        total = total.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(8L));
        totalString = total.toString();
        label.setText(totalString);
    }
    @FXML
    private void press9(ActionEvent event) {
        total = total.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(9L));
        totalString = total.toString();
        label.setText(totalString);
    }
    @FXML
    private void press0(ActionEvent event) {
        total = total.multiply(BigDecimal.TEN);
        totalString = total.toString();
        label.setText(totalString);
    }
    @FXML
    private void pressPlusMinus(ActionEvent event) {
        total = total.multiply(BigDecimal.valueOf(-1L));
        totalString = total.toString();
        label.setText(totalString);
    }
    @FXML
    private void pressComma(ActionEvent event) {
        if(!totalString.contains(",")) {
            totalString += ',';
            label.setText(totalString);
            total = total.multiply(BigDecimal.valueOf(1.0));
        }
    }
    @FXML
    private void pressEquals(ActionEvent event) {

    }
    @FXML
    private void pressMultiply(ActionEvent event) {

    }
    @FXML
    private void pressDivide(ActionEvent event) {

    }
    @FXML
    private void pressSum(ActionEvent event) {

    }
    @FXML
    private void pressSubtract(ActionEvent event) {

    }
    @FXML
    private void pressDivideOneByX(ActionEvent event) {

    }
    @FXML
    private void pressSquare(ActionEvent event) {

    }
    @FXML
    private void pressSquareRoot(ActionEvent event) {

    }
    @FXML
    private void pressPercent(ActionEvent event) {

    }
    @FXML
    private void pressClear(ActionEvent event) {

    }
    @FXML
    private void pressClearAll(ActionEvent event) {

    }
    @FXML
    private void pressBackspace(ActionEvent event) {

    }
}
