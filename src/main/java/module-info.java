module org.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.calculator to javafx.fxml;
    exports org.example.calculator;
    exports org.example.calculator.Controller;
    opens org.example.calculator.Controller to javafx.fxml;
}