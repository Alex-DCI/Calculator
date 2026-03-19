module org.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens org.calculator to javafx.fxml;
    exports org.calculator;
    exports org.calculator.engine.controller;
    opens org.calculator.engine.controller to javafx.fxml;
    exports org.calculator.engine;
    opens org.calculator.engine to javafx.fxml;
}