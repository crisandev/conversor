package com.alura.home.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public abstract class Controller {

    @FXML
    private Text title;

    @FXML
    private Button btnCurrency;

    @FXML
    private Button btnTemperature;

    @FXML
    private Button btnWeight;

    @FXML
    private Button btnLongitude;

    @FXML
    private Button btnTime;

    @FXML
    private Pane containerCurrency;

    @FXML
    private TextField inputCurrency;

    @FXML
    private TextField inputCurrencyResult;

    @FXML
    private ComboBox<String> cbCurrencies;

    @FXML
    private ComboBox<String> cbCurrenciesChange;

    @FXML
    private Button btnConvertCurrency;

    @FXML
    private Pane containerTemperature;

    @FXML
    private TextField inputTemperature;

    @FXML
    private TextField inputTemperatureResult;

    @FXML
    private ComboBox<String> cbTemperature;

    @FXML
    private ComboBox<String> cbTemperatureChange;

    @FXML
    private Button btnConvertTemperature;

    @FXML
    private Pane containerWeight;

    @FXML
    private TextField inputWeight;

    @FXML
    private TextField inputWeightResult;

    @FXML
    private ComboBox<String> cbWeights;

    @FXML
    private ComboBox<String> cbWeightChange;

    @FXML
    private Button btnConvertWeight;

    @FXML
    private Pane containerLongitude;

    @FXML
    private TextField inputLongitude;

    @FXML
    private TextField inputLongitudeResult;

    @FXML
    private ComboBox<String> cbLongitude;

    @FXML
    private ComboBox<String> cbLongitudeChange;

    @FXML
    private Button btnConvertLongitude;

    @FXML
    private Pane containerTime;

    @FXML
    private TextField inputTime;

    @FXML
    private TextField inputTimeResult;

    @FXML
    private ComboBox<String> cbTimes;

    @FXML
    private ComboBox<String> cbTimesChange;

    @FXML
    private Button btnConvertTime;

    @FXML
    private ComboBox<String> cbLanguages;

    @FXML
    private Label lblInsertValue;

    @FXML
    private Label lblResult;

    @FXML
    private Text titleConversor;

    @FXML
    private Text subtitle;

    @FXML
    private Label lblValidationMessage;


    private Button currentBtn;


    public final Background setBgColor(int i, int i1, int i2) {
        return new Background(new BackgroundFill(Color.rgb(i, i1, i2), CornerRadii.EMPTY, Insets.EMPTY));
    }

    public final Background setBgColor(String color) {
        return new Background(new BackgroundFill(Color.web(color), CornerRadii.EMPTY, Insets.EMPTY));
    }

    //GETTER AND SETTER PROPERTIES
    //GETTER AND SETTER PROPERTIES
    //GETTER AND SETTER PROPERTIES

    public void setCurrentBtn(Button currentBtn) {
        this.currentBtn = currentBtn;
    }




    public Text getTitle() {
        return title;
    }

    public Button getBtnCurrency() {
        return btnCurrency;
    }

    public Button getBtnTemperature() {
        return btnTemperature;
    }

    public Button getBtnWeight() {
        return btnWeight;
    }

    public Button getBtnLongitude() {
        return btnLongitude;
    }

    public Button getBtnTime() {
        return btnTime;
    }

    public Pane getContainerCurrency() {
        return containerCurrency;
    }

    public TextField getInputCurrency() {
        return inputCurrency;
    }

    public TextField getInputCurrencyResult() {
        return inputCurrencyResult;
    }

    public ComboBox<String> getCbCurrencies() {
        return cbCurrencies;
    }

    public ComboBox<String> getCbCurrenciesChange() {
        return cbCurrenciesChange;
    }

    public Button getBtnConvertCurrency() {
        return btnConvertCurrency;
    }

    public Pane getContainerTemperature() {
        return containerTemperature;
    }

    public TextField getInputTemperature() {
        return inputTemperature;
    }

    public TextField getInputTemperatureResult() {
        return inputTemperatureResult;
    }

    public ComboBox<String> getCbTemperature() {
        return cbTemperature;
    }

    public ComboBox<String> getCbTemperatureChange() {
        return cbTemperatureChange;
    }

    public Button getBtnConvertTemperature() {
        return btnConvertTemperature;
    }

    public Pane getContainerWeight() {
        return containerWeight;
    }

    public TextField getInputWeight() {
        return inputWeight;
    }

    public TextField getInputWeightResult() {
        return inputWeightResult;
    }

    public ComboBox<String> getCbWeights() {
        return cbWeights;
    }

    public ComboBox<String> getCbWeightChange() {
        return cbWeightChange;
    }

    public Button getBtnConvertWeight() {
        return btnConvertWeight;
    }

    public Pane getContainerLongitude() {
        return containerLongitude;
    }

    public TextField getInputLongitude() {
        return inputLongitude;
    }

    public TextField getInputLongitudeResult() {
        return inputLongitudeResult;
    }

    public ComboBox<String> getCbLongitude() {
        return cbLongitude;
    }

    public ComboBox<String> getCbLongitudeChange() {
        return cbLongitudeChange;
    }

    public Button getBtnConvertLongitude() {
        return btnConvertLongitude;
    }

    public Pane getContainerTime() {
        return containerTime;
    }

    public TextField getInputTime() {
        return inputTime;
    }

    public TextField getInputTimeResult() {
        return inputTimeResult;
    }

    public ComboBox<String> getCbTimes() {
        return cbTimes;
    }

    public ComboBox<String> getCbTimesChange() {
        return cbTimesChange;
    }

    public Button getBtnConvertTime() {
        return btnConvertTime;
    }

    public ComboBox<String> getCbLanguages() {
        return cbLanguages;
    }

    public Label getLblInsertValue() {
        return lblInsertValue;
    }

    public Label getLblResult() {
        return lblResult;
    }

    public Text getTitleConversor() {
        return titleConversor;
    }

    public Text getSubtitle() {
        return subtitle;
    }

    public Label getLblValidationMessage() {
        return lblValidationMessage;
    }

    public Button getCurrentBtn() {
        return currentBtn;
    }
}
