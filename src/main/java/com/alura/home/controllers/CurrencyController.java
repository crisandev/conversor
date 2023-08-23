package com.alura.home.controllers;

import com.alura.home.converters.Currency;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.interfaces.Converter;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyController {

    Currency currencyConverter = new Currency();
    MainController c;

    public CurrencyController(MainController mainController) {
        this.c = mainController;
    }

    public void init() {
        ComboBoxController.comboBoxInitializing(c.getCbCurrencies(), currencyConverter);
        ComboBoxController.comboBoxInitializing(c.getCbCurrenciesChange(), currencyConverter);
    }


    public void conversionRequest() {
        String[] currentComboBoxFrom = c.getCbCurrencies().getSelectionModel().getSelectedItem().split(" ");
        String[] currentComboBoxTo = c.getCbCurrenciesChange().getSelectionModel().getSelectedItem().split(" ");
        String convertFrom = currentComboBoxFrom[0];
        String convertTo = currentComboBoxTo[0];
        String amount = c.getInputCurrency().getText();

        try {
            if (convertFrom.equalsIgnoreCase("SELECT"))
                throw new IncorrectValueException("Select the origin currency to convert.");
            if (convertTo.equalsIgnoreCase("SELECT"))
                throw new IncorrectValueException("Select the destiny currency to convert.");

            Double result = Double.parseDouble(currencyConverter.convert(convertFrom, convertTo, amount));
            NumberFormat numFormat = NumberFormat.getInstance(Locale.US);
            numFormat.setMaximumFractionDigits(2);
            String formatResult = numFormat.format(result);
            c.getInputCurrencyResult().setText(formatResult);
        } catch (IncorrectValueException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("SELECT A CURRENCY is an incorrect value");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public boolean textChange(KeyEvent event) {
        try {
            if (c.getInputCurrency().getText().equalsIgnoreCase("")) throw new NullPointerException();
            Double.parseDouble(c.getInputCurrency().getText());
            c.getAlertJustNumber().setVisible(false);
            c.getBtnConvertCurrency().setDisable(false);
            return true;
        } catch (NumberFormatException ex) {
            c.getAlertJustNumber().setText("*Invalid input format");
            c.getAlertJustNumber().setVisible(true);
            c.getBtnConvertCurrency().setDisable(true);
            return false;
        } catch (NullPointerException ex) {
            c.getAlertJustNumber().setVisible(true);
            c.getBtnConvertCurrency().setDisable(true);
            return false;
        }
    }


}
