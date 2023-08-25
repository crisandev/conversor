package com.alura.home.controllers;

import com.alura.home.converters.Longitude;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.interfaces.ConverterController;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;
import javafx.scene.input.KeyEvent;

public class LongitudeController extends Controller implements ConverterController {

    private MainController mc;
    private final Longitude longitudeController = new Longitude();

    public LongitudeController(MainController mainController) {
        this.mc = mainController;
    }

    @Override
    public void init() {
        ComboBoxController.comboBoxInitializing(mc.getCbLongitude(), longitudeController, "SELECT A LONGITUDE");
        ComboBoxController.comboBoxInitializing(mc.getCbLongitudeChange(), longitudeController, "SELECT A LONGITUDE");
    }

    @Override
    public void reset() {
        mc.getCbLongitude().getSelectionModel().select("SELECT A LONGITUDE");
        mc.getCbLongitudeChange().getSelectionModel().select("SELECT A LONGITUDE");
        mc.getInputLongitude().setText(null);
        mc.getInputLongitude().setPromptText("0.0");
        mc.getInputLongitudeResult().setText(null);
        mc.getInputLongitudeResult().setPromptText("0.0");
        mc.getValidationMessageLongitude().setVisible(false);
    }


    @Override
    public boolean textChangedValidation(KeyEvent e) {
        return Utilities.validateText(mc.getInputLongitude(), mc.getValidationMessageLongitude(), mc.getBtnConvertLongitude());
    }

    @Override
    public void conversionRequest() {
        String convertFrom = mc.getCbLongitude().getSelectionModel().getSelectedItem();
        String convertTo = mc.getCbLongitudeChange().getSelectionModel().getSelectedItem();
        String amount = mc.getInputLongitude().getText();

        try {
            if (convertFrom.contains("SELECT"))
                throw new IncorrectValueException("Select the origin longitude to convert.");
            if (convertTo.contains("SELECT"))
                throw new IncorrectValueException("Select the destiny longitude to convert.");
            if (textChangedValidation(null)) {

                Double result = longitudeController.convert(convertFrom, convertTo, amount);
                if (result < 1) {
                    Utilities.showResult(result, mc.getInputLongitudeResult(), 10);
                } else {
                    Utilities.showResult(result, mc.getInputLongitudeResult(), 3);
                }
            } else {
                mc.getInputLongitudeResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            PopupWindow.alertMessage("SELECT A LONGITUDE is an incorrect value", ex.getMessage());
        }
    }
}
