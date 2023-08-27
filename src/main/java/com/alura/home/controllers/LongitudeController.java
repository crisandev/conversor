package com.alura.home.controllers;

import com.alura.home.converters.Longitude;
import com.alura.home.enums.Languages;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.language.Language;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;

public class LongitudeController extends ConverterController {
    private final Longitude longitudeController = new Longitude();

    public LongitudeController(MainController mainController) {
        this.mc = mainController;
        this.promptText = Language.getComboBoxPrompt("prompt-text-longitude");
        this.title = Language.getTitle("title-longitude");
        this.subtitle = Language.getSubTitle("subtitle-longitude");
        this.originText = Language.getLang() == Languages.ES ? "Seleccione la longitud de origen para convertir." : "Select the origin longitude convert.";
        this.destinyText = Language.getLang() == Languages.ES ? "Seleccione la longitud de destino para convertir." : "Select the destiny longitude to convert.";
    }

    @Override
    public void init() {
        ComboBoxController.comboBoxInitializing(mc.getCbLongitude(), longitudeController, promptText);
        ComboBoxController.comboBoxInitializing(mc.getCbLongitudeChange(), longitudeController, promptText);
    }

    @Override
    public void reset() {
        Utilities.reset(mc.getCbLongitude(), mc.getCbLongitudeChange(), mc.getInputLongitude(), mc.getInputLongitudeResult(), mc.getLblValidationMessage(), promptText);
        mc.getBtnConvertLongitude().setDisable(true);
        mc.getSubtitle().setText(subtitle);
        mc.getTitleConversor().setText(title);
    }


    @Override
    public boolean textChangedValidation() {
        return Utilities.validateText(mc.getInputLongitude(), mc.getLblValidationMessage(), mc.getBtnConvertLongitude());
    }

    @Override
    public void conversionRequest() {
        String convertFrom = mc.getCbLongitude().getSelectionModel().getSelectedItem();
        String convertTo = mc.getCbLongitudeChange().getSelectionModel().getSelectedItem();
        String amount = mc.getInputLongitude().getText();

        try {
            if (convertFrom.equalsIgnoreCase(promptText)) throw new IncorrectValueException(originText);
            if (convertTo.equalsIgnoreCase(promptText)) throw new IncorrectValueException(destinyText);

            if (textChangedValidation()) {
                Double result = longitudeController.convert(convertFrom, convertTo, amount);
                Utilities.showResult(result, mc.getInputLongitudeResult());
            } else {
                mc.getInputLongitudeResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            String incorrectValue = Language.getLang() == Languages.ES ? "es un valor incorrecto" : "is an incorrect value";
            PopupWindow.alertMessage("'" + promptText + "' " + incorrectValue, ex.getMessage());
        }
    }
}
