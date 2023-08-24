package com.alura.home.controllers;

import com.alura.home.converters.Temperature;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.interfaces.ConverterController;
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
        ComboBoxController.comboBoxInitializing(mc.getCbTemperature(), temperatureConverter, "SELECT A SCALE");
        ComboBoxController.comboBoxInitializing(mc.getCbTemperatureChange(), temperatureConverter, "SELECT A SCALE");
        Utilities.showTemperaturesList();
    }

    @Override
    public void reset() {
        mc.getCbTemperature().getSelectionModel().select("SELECT A SCALE");
        mc.getCbTemperatureChange().getSelectionModel().select("SELECT A SCALE");
        mc.getInputTemperature().setText(null);
        mc.getInputTemperature().setPromptText("0.0");
        mc.getInputTemperatureResult().setText(null);
        mc.getInputTemperatureResult().setPromptText("0.0");
        mc.getValidationMessageTemperature().setVisible(false);
    }


    @Override
    public boolean textChangedValidation(KeyEvent e) {
        return Utilities.validateText(mc.getInputTemperature(), mc.getValidationMessageTemperature(), mc.getBtnConvertTemperature());
    }

    @Override
    public void conversionRequest() {
        String convertFrom = mc.getCbTemperature().getSelectionModel().getSelectedItem();
        String convertTo = mc.getCbTemperatureChange().getSelectionModel().getSelectedItem();
        String amount = mc.getInputTemperature().getText();

        try {
            if (convertFrom.contains("SELECT"))
                throw new IncorrectValueException("Select the origin scale to convert.");
            if (convertTo.contains("SELECT")) throw new IncorrectValueException("Select the destiny scale to convert.");
            if (textChangedValidation(null)) {
                Double result = temperatureConverter.convert(convertFrom, convertTo, amount);
                Utilities.showResult(result, mc.getInputTemperatureResult(),2);
            } else {
                mc.getInputTemperatureResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            PopupWindow.alertMessage("SELECT A SCALE is an incorrect value", ex.getMessage());
        }
    }
}
