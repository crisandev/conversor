package com.alura.home.controllers;

import com.alura.home.enums.Languages;

import com.alura.home.language.Language;
import com.alura.home.util.Utilities;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Controller implements Initializable {


    private CurrencyController currencyController;
    private TemperatureController temperatureController;
    private WeightController weightController;
    private LongitudeController longitudeController;
    private TimeController timeController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbLanguages();
        initControllers();
    }

    private void initControllers() {
        currencyController = new CurrencyController(this);
        temperatureController = new TemperatureController(this);
        weightController = new WeightController(this);
        longitudeController = new LongitudeController(this);
        timeController = new TimeController(this);
        currencyController.init();
        temperatureController.init();
        weightController.init();
        longitudeController.init();
        timeController.init();
    }


    @FXML
    private void changeSection(ActionEvent e) {
        setCurrentBtn((Button) e.getSource());
        if (e.getSource() == getBtnCurrency()) {
            setContainerVisible(getContainerCurrency(), getContainerTemperature(), getContainerWeight(), getContainerLongitude(), getContainerTime());
            currencyController.reset();
            btnSelected();
        } else if (e.getSource() == getBtnTemperature()) {
            setContainerVisible(getContainerTemperature(), getContainerCurrency(), getContainerWeight(), getContainerLongitude(), getContainerTime());
            temperatureController.reset();
            btnSelected();
        } else if (e.getSource() == getBtnWeight()) {
            setContainerVisible(getContainerWeight(), getContainerTemperature(), getContainerCurrency(), getContainerLongitude(), getContainerTime());
            weightController.reset();
            btnSelected();
        } else if (e.getSource() == getBtnLongitude()) {
            setContainerVisible(getContainerLongitude(), getContainerWeight(), getContainerTemperature(), getContainerCurrency(), getContainerTime());
            longitudeController.reset();
            btnSelected();
        } else if (e.getSource() == getBtnTime()) {
            setContainerVisible(getContainerTime(), getContainerLongitude(), getContainerWeight(), getContainerTemperature(), getContainerCurrency());
            timeController.reset();
            btnSelected();
        }
    }

    @FXML
    private void changeCurrentLanguage(ActionEvent e) {
        String language = getCbLanguages().getSelectionModel().getSelectedItem();
        if (language.equalsIgnoreCase("Español")) {
            Language.setLang(Languages.ES);
        } else {
            Language.setLang(Languages.EN);
        }
        changeLanguage();
    }

    @FXML
    private void onMouseOver(MouseEvent me) {
        setCurrentBtn((Button) me.getSource());
        getCurrentBtn().setBackground(setBgColor("#253c54"));
    }

    private void cbLanguages() {
        getCbLanguages().setItems(FXCollections.observableArrayList(Utilities.showLanguagesList()));
        getCbLanguages().getSelectionModel().select(0);
        ComboBoxController.comboBoxStyling(getCbLanguages(), " 7px");
        ComboBoxController.comboBoxHover(getCbLanguages(), " 7px");
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
        paintSelected(getContainerLongitude(), getBtnLongitude());
        paintSelected(getContainerWeight(), getBtnWeight());
        paintSelected(getContainerTime(), getBtnTime());
    }

    protected void paintSelected(Pane container, Button btn) {
        if (container.isVisible()) btn.setStyle("-fx-background-color: rgb(51, 80, 113);");
        else btn.setStyle("-fx-background-color: #1c2b45;");
    }

    private void changeLanguage() {
        initControllers();
        changeLanguageButtons();
        changeLanguageTitlesAndSubtitles();
        changeLanguageLabels();
    }

    private void changeLanguageTitlesAndSubtitles() {
        getTitle().setText(Language.getTitle("title"));
        if (getContainerCurrency().isVisible()) {
            getSubtitle().setText(Language.getSubTitle("subtitle-currency"));
            getTitleConversor().setText(Language.getTitle("title-currency"));
        } else if (getContainerTemperature().isVisible()) {
            getSubtitle().setText(Language.getSubTitle("subtitle-temperature"));
            getTitleConversor().setText(Language.getTitle("title-temperature"));
        } else if (getContainerWeight().isVisible()) {
            getSubtitle().setText(Language.getSubTitle("subtitle-weight"));
            getTitleConversor().setText(Language.getTitle("title-weight"));
        } else if (getContainerLongitude().isVisible()) {
            getSubtitle().setText(Language.getSubTitle("subtitle-longitude"));
            getTitleConversor().setText(Language.getTitle("title-longitude"));
        } else if (getContainerTime().isVisible()) {
            getSubtitle().setText(Language.getSubTitle("subtitle-time"));
            getTitleConversor().setText(Language.getTitle("title-time"));
        }
    }

    private void changeLanguageButtons() {
        getBtnCurrency().setText(Language.getButton("btn-currency"));
        getBtnTemperature().setText(Language.getButton("btn-temperature"));
        getBtnWeight().setText(Language.getButton("btn-weight"));
        getBtnLongitude().setText(Language.getButton("btn-longitude"));
        getBtnTime().setText(Language.getButton("btn-time"));
        getBtnConvertCurrency().setText(Language.getButton("btn-convert"));
        getBtnConvertTemperature().setText(Language.getButton("btn-convert"));
        getBtnConvertWeight().setText(Language.getButton("btn-convert"));
        getBtnConvertLongitude().setText(Language.getButton("btn-convert"));
        getBtnConvertTime().setText(Language.getButton("btn-convert"));
    }

    private void changeLanguageLabels() {
        getLblInsertValue().setText(Language.getLabel("lbl-insert-value"));
        getLblResult().setText(Language.getLabel("lbl-result"));
        getLblValidationMessage().setText(Language.getLabel("lbl-validation-message"));

    }

    @FXML
    public void onCurrencyTextChanged(KeyEvent e) {
        currencyController.textChangedValidation();
    }

    @FXML
    public void onTemperatureTextChanged(KeyEvent e) {
        temperatureController.textChangedValidation();
    }

    @FXML
    public void onWeightTextChanged(KeyEvent e) {
        weightController.textChangedValidation();
    }

    @FXML
    public void onLongitudeTextChanged(KeyEvent e) {
        longitudeController.textChangedValidation();
    }

    @FXML
    public void onTimeTextChanged(KeyEvent e) {
        timeController.textChangedValidation();
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
    private void convertLongitude(ActionEvent e) {
        longitudeController.conversionRequest();
    }

    @FXML
    private void convertTime(ActionEvent e) {
        timeController.conversionRequest();
    }
}