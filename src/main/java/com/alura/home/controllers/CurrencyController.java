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
//        try {
//            if (mc.getInputCurrency().getText().equalsIgnoreCase("")) throw new NullPointerException();
//            Double.parseDouble(mc.getInputCurrency().getText());
//            mc.getValidationMessageCurrency().setVisible(false);
//            mc.getBtnConvertCurrency().setDisable(false);
//            return true;
//        } catch (NumberFormatException ex) {
//            mc.getValidationMessageCurrency().setVisible(true);
//            mc.getBtnConvertCurrency().setDisable(true);
//            mc.getValidationMessageCurrency().setText("*Invalid input format");
//        } catch (NullPointerException ex) {
//            mc.getValidationMessageCurrency().setVisible(false);
//            mc.getBtnConvertCurrency().setDisable(true);
//        }
//        return false;
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
                NumberFormat numFormat = NumberFormat.getInstance(Locale.US);
                numFormat.setMaximumFractionDigits(2);
                String formatResult = numFormat.format(result);
                mc.getInputCurrencyResult().setText(formatResult);
            } else {
                mc.getInputCurrencyResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            PopupWindow.alertMessage("SELECT A CURRENCY is an incorrect value", ex.getMessage());
        }
    }

}
