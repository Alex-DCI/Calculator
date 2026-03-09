package org.example.calculator;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, Color.rgb(32, 32, 32));

        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/icons/CalculatorAppList.scale-150.png")).toExternalForm());
        stage.getIcons().add(icon);
        stage.setTitle("Calculator");
        stage.setWidth(340);
        stage.setHeight(510);

        stage.setScene(scene);
        stage.show();
    }
}