package com.alura.home.util;

import javafx.scene.control.Alert;

public class PopupWindow {
    public static void alertMessage(String messageHeader, String messageContent) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING");
        alert.setHeaderText(messageHeader);
        alert.setContentText(messageContent);
        alert.show();
    }

    public static void errorMessage(String messageHeader, String messageContent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(messageHeader);
        alert.setContentText(messageContent);
        alert.showAndWait();
    }

}
