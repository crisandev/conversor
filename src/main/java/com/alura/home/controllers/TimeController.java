package com.alura.home.controllers;

import com.alura.home.converters.Time;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.interfaces.ConverterController;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;
import javafx.scene.input.KeyEvent;

public class TimeController extends Controller implements ConverterController {


    private MainController mc;
    private final Time timeController = new Time();

    public TimeController(MainController mainController) {
        this.mc = mainController;
    }

    @Override
    public void init() {
        ComboBoxController.comboBoxInitializing(mc.getCbTimes(), timeController, "SELECT A TIME");
        ComboBoxController.comboBoxInitializing(mc.getCbTimesChange(), timeController, "SELECT A TIME");
    }

    @Override
    public void reset() {
        mc.getCbTimes().getSelectionModel().select("SELECT A TIME");
        mc.getCbTimesChange().getSelectionModel().select("SELECT A TIME");
        mc.getInputTime().setText(null);
        mc.getInputTime().setPromptText("0.0");
        mc.getInputTimeResult().setText(null);
        mc.getInputTimeResult().setPromptText("0.0");
        mc.getValidationMessageTime().setVisible(false);
    }


    @Override
    public boolean textChangedValidation(KeyEvent event) {
        return Utilities.validateText(mc.getInputTime(), mc.getValidationMessageTime(), mc.getBtnConvertTime());
    }

    @Override
    public void conversionRequest() {
        String convertFrom = mc.getCbTimes().getSelectionModel().getSelectedItem();
        String convertTo = mc.getCbTimesChange().getSelectionModel().getSelectedItem();
        String amount = mc.getInputTime().getText();

        try {
            if (convertFrom.contains("SELECT")) throw new IncorrectValueException("Select the origin time to convert.");
            if (convertTo.contains("SELECT")) throw new IncorrectValueException("Select the destiny time to convert.");

            if (textChangedValidation(null)) {
                Double result = timeController.convert(convertFrom, convertTo, amount);

                if (result < 1) {
                    Utilities.showResult(result, mc.getInputTimeResult(), 10);
                } else {
                    Utilities.showResult(result, mc.getInputTimeResult(), 3);
                }
            } else {
                mc.getInputTimeResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            PopupWindow.alertMessage("SELECT A TIME is an incorrect value", ex.getMessage());
        }
    }
}
