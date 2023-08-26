package com.alura.home.controllers;

import com.alura.home.converters.Temperature;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.interfaces.ConverterController;
import com.alura.home.language.Language;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;
import javafx.scene.input.KeyEvent;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Queue;

public class TemperatureController extends Controller implements ConverterController {
    private final Temperature temperatureConverter = new Temperature();
    private MainController mc;

    public TemperatureController(MainController mainController) {
        this.mc = mainController;
    }

    @Override
    public void init() {
        ComboBoxController.comboBoxInitializing(mc.getCbTemperature(), temperatureConverter, Language.getComboBoxPrompt("prompt-text-temperature"));
        ComboBoxController.comboBoxInitializing(mc.getCbTemperatureChange(), temperatureConverter, Language.getComboBoxPrompt("prompt-text-temperature"));
    }

    @Override
    public void reset() {
        Utilities.reset(mc.getCbTemperature(), mc.getCbTemperatureChange(), mc.getInputTemperature(), mc.getInputTemperatureResult(), mc.getLblValidationMessage(), "scale");
        mc.getBtnConvertTemperature().setDisable(true);
        mc.getSubtitle().setText(Language.getSubTitle("subtitle-temperature"));
        mc.getTitleConversor().setText(Language.getTitle("title-temperature"));
    }


    @Override
    public boolean textChangedValidation(KeyEvent e) {
        return Utilities.validateText(mc.getInputTemperature(), mc.getLblValidationMessage(), mc.getBtnConvertTemperature());
    }

    @Override
    public void conversionRequest() {
        String convertFrom = mc.getCbTemperature().getSelectionModel().getSelectedItem();
        String convertTo = mc.getCbTemperatureChange().getSelectionModel().getSelectedItem();
        String amount = mc.getInputTemperature().getText();

        try {
            if (convertFrom.toUpperCase().contains("SELECT"))
                throw new IncorrectValueException("Select the origin scale to convert.");
            if (convertTo.toUpperCase().contains("SELECT"))
                throw new IncorrectValueException("Select the destiny scale to convert.");

            if (textChangedValidation(null)) {
                Double result = temperatureConverter.convert(convertFrom, convertTo, amount);
                Utilities.showResult(result, mc.getInputTemperatureResult());
            } else {
                mc.getInputTemperatureResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            PopupWindow.alertMessage("'Select a scale' is an incorrect value", ex.getMessage());
        }
    }
}
