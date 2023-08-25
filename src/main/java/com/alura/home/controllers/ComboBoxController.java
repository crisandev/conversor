package com.alura.home.controllers;

import com.alura.home.interfaces.Converter;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ComboBoxController {
    public static void comboBoxInitializing(ComboBox<String> cb, Converter converter, String message) {
        cb.setItems(FXCollections.observableArrayList(converter.insertComboBoxValues()));
        cb.getSelectionModel().select(message);
        ComboBoxController.comboBoxStyling(cb);
        ComboBoxController.comboBoxHover(cb);
    }

    @FXML
    public static void comboBoxStyling(ComboBox<String> comboBox, String... padding) {
        String pad;
        if (padding.length > 0) pad = "-fx-padding:" + padding[0] + padding[0] + padding[0] + padding[0] + ";";
        else pad = "-fx-padding: 0px 0px 0px 0px;";
        comboBox.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), new CornerRadii(0), new Insets(-0.5))));
                setStyle("-fx-font-size: 17px;");
                setCursor(Cursor.HAND);
            }
        });

        comboBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), new CornerRadii(0), new Insets(-0.5))));
                setStyle("-fx-font-size: 18px; " + pad);
                setCursor(Cursor.HAND);
            }
        });
    }

    @FXML
    public static void comboBoxHover(ComboBox<String> comboBox, String... padding) {
        String pad;
        if (padding.length > 0) pad = "-fx-padding:" + padding[0] + padding[0] + padding[0] + padding[0] + ";";
        else pad = "-fx-padding: 0px 0px 0px 0px;";
        comboBox.setOnMouseEntered(event -> comboBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                comboBox.setStyle("-fx-background-color: #151f35;" + "-fx-border-color: #0a1229;");
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#151f35"), new CornerRadii(0), new Insets(-0.5))));
                setStyle("-fx-font-size: 18px; " + pad);
            }
        }));

        comboBox.setOnMouseExited(event -> comboBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                comboBox.setStyle("-fx-background-color: #1b2942;" + "-fx-border-color: #0a1229;");
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), new CornerRadii(0), new Insets(-0.5))));
                setStyle("-fx-font-size: 18px; " + pad);
            }
        }));
    }

}
