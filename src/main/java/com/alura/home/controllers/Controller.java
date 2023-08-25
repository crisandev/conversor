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
    private Label validationMessageCurrency;

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
    private Label validationMessageTemperature;

    @FXML
    private Pane containerWeight;

    @FXML
    private Text titleWeight;

    @FXML
    private Text subtitleWeight;

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
    private Label validationMessageWeight;

    @FXML
    private Pane containerLongitude;

    @FXML
    private Text titleLongitude;

    @FXML
    private Text subtitleLongitude;

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
    private Label validationMessageLongitude;

    @FXML
    private Pane containerTime;

    @FXML
    private Text titleTime;

    @FXML
    private Text subtitleTime;

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
    private Label validationMessageTime;

    @FXML
    private ComboBox<String> cbLanguages;
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

    public ComboBox<String> getCbLanguages() {
        return cbLanguages;
    }

    public void setCbLanguages(ComboBox<String> cbLanguages) {
        this.cbLanguages = cbLanguages;
    }

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

    public Label getValidationMessageCurrency() {
        return validationMessageCurrency;
    }

    public void setValidationMessageCurrency(Label validationMessageCurrency) {
        this.validationMessageCurrency = validationMessageCurrency;
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

    public Label getValidationMessageTemperature() {
        return validationMessageTemperature;
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

    public Label getValidationMessageWeight() {
        return validationMessageWeight;
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

    public Label getValidationMessageLongitude() {
        return validationMessageLongitude;
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

    public Label getValidationMessageTime() {
        return validationMessageTime;
    }

    public Button getCurrentBtn() {
        return currentBtn;
    }

    public void setCurrentBtn(Button currentBtn) {
        this.currentBtn = currentBtn;
    }

}
