package com.alura.home.controllers;

import com.alura.home.converters.Currency;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.interfaces.ConverterController;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;
import javafx.scene.input.KeyEvent;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyController extends Controller implements ConverterController {

    Currency currencyConverter = new Currency();
    MainController mc;

    public CurrencyController(MainController mainController) {
        this.mc = mainController;
    }

    @Override
    public void init() {
        ComboBoxController.comboBoxInitializing(mc.getCbCurrencies(), currencyConverter, "SELECT A CURRENCY");
        ComboBoxController.comboBoxInitializing(mc.getCbCurrenciesChange(), currencyConverter, "SELECT A CURRENCY");
    }

    @Override
    public void reset() {
        mc.getCbCurrencies().getSelectionModel().select("SELECT A CURRENCY");
        mc.getCbCurrenciesChange().getSelectionModel().select("SELECT A CURRENCY");
        mc.getInputCurrency().setText(null);
        mc.getInputCurrency().setPromptText("0.0");
        mc.getInputCurrencyResult().setText(null);
        mc.getInputCurrencyResult().setPromptText("0.0");
        mc.getValidationMessageCurrency().setVisible(false);
    }

    @Override
    public boolean textChangedValidation(KeyEvent event) {
        return Utilities.validateText(mc.getInputCurrency(), mc.getValidationMessageCurrency(), mc.getBtnConvertCurrency());
    }

    public void conversionRequest() {
        String[] currentComboBoxFrom = mc.getCbCurrencies().getSelectionModel().getSelectedItem().split(" ");
        String[] currentComboBoxTo = mc.getCbCurrenciesChange().getSelectionModel().getSelectedItem().split(" ");
        String convertFrom = currentComboBoxFrom[0];
        String convertTo = currentComboBoxTo[0];
        String amount = mc.getInputCurrency().getText();

        try {
            if (convertFrom.equalsIgnoreCase("SELECT"))
                throw new IncorrectValueException("Select the origin currency to convert.");
            if (convertTo.equalsIgnoreCase("SELECT"))
                throw new IncorrectValueException("Select the destiny currency to convert.");

            if (textChangedValidation(null)) {
                Double result = currencyConverter.convert(convertFrom, convertTo, amount);
                Utilities.showResult(result, mc.getInputCurrencyResult(), 2);
            } else {
                mc.getInputCurrencyResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            PopupWindow.alertMessage("SELECT A CURRENCY is an incorrect value", ex.getMessage());
        }
    }

}
