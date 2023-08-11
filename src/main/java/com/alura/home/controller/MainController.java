package com.alura.home.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void handleClick(ActionEvent e){

        if (e.getSource()== btnUno){
            bgSection.setBackground(new Background(new BackgroundFill(Color.AQUA,  CornerRadii.EMPTY, Insets.EMPTY)));
        }else if (e.getSource()== btnDos){
            bgSection.setBackground(new Background(new BackgroundFill(Color.YELLOW,  CornerRadii.EMPTY, Insets.EMPTY)));
        }else if (e.getSource()== btnTres){
            bgSection.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE,  CornerRadii.EMPTY, Insets.EMPTY)));
        }else if (e.getSource()== btnCuatro){
            bgSection.setBackground(new Background(new BackgroundFill(Color.VIOLET,  CornerRadii.EMPTY, Insets.EMPTY)));
        }else if (e.getSource()== btnCinco){
            bgSection.setBackground(new Background(new BackgroundFill(Color.STEELBLUE,  CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }
}