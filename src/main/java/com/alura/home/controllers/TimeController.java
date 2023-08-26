package com.alura.home.controllers;

import com.alura.home.converters.Time;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.language.Language;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;

public class TimeController extends ConverterController {

    private final Time timeController = new Time();

    public TimeController(MainController mainController) {
        this.mc = mainController;
        this.promptText = Language.getComboBoxPrompt("prompt-text-time");
        this.title = Language.getTitle("title-time");
        this.subtitle = Language.getSubTitle("subtitle-time");
    }

    @Override
    public void init() {
        ComboBoxController.comboBoxInitializing(mc.getCbTimes(), timeController, promptText);
        ComboBoxController.comboBoxInitializing(mc.getCbTimesChange(), timeController, promptText);
    }

    @Override
    public void reset() {
        Utilities.reset(mc.getCbTimes(), mc.getCbTimesChange(), mc.getInputTime(), mc.getInputTimeResult(), mc.getLblValidationMessage(), Language.getComboBoxPrompt("prompt-text-time"));
        mc.getBtnConvertTime().setDisable(true);
        mc.getSubtitle().setText(title);
        mc.getTitleConversor().setText(subtitle);
    }


    @Override
    public boolean textChangedValidation() {
        return Utilities.validateText(mc.getInputTime(), mc.getLblValidationMessage(), mc.getBtnConvertTime());

    }

    @Override
    public void conversionRequest() {
        String convertFrom = mc.getCbTimes().getSelectionModel().getSelectedItem();
        String convertTo = mc.getCbTimesChange().getSelectionModel().getSelectedItem();
        String amount = mc.getInputTime().getText();

        try {
            if (convertFrom.equalsIgnoreCase(promptText))
                throw new IncorrectValueException("Select the origin time to convert.");
            if (convertTo.equalsIgnoreCase(promptText))
                throw new IncorrectValueException("Select the destiny time to convert.");

            if (textChangedValidation()) {
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
