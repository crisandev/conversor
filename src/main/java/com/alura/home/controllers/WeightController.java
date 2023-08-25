package com.alura.home.controllers;

import com.alura.home.converters.Weight;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.interfaces.ConverterController;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class WeightController extends Controller implements ConverterController {
    private MainController mc;

    private final Weight weightConverter = new Weight();

    public WeightController(MainController mainController) {
        this.mc = mainController;
    }

    @Override
    public void init() {
        ComboBoxController.comboBoxInitializing(mc.getCbWeights(), weightConverter, "SELECT A WEIGHT");
        ComboBoxController.comboBoxInitializing(mc.getCbWeightChange(), weightConverter, "SELECT A WEIGHT");
    }

    @Override
    public void reset() {
        Utilities.reset(mc.getCbWeights(), mc.getCbWeightChange(), mc.getInputWeight(), mc.getInputWeightResult(), mc.getValidationMessageWeight(), "WEIGHT");
    }


    @Override
    public boolean textChangedValidation(KeyEvent event) {
        return Utilities.validateText(mc.getInputWeight(), mc.getValidationMessageWeight(), mc.getBtnConvertWeight());
    }

    @Override
    public void conversionRequest() {
        String convertFrom = mc.getCbWeights().getSelectionModel().getSelectedItem();
        String convertTo = mc.getCbWeightChange().getSelectionModel().getSelectedItem();
        String amount = mc.getInputWeight().getText();

        try {
            if (convertFrom.contains("SELECT"))
                throw new IncorrectValueException("Select the origin weight to convert.");
            if (convertTo.contains("SELECT"))
                throw new IncorrectValueException("Select the destiny weight to convert.");
            if (textChangedValidation(null)) {
                Double result = weightConverter.convert(convertFrom, convertTo, amount);
                Utilities.showResult(result, mc.getInputWeightResult());
            } else {
                mc.getInputWeightResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            PopupWindow.alertMessage("SELECT A WEIGHT is an incorrect value", ex.getMessage());
        }
    }
}
