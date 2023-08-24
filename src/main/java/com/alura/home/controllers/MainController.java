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

    private CurrencyController currencyController;
    private TemperatureController temperatureController;
    private WeightController weightController;
    private DistanceController distanceController;
    private TimeController timeController;

    public MainController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currencyController = new CurrencyController(this);
        temperatureController = new TemperatureController(this);
        weightController = new WeightController(this);
        distanceController = new DistanceController(this);
        timeController = new TimeController(this);
        currencyController.init();
        temperatureController.init();
        weightController.init();
        distanceController.init();
        timeController.init();

//        BigDecimal d = new BigDecimal(9.8421e+7);
//        NumberFormat n = NumberFormat.getInstance(Locale.US);
//        n.setMaximumFractionDigits(19);
//        String formatResult = n.format(d);
//        System.out.println(formatResult);


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
            weightController.reset();
            btnSelected();
        } else if (e.getSource() == getBtnDistance()) {
            setContainerVisible(getContainerDistance(), getContainerWeight(), getContainerTemperature(), getContainerCurrency(), getContainerTime());
            btnSelected();
        } else if (e.getSource() == getBtnTime()) {
            setContainerVisible(getContainerTime(), getContainerDistance(), getContainerWeight(), getContainerTemperature(), getContainerCurrency());
            timeController.reset();
            btnSelected();
        }
    }

    @FXML
    public void onTextChanged(KeyEvent e) {
        setCurrentTextField((TextField) e.getSource());
        if (getCurrentTextField().getId().equalsIgnoreCase(getInputCurrency().getId())) {
        }
    }

    @FXML
    public void onCurrencyTextChanged(KeyEvent e) {
        currencyController.textChangedValidation(e);
    }

    @FXML
    public void onTemperatureTextChanged(KeyEvent e) {
        temperatureController.textChangedValidation(e);
    }

    @FXML
    public void onWeightTextChanged(KeyEvent e) {
        weightController.textChangedValidation(e);
    }

    @FXML
    public void onDistanceTextChanged(KeyEvent e) {
    }

    @FXML
    public void onTimeTextChanged(KeyEvent e) {
        timeController.textChangedValidation(e);
    }


    @FXML
    private void convertCurrency(ActionEvent e) {
        currencyController.conversionRequest();
    }

    @FXML
    private void convertTemperature(ActionEvent e) {
        temperatureController.conversionRequest();
    }

    @FXML
    private void convertWeight(ActionEvent e) {
        weightController.conversionRequest();
    }

    @FXML
    private void convertDistance(ActionEvent e) {
    }

    @FXML
    private void convertTime(ActionEvent e) {
        timeController.conversionRequest();
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