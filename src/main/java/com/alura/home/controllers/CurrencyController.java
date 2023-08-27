package com.alura.home.controllers;

import com.alura.home.converters.Currency;
import com.alura.home.enums.Languages;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.language.Language;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;

public class CurrencyController extends ConverterController {
    private final Currency currencyConverter = new Currency();

    public CurrencyController(MainController mainController) {
        this.mc = mainController;
        this.promptText = Language.getComboBoxPrompt("prompt-text-currency");
        this.title = Language.getTitle("title-currency");
        this.subtitle = Language.getSubTitle("subtitle-currency");
    }

    @Override
    public void init() {
        ComboBoxController.comboBoxInitializing(mc.getCbCurrencies(), currencyConverter, promptText);
        ComboBoxController.comboBoxInitializing(mc.getCbCurrenciesChange(), currencyConverter, promptText);
    }

    @Override
    public void reset() {
        Utilities.reset(mc.getCbCurrencies(), mc.getCbCurrenciesChange(), mc.getInputCurrency(), mc.getInputCurrencyResult(), mc.getLblValidationMessage(), promptText);
        mc.getBtnConvertCurrency().setDisable(true);
        mc.getSubtitle().setText(subtitle);
        mc.getTitleConversor().setText(title);
    }

    @Override
    public boolean textChangedValidation() {
        return Utilities.validateText(mc.getInputCurrency(), mc.getLblValidationMessage(), mc.getBtnConvertCurrency());
    }

    @Override
    public void conversionRequest() {
        String currentComboBoxFrom = mc.getCbCurrencies().getSelectionModel().getSelectedItem();
        String currentComboBoxTo = mc.getCbCurrenciesChange().getSelectionModel().getSelectedItem();


        try {
            if (currentComboBoxFrom.equalsIgnoreCase(promptText)) throw new IncorrectValueException("");
            if (currentComboBoxTo.equalsIgnoreCase(promptText))
                throw new IncorrectValueException("Select the destiny currency to convert.");

            String convertFrom = currentComboBoxFrom.split(" ")[0];
            String convertTo = currentComboBoxTo.split(" ")[0];
            String amount = mc.getInputCurrency().getText();

            if (textChangedValidation()) {
                Double result = currencyConverter.convert(convertFrom, convertTo, amount);
                Utilities.showResult(result, mc.getInputCurrencyResult());
            } else {
                mc.getInputCurrencyResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            String incorrectValue = Language.getLang() == Languages.ES ? "is an incorrect value" : "es un valor incorrecto";
            PopupWindow.alertMessage("'" + promptText + "' " + incorrectValue, ex.getMessage());
        }
    }
}
