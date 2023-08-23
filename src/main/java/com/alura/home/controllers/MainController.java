package com.alura.home.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Controller implements Initializable {

    CurrencyController currencyController;

    public MainController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currencyController = new CurrencyController(this);
        currencyController.init();
    }

    @FXML
    public void onMouseOver(MouseEvent me) {
        setCurrentBtn((Button) me.getSource());
        getCurrentBtn().setBackground(setBgColor(51, 80, 113));
    }

    @FXML
    private void changeSection(ActionEvent e) {
        setCurrentBtn((Button) e.getSource());
        if (e.getSource() == getBtnCurrency()) {
            setContainerVisible(getContainerCurrency(), getContainerTemperature(), getContainerWeight(), getContainerDistance(), getContainerTime());
            btnSelected();
        } else if (e.getSource() == getBtnTemperature()) {
            setContainerVisible(getContainerTemperature(), getContainerCurrency(), getContainerWeight(), getContainerDistance(), getContainerTime());
            btnSelected();
        } else if (e.getSource() == getBtnWeight()) {
            setContainerVisible(getContainerWeight(), getContainerTemperature(), getContainerCurrency(), getContainerDistance(), getContainerTime());
            btnSelected();
        } else if (e.getSource() == getBtnDistance()) {
            setContainerVisible(getContainerDistance(), getContainerWeight(), getContainerTemperature(), getContainerCurrency(), getContainerTime());
            btnSelected();
        } else if (e.getSource() == getBtnTime()) {
            setContainerVisible(getContainerTime(), getContainerDistance(), getContainerWeight(), getContainerTemperature(), getContainerCurrency());
            btnSelected();
        }
    }

    @FXML
    private void onTextChange(KeyEvent event) {
        currencyController.textChange(event);
    }

    @FXML
    private void convertCurrency(ActionEvent e){
        currencyController.conversionRequest();
    }

    private void setContainerVisible(Pane active, Pane inactive1, Pane inactive2, Pane inactive3, Pane inactive4) {
        active.setVisible(true);
        inactive1.setVisible(false);
        inactive2.setVisible(false);
        inactive3.setVisible(false);
        inactive4.setVisible(false);
    }

    private void btnSelected() {
        paintSelected(getContainerCurrency(), getBtnCurrency());
        paintSelected(getContainerTemperature(), getBtnTemperature());
        paintSelected(getContainerDistance(), getBtnDistance());
        paintSelected(getContainerWeight(), getBtnWeight());
        paintSelected(getContainerTime(), getBtnTime());
    }

    protected void paintSelected(Pane container, Button btn) {
        if (container.isVisible()) btn.setStyle("-fx-background-color: rgb(51, 80, 113);");
        else btn.setStyle("-fx-background-color: #1c2b45;");
    }
}