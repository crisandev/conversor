package com.alura.home.controllers;

import com.alura.home.converters.Temperature;
import com.alura.home.enums.Languages;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.language.Language;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;

public class TemperatureController extends ConverterController {

    private final Temperature temperatureConverter = new Temperature();

    public TemperatureController(MainController mainController) {
        this.mc = mainController;
        this.promptText = Language.getComboBoxPrompt("prompt-text-temperature");
        this.title = Language.getTitle("title-temperature");
        this.subtitle = Language.getSubTitle("subtitle-temperature");
        this.originText = Language.getLang() == Languages.ES ? "Seleccione la escala de origen para convertir." : "Select the origin scale to convert.";
        this.destinyText = Language.getLang() == Languages.ES ? "Seleccione la escala de destino para convertir." : "Select the destiny scale to convert.";
    }

    @Override
    public void init() {
        ComboBoxController.comboBoxInitializing(mc.getCbTemperature(), temperatureConverter, promptText);
        ComboBoxController.comboBoxInitializing(mc.getCbTemperatureChange(), temperatureConverter, promptText);
    }

    @Override
    public void reset() {
        Utilities.reset(mc.getCbTemperature(), mc.getCbTemperatureChange(), mc.getInputTemperature(), mc.getInputTemperatureResult(), mc.getLblValidationMessage(), promptText);
        mc.getBtnConvertTemperature().setDisable(true);
        mc.getSubtitle().setText(subtitle);
        mc.getTitleConversor().setText(title);
    }


    @Override
    public boolean textChangedValidation() {
        return Utilities.validateText(mc.getInputTemperature(), mc.getLblValidationMessage(), mc.getBtnConvertTemperature());
    }

    @Override
    public void conversionRequest() {
        String convertFrom = mc.getCbTemperature().getSelectionModel().getSelectedItem();
        String convertTo = mc.getCbTemperatureChange().getSelectionModel().getSelectedItem();
        String amount = mc.getInputTemperature().getText();

        try {
            if (convertFrom.equalsIgnoreCase(promptText)) throw new IncorrectValueException(originText);
            if (convertTo.equalsIgnoreCase(promptText)) throw new IncorrectValueException(destinyText);

            if (textChangedValidation()) {
                Double result = temperatureConverter.convert(convertFrom, convertTo, amount);
                Utilities.showResult(result, mc.getInputTemperatureResult());
            } else {
                mc.getInputTemperatureResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            String incorrectValue = Language.getLang() == Languages.ES ? "es un valor incorrecto" : "is an incorrect value";
            PopupWindow.alertMessage("'" + promptText + "' " + incorrectValue, ex.getMessage());
        }
    }
}
