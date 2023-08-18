package com.alura.home.controller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ComboBoxController {
    @FXML
    private void comboBoxStyling(ComboBox<String> comboBox) {
        comboBox.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), null, null)));
                setStyle("-fx-font-size: 18px;");
                setCursor(Cursor.HAND);
            }
        });

        comboBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), null, null)));
                setStyle("-fx-font-size: 18px; -fx-padding: 0px 0px 0px 0px;");
                setCursor(Cursor.HAND);
            }
        });
    }


    @FXML
    private void comboBoxHover(ComboBox<String> comboBox) {
        comboBox.setOnMouseEntered(event -> comboBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                comboBox.setStyle("-fx-background-color: #151f35;" + "-fx-border-color: #0a1229;");
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#151f35"), null, null)));
                setStyle("-fx-font-size: 18px; -fx-padding: 0px 0px 0px 0px;");
            }
        }));

        comboBox.setOnMouseExited(event -> comboBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                comboBox.setStyle("-fx-background-color: #1b2942;" + "-fx-border-color: #0a1229;");
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), null, null)));
                setStyle("-fx-font-size: 18px; -fx-padding: 0px 0px 0px 0px;");
            }
        }));
    }

}
