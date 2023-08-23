package com.alura.home.controller;

import com.alura.home.converters.Currency;
import com.alura.home.interfaces.Converter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controllers implements Initializable {

    @FXML
    private Label alertJustNumber;
    @FXML
    private Pane containerMonedas;
    @FXML
    private Pane containerTemperatura;
    @FXML
    private Pane containerPeso;
    @FXML
    private Pane containerDistancias;
    @FXML
    private Pane containerTiempo;
    @FXML
    private Pane sidebar;
    @FXML
    private AnchorPane layout;
    @FXML
    private VBox sidebarContainer;
    @FXML
    private Text title;
    @FXML
    private Button currentBtn;
    @FXML
    private Button btnMonedas;
    @FXML
    private Button btnTemperatura;
    @FXML
    private Button btnPeso;
    @FXML
    private Button btnDistancia;
    @FXML
    private Button btnTiempo;
    @FXML
    private Button btnConvertCurrency;
    @FXML
    private Text titleMonedas;
    @FXML
    private Text subtitleMonedas;
    @FXML
    private TextField inputCurrency;
    @FXML
    private TextField inputCurrencyResult;
    @FXML
    private ComboBox<String> cbCurrencies;
    @FXML
    private ComboBox<String> cbCurrenciesChange;

    private Currency currencyConverter;
    private CurrencyController currencyController;

    public Controllers() {
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    public Background setBgColor(int i, int i1, int i2) {
        return new Background(new BackgroundFill(Color.rgb(i, i1, i2), CornerRadii.EMPTY, Insets.EMPTY));
    }

    public Background setBgColor(String color) {
        return new Background(new BackgroundFill(Color.web(color), CornerRadii.EMPTY, Insets.EMPTY));
    }

    public void comboBoxInitializing(ComboBox<String> cb, Converter converter) {
        cb.setItems(FXCollections.observableArrayList(converter.insertComboBoxValues()));
        cb.getSelectionModel().select("SELECT A CURRENCY");
        ComboBoxController.comboBoxStyling(cb);
        ComboBoxController.comboBoxHover(cb);
    }

    @FXML
    public void onMouseOver(MouseEvent me) {
        setCurrentBtn((Button) me.getSource());
        getCurrentBtn().setBackground(setBgColor(51, 80, 113));
    }

    @FXML
    private void changeSection(ActionEvent e) {
        setCurrentBtn((Button) e.getSource());
        if (e.getSource() == getBtnMonedas()) {
            setContainerVisible(getContainerMonedas(), getContainerTemperatura(), getContainerPeso(), getContainerDistancias(), getContainerTiempo());
            btnSelected();
        } else if (e.getSource() == getBtnTemperatura()) {
            setContainerVisible(getContainerTemperatura(), getContainerMonedas(), getContainerPeso(), getContainerDistancias(), getContainerTiempo());
            btnSelected();
        } else if (e.getSource() == getBtnPeso()) {
            setContainerVisible(getContainerPeso(), getContainerTemperatura(), getContainerMonedas(), getContainerDistancias(), getContainerTiempo());
            btnSelected();
        } else if (e.getSource() == getBtnDistancia()) {
            setContainerVisible(getContainerDistancias(), getContainerPeso(), getContainerTemperatura(), getContainerMonedas(), getContainerTiempo());
            btnSelected();
        } else if (e.getSource() == getBtnTiempo()) {
            setContainerVisible(getContainerTiempo(), getContainerDistancias(), getContainerPeso(), getContainerTemperatura(), getContainerMonedas());
            btnSelected();
        }
    }

    @FXML
    public void onTextChange(KeyEvent event) {
    }

    private void setContainerVisible(Pane active, Pane inactive1, Pane inactive2, Pane inactive3, Pane inactive4) {
        active.setVisible(true);
        inactive1.setVisible(false);
        inactive2.setVisible(false);
        inactive3.setVisible(false);
        inactive4.setVisible(false);
    }

    private void btnSelected() {
        paintSelected(getContainerMonedas(), getBtnMonedas());
        paintSelected(getContainerTemperatura(), getBtnTemperatura());
        paintSelected(getContainerDistancias(), getBtnDistancia());
        paintSelected(getContainerPeso(), getBtnPeso());
        paintSelected(getContainerTiempo(), getBtnTiempo());
    }

    protected void paintSelected(Pane container, Button btn) {
        if (container.isVisible()) btn.setStyle("-fx-background-color: rgb(51, 80, 113);");
        else btn.setStyle("-fx-background-color: #1c2b45;");
    }



    //GETTER AND SETTER PROPERTIES
    //GETTER AND SETTER PROPERTIES
    //GETTER AND SETTER PROPERTIES
    public Label getAlertJustNumber() {
        return alertJustNumber;
    }

    public void setAlertJustNumber(Label alertJustNumber) {
        this.alertJustNumber = alertJustNumber;
    }

    public Pane getContainerMonedas() {
        return containerMonedas;
    }

    public void setContainerMonedas(Pane containerMonedas) {
        this.containerMonedas = containerMonedas;
    }

    public Pane getContainerTemperatura() {
        return containerTemperatura;
    }

    public void setContainerTemperatura(Pane containerTemperatura) {
        this.containerTemperatura = containerTemperatura;
    }

    public Pane getContainerPeso() {
        return containerPeso;
    }

    public void setContainerPeso(Pane containerPeso) {
        this.containerPeso = containerPeso;
    }

    public Pane getContainerDistancias() {
        return containerDistancias;
    }

    public void setContainerDistancias(Pane containerDistancias) {
        this.containerDistancias = containerDistancias;
    }

    public Pane getContainerTiempo() {
        return containerTiempo;
    }

    public void setContainerTiempo(Pane containerTiempo) {
        this.containerTiempo = containerTiempo;
    }

    public Pane getSidebar() {
        return sidebar;
    }

    public void setSidebar(Pane sidebar) {
        this.sidebar = sidebar;
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

    public Text getTitle() {
        return title;
    }

    public void setTitle(Text title) {
        this.title = title;
    }

    public Button getCurrentBtn() {
        return currentBtn;
    }

    public void setCurrentBtn(Button currentBtn) {
        this.currentBtn = currentBtn;
    }

    public Button getBtnMonedas() {
        return btnMonedas;
    }

    public void setBtnMonedas(Button btnMonedas) {
        this.btnMonedas = btnMonedas;
    }

    public Button getBtnTemperatura() {
        return btnTemperatura;
    }

    public void setBtnTemperatura(Button btnTemperatura) {
        this.btnTemperatura = btnTemperatura;
    }

    public Button getBtnPeso() {
        return btnPeso;
    }

    public void setBtnPeso(Button btnPeso) {
        this.btnPeso = btnPeso;
    }

    public Button getBtnDistancia() {
        return btnDistancia;
    }

    public void setBtnDistancia(Button btnDistancia) {
        this.btnDistancia = btnDistancia;
    }

    public Button getBtnTiempo() {
        return btnTiempo;
    }

    public void setBtnTiempo(Button btnTiempo) {
        this.btnTiempo = btnTiempo;
    }

    public Button getBtnConvertCurrency() {
        return btnConvertCurrency;
    }

    public void setBtnConvertCurrency(Button btnConvertCurrency) {
        this.btnConvertCurrency = btnConvertCurrency;
    }

    public Text getTitleMonedas() {
        return titleMonedas;
    }

    public void setTitleMonedas(Text titleMonedas) {
        this.titleMonedas = titleMonedas;
    }

    public Text getSubtitleMonedas() {
        return subtitleMonedas;
    }

    public void setSubtitleMonedas(Text subtitleMonedas) {
        this.subtitleMonedas = subtitleMonedas;
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

    public Currency getCurrencyConverter() {
        return currencyConverter;
    }

    public void setCurrencyConverter(Currency currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    public CurrencyController getCurrencyController() {
        return currencyController;
    }

    public void setCurrencyController(CurrencyController currencyController) {
        this.currencyController = currencyController;
    }
}
