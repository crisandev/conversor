module com.alura.conversor {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;

    opens com.alura.home to javafx.fxml;
    exports com.alura.home;
    exports com.alura.home.controller;
    opens com.alura.home.controller to javafx.fxml;
    exports com.alura.home.api;
    opens com.alura.home.api to javafx.fxml;
    exports com.alura.home.converters;
    opens com.alura.home.converters to javafx.fxml;
}