package com.alura.home.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Controller implements Initializable {

    CurrencyController currencyController;
    TemperatureController temperatureController;

    public MainController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currencyController = new CurrencyController(this);
        temperatureController = new TemperatureController(this);
        currencyController.init();
        temperatureController.init();
        paintSelected(getContainerCurrency(), getBtnCurrency());
    }

    @FXML
    public void onMouseOver(MouseEvent me) {
        setCurrentBtn((Button) me.getSource());
        getCurrentBtn().setBackground(setBgColor("#253c54"));
    }

    @FXML
    private void changeSection(ActionEvent e) {
        setCurrentBtn((Button) e.getSource());
        if (e.getSource() == getBtnCurrency()) {
            setContainerVisible(getContainerCurrency(), getContainerTemperature(), getContainerWeight(), getContainerDistance(), getContainerTime());
            currencyController.reset();
            btnSelected();
        } else if (e.getSource() == getBtnTemperature()) {
            setContainerVisible(getContainerTemperature(), getContainerCurrency(), getContainerWeight(), getContainerDistance(), getContainerTime());
            temperatureController.reset();
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
    public void onTextChanged(KeyEvent e) {
        setCurrentTextField((TextField) e.getSource());
        if (getCurrentTextField().getId().equalsIgnoreCase(getInputCurrency().getId())) {
            currencyController.textChangedValidation(e);
        } else if (getCurrentTextField().getId().equalsIgnoreCase(getInputTemperature().getId())) {
            temperatureController.textChangedValidation(e);
        }
    }

    @FXML
    private void convertCurrency(ActionEvent e) {
        currencyController.conversionRequest();
    }

    @FXML
    private void convertTemperature(ActionEvent e) {
        temperatureController.conversionRequest();
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