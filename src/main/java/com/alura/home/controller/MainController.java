package com.alura.home.controller;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    Button currentBtn;
    @FXML
    private Button btnUno;

    @FXML
    private Button btnDos;

    @FXML
    private Button btnTres;

    @FXML
    private Button btnCuatro;

    @FXML
    private Button btnCinco;

    @FXML
    private GridPane bgSection;

    @FXML
    private ComboBox<String> cbMonedas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBoxMonedasStyling();
    }


    @FXML
    private void comboBoxMonedasStyling() {
        cbMonedas.setItems(FXCollections.observableArrayList("Cristian", "Juan"));
        cbMonedas.getSelectionModel().select(0);
        cbMonedas.setCellFactory(param -> new ListCell<>() {
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

        cbMonedas.setOnMouseEntered(event ->  cbMonedas.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#FFFFFF"), null, null)));
                setStyle("-fx-font-size: 18px; -fx-padding: 0px 0px 0px 0px;");
            }
        }));
        cbMonedas.setOnMouseExited(event -> cbMonedas.setStyle("-fx-background-color: transparent;"));

        cbMonedas.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), null, null)));
                setStyle("-fx-font-size: 18px; -fx-padding: 0px 0px 0px 0px;");
            }
        });
    }

    @FXML
    private void handleClick(ActionEvent e) {

        if (e.getSource() == btnUno) {
            bgSection.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
        } else if (e.getSource() == btnDos) {
            bgSection.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        } else if (e.getSource() == btnTres) {
            bgSection.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));
        } else if (e.getSource() == btnCuatro) {
            bgSection.setBackground(new Background(new BackgroundFill(Color.VIOLET, CornerRadii.EMPTY, Insets.EMPTY)));
        } else if (e.getSource() == btnCinco) {
            bgSection.setBackground(new Background(new BackgroundFill(Color.STEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    @FXML
    private void onMouseOver(MouseEvent me) {
        currentBtn = (Button) me.getSource();
        currentBtn.setBackground(new Background(new BackgroundFill(Color.rgb(51, 80, 113), CornerRadii.EMPTY, Insets.EMPTY)));
    }
}