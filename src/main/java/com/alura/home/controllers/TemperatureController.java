package com.alura.home.controllers;

import com.alura.home.converters.Temperature;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.interfaces.ConverterController;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;
import javafx.scene.input.KeyEvent;

import java.text.NumberFormat;
import java.util.Locale;

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
    public boolean textChangedValidation(KeyEvent event) {
        return Utilities.validateText(mc.getInputTemperature(), mc.getValidationMessageTemperature(), mc.getBtnConvertTemperature());
//        try {
//            if (mc.getInputTemperature().getText().equalsIgnoreCase("")) throw new NullPointerException();
//            Double.parseDouble(mc.getInputTemperature().getText());
//            mc.getValidationMessageTemperature().setVisible(false);
//            mc.getBtnConvertTemperature().setDisable(false);
//            return true;
//        } catch (NumberFormatException ex) {
//            mc.getValidationMessageTemperature().setVisible(true);
//            mc.getBtnConvertTemperature().setDisable(true);
//            mc.getValidationMessageTemperature().setText("*Just number values are accepted");
//        } catch (NullPointerException ex) {
//            mc.getValidationMessageTemperature().setVisible(false);
//            mc.getBtnConvertTemperature().setDisable(true);
//        }
//        return false;
    }

    @Override
    public void conversionRequest() {
        String convertFrom = mc.getCbTemperature().getSelectionModel().getSelectedItem();
        String convertTo = mc.getCbTemperatureChange().getSelectionModel().getSelectedItem();
        String amount = mc.getInputTemperature().getText();

        try {
            if (convertFrom.contains("SELECT"))
                throw new IncorrectValueException("Select the origin scale to convert.");
            if (convertTo.contains("SELECT"))
                throw new IncorrectValueException("Select the destiny scale to convert.");

            Double result = temperatureConverter.convert(convertFrom, convertTo, amount);
            NumberFormat numFormat = NumberFormat.getInstance(Locale.US);
            numFormat.setMaximumFractionDigits(2);
            String formatResult = numFormat.format(result);
            mc.getInputTemperatureResult().setText(formatResult);
        } catch (IncorrectValueException ex) {
            PopupWindow.alertMessage("SELECT A CURRENCY is an incorrect value", ex.getMessage());
        }
    }
}
