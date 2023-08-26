package com.alura.home.controllers;

import com.alura.home.converters.Currency;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.interfaces.ConverterController;
import com.alura.home.language.Language;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;
import javafx.scene.input.KeyEvent;

public class CurrencyController extends Controller implements ConverterController {

    private Currency currencyConverter = new Currency();
    private MainController mc;

    public CurrencyController(MainController mainController) {
        this.mc = mainController;
    }

    @Override
    public void init() {
        ComboBoxController.comboBoxInitializing(mc.getCbCurrencies(), currencyConverter, Language.getComboBoxPrompt("prompt-text-currency"));
        ComboBoxController.comboBoxInitializing(mc.getCbCurrenciesChange(), currencyConverter, Language.getComboBoxPrompt("prompt-text-currency"));
    }

    @Override
    public void reset() {
        Utilities.reset(mc.getCbCurrencies(), mc.getCbCurrenciesChange(), mc.getInputCurrency(), mc.getInputCurrencyResult(), mc.getLblValidationMessage(), "currency");
        mc.getBtnConvertCurrency().setDisable(true);
        mc.getSubtitle().setText(Language.getSubTitle("subtitle-currency"));
        mc.getTitleConversor().setText(Language.getTitle("title-currency"));
    }

    @Override
    public boolean textChangedValidation(KeyEvent event) {
        return Utilities.validateText(mc.getInputCurrency(), mc.getLblValidationMessage(), mc.getBtnConvertCurrency());
    }

    @Override
    public void conversionRequest() {
        String[] currentComboBoxFrom = mc.getCbCurrencies().getSelectionModel().getSelectedItem().split(" ");
        String[] currentComboBoxTo = mc.getCbCurrenciesChange().getSelectionModel().getSelectedItem().split(" ");
        String convertFrom = currentComboBoxFrom[0];
        String convertTo = currentComboBoxTo[0];
        String amount = mc.getInputCurrency().getText();

        try {
            if (convertFrom.toUpperCase().contains("SELECT"))
                throw new IncorrectValueException("Select the origin currency to convert.");
            if (convertTo.toUpperCase().contains("SELECT"))
                throw new IncorrectValueException("Select the destiny currency to convert.");

            if (textChangedValidation(null)) {
                Double result = currencyConverter.convert(convertFrom, convertTo, amount);
                Utilities.showResult(result, mc.getInputCurrencyResult());
            } else {
                mc.getInputCurrencyResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            PopupWindow.alertMessage("'Select a currency' is an incorrect value", ex.getMessage());
        }
    }
}
