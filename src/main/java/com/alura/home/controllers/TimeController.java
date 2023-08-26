package com.alura.home.controllers;

import com.alura.home.converters.Time;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.interfaces.ConverterController;
import com.alura.home.language.Language;
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
        ComboBoxController.comboBoxInitializing(mc.getCbTimes(), timeController, Language.getComboBoxPrompt("prompt-text-time"));
        ComboBoxController.comboBoxInitializing(mc.getCbTimesChange(), timeController, Language.getComboBoxPrompt("prompt-text-time"));
    }

    @Override
    public void reset() {
        Utilities.reset(mc.getCbTimes(), mc.getCbTimesChange(), mc.getInputTime(), mc.getInputTimeResult(), mc.getLblValidationMessage(), "time");
        mc.getBtnConvertTime().setDisable(true);
        mc.getSubtitle().setText(Language.getSubTitle("subtitle-time"));
        mc.getTitleConversor().setText(Language.getTitle("title-time"));
    }


    @Override
    public boolean textChangedValidation(KeyEvent event) {
        return Utilities.validateText(mc.getInputTime(), mc.getLblValidationMessage(), mc.getBtnConvertTime());

    }

    @Override
    public void conversionRequest() {
        String convertFrom = mc.getCbTimes().getSelectionModel().getSelectedItem();
        String convertTo = mc.getCbTimesChange().getSelectionModel().getSelectedItem();
        String amount = mc.getInputTime().getText();

        try {
            if (convertFrom.toUpperCase().contains("SELECT"))
                throw new IncorrectValueException("Select the origin time to convert.");
            if (convertTo.toUpperCase().contains("SELECT"))
                throw new IncorrectValueException("Select the destiny time to convert.");

            if (textChangedValidation(null)) {
                Double result = timeController.convert(convertFrom, convertTo, amount);
                Utilities.showResult(result, mc.getInputTimeResult());
            } else {
                mc.getInputTimeResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            PopupWindow.alertMessage("'Select a time' is an incorrect value", ex.getMessage());
        }
    }
}
