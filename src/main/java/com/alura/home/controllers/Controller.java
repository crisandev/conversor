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
    private Label validationMessageWeight;
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
    private Label alertJustNumber2;

    @FXML
    private Pane containerDistance;

    @FXML
    private Text titleMonedas3;

    @FXML
    private Text subtitleMonedas3;

    @FXML
    private TextField inputCurrency3;

    @FXML
    private TextField inputCurrencyResult3;

    @FXML
    private ComboBox<String> cbCurrencies3;

    @FXML
    private ComboBox<String> cbCurrenciesChange3;

    @FXML
    private Button btnConvertCurrency3;

    @FXML
    private Label alertJustNumber3;

    @FXML
    private Pane containerTime;

    @FXML
    private Text titleMonedas4;

    @FXML
    private Text subtitleMonedas4;

    @FXML
    private TextField inputCurrency4;

    @FXML
    private TextField inputCurrencyResult4;

    @FXML
    private ComboBox<String> cbCurrencies4;

    @FXML
    private ComboBox<String> cbCurrenciesChange4;

    @FXML
    private Button btnConvertCurrency4;

    @FXML
    private Label alertJustNumber4;
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
    public Label getValidationMessageWeight() {
        return validationMessageWeight;
    }

    public void setValidationMessageWeight(Label validationMessageWeight) {
        this.validationMessageWeight = validationMessageWeight;
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

    public Label getAlertJustNumber2() {
        return alertJustNumber2;
    }

    public void setAlertJustNumber2(Label alertJustNumber2) {
        this.alertJustNumber2 = alertJustNumber2;
    }

    public Pane getContainerDistance() {
        return containerDistance;
    }

    public void setContainerDistance(Pane containerDistance) {
        this.containerDistance = containerDistance;
    }

    public Text getTitleMonedas3() {
        return titleMonedas3;
    }

    public void setTitleMonedas3(Text titleMonedas3) {
        this.titleMonedas3 = titleMonedas3;
    }

    public Text getSubtitleMonedas3() {
        return subtitleMonedas3;
    }

    public void setSubtitleMonedas3(Text subtitleMonedas3) {
        this.subtitleMonedas3 = subtitleMonedas3;
    }

    public TextField getInputCurrency3() {
        return inputCurrency3;
    }

    public void setInputCurrency3(TextField inputCurrency3) {
        this.inputCurrency3 = inputCurrency3;
    }

    public TextField getInputCurrencyResult3() {
        return inputCurrencyResult3;
    }

    public void setInputCurrencyResult3(TextField inputCurrencyResult3) {
        this.inputCurrencyResult3 = inputCurrencyResult3;
    }

    public ComboBox<String> getCbCurrencies3() {
        return cbCurrencies3;
    }

    public void setCbCurrencies3(ComboBox<String> cbCurrencies3) {
        this.cbCurrencies3 = cbCurrencies3;
    }

    public ComboBox<String> getCbCurrenciesChange3() {
        return cbCurrenciesChange3;
    }

    public void setCbCurrenciesChange3(ComboBox<String> cbCurrenciesChange3) {
        this.cbCurrenciesChange3 = cbCurrenciesChange3;
    }

    public Button getBtnConvertCurrency3() {
        return btnConvertCurrency3;
    }

    public void setBtnConvertCurrency3(Button btnConvertCurrency3) {
        this.btnConvertCurrency3 = btnConvertCurrency3;
    }

    public Label getAlertJustNumber3() {
        return alertJustNumber3;
    }

    public void setAlertJustNumber3(Label alertJustNumber3) {
        this.alertJustNumber3 = alertJustNumber3;
    }

    public Pane getContainerTime() {
        return containerTime;
    }

    public void setContainerTime(Pane containerTime) {
        this.containerTime = containerTime;
    }

    public Text getTitleMonedas4() {
        return titleMonedas4;
    }

    public void setTitleMonedas4(Text titleMonedas4) {
        this.titleMonedas4 = titleMonedas4;
    }

    public Text getSubtitleMonedas4() {
        return subtitleMonedas4;
    }

    public void setSubtitleMonedas4(Text subtitleMonedas4) {
        this.subtitleMonedas4 = subtitleMonedas4;
    }

    public TextField getInputCurrency4() {
        return inputCurrency4;
    }

    public void setInputCurrency4(TextField inputCurrency4) {
        this.inputCurrency4 = inputCurrency4;
    }

    public TextField getInputCurrencyResult4() {
        return inputCurrencyResult4;
    }

    public void setInputCurrencyResult4(TextField inputCurrencyResult4) {
        this.inputCurrencyResult4 = inputCurrencyResult4;
    }

    public ComboBox<String> getCbCurrencies4() {
        return cbCurrencies4;
    }

    public void setCbCurrencies4(ComboBox<String> cbCurrencies4) {
        this.cbCurrencies4 = cbCurrencies4;
    }

    public ComboBox<String> getCbCurrenciesChange4() {
        return cbCurrenciesChange4;
    }

    public void setCbCurrenciesChange4(ComboBox<String> cbCurrenciesChange4) {
        this.cbCurrenciesChange4 = cbCurrenciesChange4;
    }

    public Button getBtnConvertCurrency4() {
        return btnConvertCurrency4;
    }

    public void setBtnConvertCurrency4(Button btnConvertCurrency4) {
        this.btnConvertCurrency4 = btnConvertCurrency4;
    }

    public Label getAlertJustNumber4() {
        return alertJustNumber4;
    }

    public void setAlertJustNumber4(Label alertJustNumber4) {
        this.alertJustNumber4 = alertJustNumber4;
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
