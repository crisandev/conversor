package com.alura.home.controllers;

import com.alura.home.converters.Weight;
import com.alura.home.enums.Languages;
import com.alura.home.exceptions.IncorrectValueException;
import com.alura.home.language.Language;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;

public class WeightController extends ConverterController {

    private final Weight weightConverter = new Weight();

    public WeightController(MainController mainController) {
        this.mc = mainController;
        this.promptText = Language.getComboBoxPrompt("prompt-text-weight");
        this.title = Language.getTitle("title-weight");
        this.subtitle = Language.getSubTitle("subtitle-weight");
        this.originText = Language.getLang() == Languages.ES ? "Seleccione el peso de origen para convertir." : "Select the origin weight to convert.";
        this.destinyText = Language.getLang() == Languages.ES ? "Seleccione el peso de destino para convertir." : "Select the destiny weight to convert.";
    }

    @Override
    public void init() {
        ComboBoxController.comboBoxInitializing(mc.getCbWeights(), weightConverter, promptText);
        ComboBoxController.comboBoxInitializing(mc.getCbWeightChange(), weightConverter, promptText);
    }

    @Override
    public void reset() {
        Utilities.reset(mc.getCbWeights(), mc.getCbWeightChange(), mc.getInputWeight(), mc.getInputWeightResult(), mc.getLblValidationMessage(), promptText);
        mc.getBtnConvertWeight().setDisable(true);
        mc.getSubtitle().setText(subtitle);
        mc.getTitleConversor().setText(title);
    }


    @Override
    public boolean textChangedValidation() {
        return Utilities.validateText(mc.getInputWeight(), mc.getLblValidationMessage(), mc.getBtnConvertWeight());
    }

    @Override
    public void conversionRequest() {
        String convertFrom = mc.getCbWeights().getSelectionModel().getSelectedItem();
        String convertTo = mc.getCbWeightChange().getSelectionModel().getSelectedItem();
        String amount = mc.getInputWeight().getText();

        try {
            if (convertFrom.equalsIgnoreCase(promptText)) throw new IncorrectValueException(originText);
            if (convertTo.equalsIgnoreCase(promptText)) throw new IncorrectValueException(destinyText);

            if (textChangedValidation()) {
                Double result = weightConverter.convert(convertFrom, convertTo, amount);
                Utilities.showResult(result, mc.getInputWeightResult());
            } else {
                mc.getInputWeightResult().setText("0.0");
            }
        } catch (IncorrectValueException ex) {
            String incorrectValue = Language.getLang() == Languages.ES ? "es un valor incorrecto" : "is an incorrect value";
            PopupWindow.alertMessage("'" + promptText + "' " + incorrectValue, ex.getMessage());
            ;
        }
    }
}
