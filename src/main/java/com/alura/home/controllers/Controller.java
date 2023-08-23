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

public class Controller {
    @FXML
    private VBox sidebarContainer;

    @FXML
    private Pane sidebar;

    @FXML
    private Text title;

    @FXML
    private Button btnCurrency;

    @FXML
    private Button btnTemperature;

    @FXML
    private Button btnWeight;

    @FXML
    private Button btnDistance;

    @FXML
    private Button btnTime;

    @FXML
    private Pane containerCurrency;

    @FXML
    private Text titleCurrency;

    @FXML
    private Text subtitleCurrency;

    @FXML
    private Label lblInsertValue;

    @FXML
    private Label lblResult;

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
    private Label alertJustNumber;

    @FXML
    private Pane containerTemperature;

    @FXML
    private Text titleTemperature;

    @FXML
    private Text subtitleTemperature;

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
    private Pane containerDistance;

    @FXML
    private Pane containerTime;
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

    public Pane getContainerDistance() {
        return containerDistance;
    }

    public void setContainerDistance(Pane containerDistance) {
        this.containerDistance = containerDistance;
    }

    public Pane getContainerTime() {
        return containerTime;
    }

    public void setContainerTime(Pane containerTime) {
        this.containerTime = containerTime;
    }

    public Button getCurrentBtn() {
        return currentBtn;
    }

    public void setCurrentBtn(Button currentBtn) {
        this.currentBtn = currentBtn;
    }

    public VBox getSidebarContainer() {
        return sidebarContainer;
    }

    public void setSidebarContainer(VBox sidebarContainer) {
        this.sidebarContainer = sidebarContainer;
    }

    public Pane getSidebar() {
        return sidebar;
    }

    public void setSidebar(Pane sidebar) {
        this.sidebar = sidebar;
    }

    public Text getTitle() {
        return title;
    }

    public void setTitle(Text title) {
        this.title = title;
    }

    public Button getBtnCurrency() {
        return btnCurrency;
    }

    public void setBtnCurrency(Button btnCurrency) {
        this.btnCurrency = btnCurrency;
    }

    public Button getBtnTemperature() {
        return btnTemperature;
    }

    public void setBtnTemperature(Button btnTemperature) {
        this.btnTemperature = btnTemperature;
    }

    public Button getBtnWeight() {
        return btnWeight;
    }

    public void setBtnWeight(Button btnWeight) {
        this.btnWeight = btnWeight;
    }

    public Button getBtnDistance() {
        return btnDistance;
    }

    public void setBtnDistance(Button btnDistance) {
        this.btnDistance = btnDistance;
    }

    public Button getBtnTime() {
        return btnTime;
    }

    public void setBtnTime(Button btnTime) {
        this.btnTime = btnTime;
    }

    public Pane getContainerCurrency() {
        return containerCurrency;
    }

    public void setContainerCurrency(Pane containerCurrency) {
        this.containerCurrency = containerCurrency;
    }

    public Text getTitleCurrency() {
        return titleCurrency;
    }

    public void setTitleCurrency(Text titleCurrency) {
        this.titleCurrency = titleCurrency;
    }

    public Text getSubtitleCurrency() {
        return subtitleCurrency;
    }

    public void setSubtitleCurrency(Text subtitleCurrency) {
        this.subtitleCurrency = subtitleCurrency;
    }

    public Label getLblInsertValue() {
        return lblInsertValue;
    }

    public void setLblInsertValue(Label lblInsertValue) {
        this.lblInsertValue = lblInsertValue;
    }

    public Label getLblResult() {
        return lblResult;
    }

    public void setLblResult(Label lblResult) {
        this.lblResult = lblResult;
    }

    public TextField getInputCurrency() {
        return inputCurrency;
    }

    public void setInputCurrency(TextField inputCurrency) {
        this.inputCurrency = inputCurrency;
    }

    public TextField getInputCurrencyResult() {
        return inputCurrencyResult;
    }

    public void setInputCurrencyResult(TextField inputCurrencyResult) {
        this.inputCurrencyResult = inputCurrencyResult;
    }

    public ComboBox<String> getCbCurrencies() {
        return cbCurrencies;
    }

    public void setCbCurrencies(ComboBox<String> cbCurrencies) {
        this.cbCurrencies = cbCurrencies;
    }

    public ComboBox<String> getCbCurrenciesChange() {
        return cbCurrenciesChange;
    }

    public void setCbCurrenciesChange(ComboBox<String> cbCurrenciesChange) {
        this.cbCurrenciesChange = cbCurrenciesChange;
    }

    public Button getBtnConvertCurrency() {
        return btnConvertCurrency;
    }

    public void setBtnConvertCurrency(Button btnConvertCurrency) {
        this.btnConvertCurrency = btnConvertCurrency;
    }

    public Label getAlertJustNumber() {
        return alertJustNumber;
    }

    public void setAlertJustNumber(Label alertJustNumber) {
        this.alertJustNumber = alertJustNumber;
    }

    public Pane getContainerTemperature() {
        return containerTemperature;
    }

    public void setContainerTemperature(Pane containerTemperature) {
        this.containerTemperature = containerTemperature;
    }

    public Text getTitleTemperature() {
        return titleTemperature;
    }

    public void setTitleTemperature(Text titleTemperature) {
        this.titleTemperature = titleTemperature;
    }

    public Text getSubtitleTemperature() {
        return subtitleTemperature;
    }

    public void setSubtitleTemperature(Text subtitleTemperature) {
        this.subtitleTemperature = subtitleTemperature;
    }

    public TextField getInputTemperature() {
        return inputTemperature;
    }

    public void setInputTemperature(TextField inputTemperature) {
        this.inputTemperature = inputTemperature;
    }

    public TextField getInputTemperatureResult() {
        return inputTemperatureResult;
    }

    public void setInputTemperatureResult(TextField inputTemperatureResult) {
        this.inputTemperatureResult = inputTemperatureResult;
    }

    public ComboBox<String> getCbTemperature() {
        return cbTemperature;
    }

    public void setCbTemperature(ComboBox<String> cbTemperature) {
        this.cbTemperature = cbTemperature;
    }

    public ComboBox<String> getCbTemperatureChange() {
        return cbTemperatureChange;
    }

    public void setCbTemperatureChange(ComboBox<String> cbTemperatureChange) {
        this.cbTemperatureChange = cbTemperatureChange;
    }

    public Button getBtnConvertTemperature() {
        return btnConvertTemperature;
    }

    public void setBtnConvertTemperature(Button btnConvertTemperature) {
        this.btnConvertTemperature = btnConvertTemperature;
    }

    public Pane getContainerWeight() {
        return containerWeight;
    }

    public void setContainerWeight(Pane containerWeight) {
        this.containerWeight = containerWeight;
    }
}
