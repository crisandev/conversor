module com.alura.conversor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alura.home to javafx.fxml;
    exports com.alura.home;
    exports com.alura.home.controller;
    opens com.alura.home.controller to javafx.fxml;
}