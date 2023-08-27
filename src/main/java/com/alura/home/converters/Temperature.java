package com.alura.home.converters;

import com.alura.home.enums.Languages;
import com.alura.home.enums.TemperatureConversionTypes;
import com.alura.home.interfaces.Converter;
import com.alura.home.language.Language;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;

import java.util.List;


public class Temperature implements Converter {
    private final String errorOccurredText;
    private final String[] conversionErrorText = new String[2];
    private TemperatureConversionTypes conversionType;

    public Temperature() {
        this.errorOccurredText = Language.getLang() == Languages.ES ? "Ocurrió un error" : "An error occurred";
        this.conversionErrorText[0] = Language.getLang() == Languages.ES ? "Error de tipo de conversion" : "Error conversion type";
        this.conversionErrorText[1] = Language.getLang() == Languages.ES ? "No existe una conversion para este tipo de argumentos" : "There is not conversion for this kind of arguments";
    }

    @Override
    public List<String> insertComboBoxValues() {
        return Utilities.showTemperaturesList();
    }

    @Override
    public Double convert(String convertFrom, String convertTo, String amount) {
        String conversion = (convertFrom + "_to_" + convertTo).toUpperCase();

        try {
            conversionType = TemperatureConversionTypes.valueOf(conversion);
        } catch (IllegalArgumentException ex) {
            PopupWindow.errorMessage(conversionErrorText[0], conversionErrorText[1]);
            return 0.0;
        } catch (Exception ex) {
            PopupWindow.errorMessage("Error", errorOccurredText);
            return 0.0;
        }

        Double amountNum = Double.parseDouble(amount);
        switch (conversionType) {
            case CELSIUS_TO_KELVIN:
                return celsiusToKelvin(amountNum);
            case CELSIUS_TO_FAHRENHEIT:
                return celsiusToFahrenheit(amountNum);
            case FAHRENHEIT_TO_CELSIUS:
                return fahrenheitToCelsius(amountNum);
            case FAHRENHEIT_TO_KELVIN:
                return fahrenheitToKelvin(amountNum);
            case KELVIN_TO_CELSIUS:
                return kelvinToCelsius(amountNum);
            case KELVIN_TO_FAHRENHEIT:
                return kelvinToFahrenheit(amountNum);
            default:
                return amountNum;
        }
    }


    private Double fahrenheitToKelvin(Double fahrenheit) {
        return ((fahrenheit + 459.67) * 5 / 9);
    }

    private Double fahrenheitToCelsius(Double fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    private Double celsiusToFahrenheit(Double celsius) {
        return ((celsius * 9 / 5) + 32);
    }

    private Double celsiusToKelvin(Double celsius) {
        return (celsius + 273.15);
    }

    private Double kelvinToCelsius(Double kelvin) {
        return (kelvin - 273.15);
    }

    private Double kelvinToFahrenheit(Double kelvin) {
        return ((kelvin * 9 / 5) - 459.67);
    }
}



