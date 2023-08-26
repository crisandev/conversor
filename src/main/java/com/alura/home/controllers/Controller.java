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
    private AnchorPane layout;

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
    private TextField currentTextField;


    public final Background setBgColor(int i, int i1, int i2) {
        return new Background(new BackgroundFill(Color.rgb(i, i1, i2), CornerRadii.EMPTY, Insets.EMPTY));
    }

    public final Background setBgColor(String color) {
        return new Background(new BackgroundFill(Color.web(color), CornerRadii.EMPTY, Insets.EMPTY));
    }


    //GETTER AND SETTER PROPERTIES
    //GETTER AND SETTER PROPERTIES
    //GETTER AND SETTER PROPERTIES


    public AnchorPane getLayout() {
        return layout;
    }

    public void setLayout(AnchorPane layout) {
        this.layout = layout;
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

    public Button getBtnLongitude() {
        return btnLongitude;
    }

    public void setBtnLongitude(Button btnLongitude) {
        this.btnLongitude = btnLongitude;
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

    public Pane getContainerTemperature() {
        return containerTemperature;
    }

    public void setContainerTemperature(Pane containerTemperature) {
        this.containerTemperature = containerTemperature;
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

    public TextField getInputWeight() {
        return inputWeight;
    }

    public void setInputWeight(TextField inputWeight) {
        this.inputWeight = inputWeight;
    }

    public TextField getInputWeightResult() {
        return inputWeightResult;
    }

    public void setInputWeightResult(TextField inputWeightResult) {
        this.inputWeightResult = inputWeightResult;
    }

    public ComboBox<String> getCbWeights() {
        return cbWeights;
    }

    public void setCbWeights(ComboBox<String> cbWeights) {
        this.cbWeights = cbWeights;
    }

    public ComboBox<String> getCbWeightChange() {
        return cbWeightChange;
    }

    public void setCbWeightChange(ComboBox<String> cbWeightChange) {
        this.cbWeightChange = cbWeightChange;
    }

    public Button getBtnConvertWeight() {
        return btnConvertWeight;
    }

    public void setBtnConvertWeight(Button btnConvertWeight) {
        this.btnConvertWeight = btnConvertWeight;
    }

    public Pane getContainerLongitude() {
        return containerLongitude;
    }

    public void setContainerLongitude(Pane containerLongitude) {
        this.containerLongitude = containerLongitude;
    }

    public TextField getInputLongitude() {
        return inputLongitude;
    }

    public void setInputLongitude(TextField inputLongitude) {
        this.inputLongitude = inputLongitude;
    }

    public TextField getInputLongitudeResult() {
        return inputLongitudeResult;
    }

    public void setInputLongitudeResult(TextField inputLongitudeResult) {
        this.inputLongitudeResult = inputLongitudeResult;
    }

    public ComboBox<String> getCbLongitude() {
        return cbLongitude;
    }

    public void setCbLongitude(ComboBox<String> cbLongitude) {
        this.cbLongitude = cbLongitude;
    }

    public ComboBox<String> getCbLongitudeChange() {
        return cbLongitudeChange;
    }

    public void setCbLongitudeChange(ComboBox<String> cbLongitudeChange) {
        this.cbLongitudeChange = cbLongitudeChange;
    }

    public Button getBtnConvertLongitude() {
        return btnConvertLongitude;
    }

    public void setBtnConvertLongitude(Button btnConvertLongitude) {
        this.btnConvertLongitude = btnConvertLongitude;
    }

    public Pane getContainerTime() {
        return containerTime;
    }

    public void setContainerTime(Pane containerTime) {
        this.containerTime = containerTime;
    }

    public TextField getInputTime() {
        return inputTime;
    }

    public void setInputTime(TextField inputTime) {
        this.inputTime = inputTime;
    }

    public TextField getInputTimeResult() {
        return inputTimeResult;
    }

    public void setInputTimeResult(TextField inputTimeResult) {
        this.inputTimeResult = inputTimeResult;
    }

    public ComboBox<String> getCbTimes() {
        return cbTimes;
    }

    public void setCbTimes(ComboBox<String> cbTimes) {
        this.cbTimes = cbTimes;
    }

    public ComboBox<String> getCbTimesChange() {
        return cbTimesChange;
    }

    public void setCbTimesChange(ComboBox<String> cbTimesChange) {
        this.cbTimesChange = cbTimesChange;
    }

    public Button getBtnConvertTime() {
        return btnConvertTime;
    }

    public void setBtnConvertTime(Button btnConvertTime) {
        this.btnConvertTime = btnConvertTime;
    }

    public ComboBox<String> getCbLanguages() {
        return cbLanguages;
    }

    public void setCbLanguages(ComboBox<String> cbLanguages) {
        this.cbLanguages = cbLanguages;
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

    public Text getTitleConversor() {
        return titleConversor;
    }

    public void setTitleConversor(Text titleConversor) {
        this.titleConversor = titleConversor;
    }

    public Text getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Text subtitle) {
        this.subtitle = subtitle;
    }

    public Label getLblValidationMessage() {
        return lblValidationMessage;
    }

    public void setLblValidationMessage(Label lblValidationMessage) {
        this.lblValidationMessage = lblValidationMessage;
    }

    public Button getCurrentBtn() {
        return currentBtn;
    }

    public void setCurrentBtn(Button currentBtn) {
        this.currentBtn = currentBtn;
    }

    public TextField getCurrentTextField() {
        return currentTextField;
    }

    public void setCurrentTextField(TextField currentTextField) {
        this.currentTextField = currentTextField;
    }
}
