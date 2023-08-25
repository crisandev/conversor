package com.alura.home.converters;

import com.alura.home.api.WeightAPI;
import com.alura.home.interfaces.Converter;
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
    private final WeightAPI weightAPI = new WeightAPI();

    @Override
    public List<String> insertComboBoxValues() {

        try {
            String weights = weightAPI.getJSON();
            if (weights.equalsIgnoreCase("")) throw new NullPointerException("Ocurrió un error");
            JSONObject json = new JSONObject(weights);
            JSONArray jsonUnits = json.getJSONArray("units");
            return Utilities.showWeightsList(jsonUnits);
        } catch (NullPointerException ex) {
            PopupWindow.errorMessage(ex.getMessage(), "");
        } catch (NoSuchFileException ex) {
            PopupWindow.errorMessage("No such file", "The file was not found");
        } catch (Exception ex) {
            PopupWindow.errorMessage("An error ocurred", "");
        }
        return null;
    }

    @Override
    public Double convert(String convertFrom, String convertTo, String amount) {
        double amountDouble = Double.parseDouble(amount);
        if (convertFrom.equalsIgnoreCase(convertTo)) return amountDouble;
        try {
            JSONObject conversions = weightAPI.getConversionJSON(convertFrom, null, null);
            if (conversions.equals("")) throw new NullPointerException("Ocurrió un error");
            BigDecimal conversion = BigDecimal.valueOf(conversions.getDouble(convertTo));
            return amountDouble * conversion.doubleValue();
        } catch (NullPointerException ex) {
            PopupWindow.errorMessage(ex.getMessage(), "");
        } catch (NoSuchFileException ex) {
            PopupWindow.errorMessage("No such file", "The file was not found");
        } catch (Exception ex) {
            PopupWindow.errorMessage("An error ocurred", "");
        }

        return 0.0;

    }
}
