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

    public void setValidationMessageTemperature(Label validationMessageTemperature) {
        this.validationMessageTemperature = validationMessageTemperature;
    }

    public Pane getContainerWeight() {
        return containerWeight;
    }

    public void setContainerWeight(Pane containerWeight) {
        this.containerWeight = containerWeight;
    }

    public Text getTitleWeight() {
        return titleWeight;
    }

    public void setTitleWeight(Text titleWeight) {
        this.titleWeight = titleWeight;
    }

    public Text getSubtitleWeight() {
        return subtitleWeight;
    }

    public void setSubtitleWeight(Text subtitleWeight) {
        this.subtitleWeight = subtitleWeight;
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

    public Label getValidationMessageWeight() {
        return validationMessageWeight;
    }

    public void setValidationMessageWeight(Label validationMessageWeight) {
        this.validationMessageWeight = validationMessageWeight;
    }

    public Pane getContainerLongitude() {
        return containerLongitude;
    }

    public void setContainerLongitude(Pane containerLongitude) {
        this.containerLongitude = containerLongitude;
    }

    public Text getTitleLongitude() {
        return titleLongitude;
    }

    public void setTitleLongitude(Text titleLongitude) {
        this.titleLongitude = titleLongitude;
    }

    public Text getSubtitleLongitude() {
        return subtitleLongitude;
    }

    public void setSubtitleLongitude(Text subtitleLongitude) {
        this.subtitleLongitude = subtitleLongitude;
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

    public Label getValidationMessageLongitude() {
        return validationMessageLongitude;
    }

    public void setValidationMessageLongitude(Label validationMessageLongitude) {
        this.validationMessageLongitude = validationMessageLongitude;
    }

    public Pane getContainerTime() {
        return containerTime;
    }

    public void setContainerTime(Pane containerTime) {
        this.containerTime = containerTime;
    }

    public Text getTitleTime() {
        return titleTime;
    }

    public void setTitleTime(Text titleTime) {
        this.titleTime = titleTime;
    }

    public Text getSubtitleTime() {
        return subtitleTime;
    }

    public void setSubtitleTime(Text subtitleTime) {
        this.subtitleTime = subtitleTime;
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

    public Label getValidationMessageTime() {
        return validationMessageTime;
    }

    public void setValidationMessageTime(Label validationMessageTime) {
        this.validationMessageTime = validationMessageTime;
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
