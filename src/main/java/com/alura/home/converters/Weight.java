package com.alura.home.converters;

import com.alura.home.api.WeightAPI;
import com.alura.home.enums.Languages;
import com.alura.home.interfaces.Converter;
import com.alura.home.language.Language;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.nio.file.NoSuchFileException;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Weight implements Converter {
    private final String errorOccurredText;
    private final String[] fileNotFoundText = new String[2];
    private final WeightAPI weightAPI = new WeightAPI();

    public Weight() {
        this.errorOccurredText = Language.getLang() == Languages.ES ? "Ocurrió un error" : "An error occurred";
        this.fileNotFoundText[0] = Language.getLang() == Languages.ES ? "No existe el archivo" : "No such file";
        this.fileNotFoundText[1] = Language.getLang() == Languages.ES ? "El archivo no fue encontrado el archivo" : "The file was not found";
    }

    @Override
    public List<String> insertComboBoxValues() {

        try {
            String weights = weightAPI.getJSON();
            if (weights.equalsIgnoreCase("")) throw new NullPointerException(errorOccurredText);
            JSONObject json = new JSONObject(weights);
            JSONArray jsonUnits = json.getJSONArray("units");
            return Utilities.showWeightsList(jsonUnits);
        } catch (NullPointerException ex) {
            PopupWindow.errorMessage(ex.getMessage(), "");
        } catch (NoSuchFileException ex) {
            PopupWindow.errorMessage(fileNotFoundText[0], fileNotFoundText[1]);
        } catch (Exception ex) {
            PopupWindow.errorMessage("Error", errorOccurredText);
        }
        return null;
    }

    @Override
    public Double convert(String convertFrom, String convertTo, String amount) {
        double amountDouble = Double.parseDouble(amount);
        if (convertFrom.equalsIgnoreCase(convertTo)) return amountDouble;
        try {
            JSONObject conversions = weightAPI.getConversionJSON(convertFrom, null, null);
            if (conversions.equals("")) throw new NullPointerException(errorOccurredText);
            BigDecimal conversion = BigDecimal.valueOf(conversions.getDouble(convertTo));
            return amountDouble * conversion.doubleValue();
        } catch (NullPointerException ex) {
            PopupWindow.errorMessage(ex.getMessage(), "");
        } catch (NoSuchFileException ex) {
            PopupWindow.errorMessage(fileNotFoundText[0], fileNotFoundText[1]);
        } catch (Exception ex) {
            PopupWindow.errorMessage("Error", errorOccurredText);
        }
        return 0.0;
    }
}
