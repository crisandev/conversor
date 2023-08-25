package com.alura.home.converters;

import com.alura.home.api.TimeAPI;
import com.alura.home.interfaces.Converter;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.nio.file.NoSuchFileException;
import java.util.List;

public class Time implements Converter {
    private final TimeAPI timeAPI = new TimeAPI();

    @Override
    public List<String> insertComboBoxValues() {
        try {
            String times = timeAPI.getJSON();
            if (times.equalsIgnoreCase("")) throw new NullPointerException("Ocurrió un error");
            JSONObject json = new JSONObject(times);
            JSONArray jsonUnits = json.getJSONArray("units");
            return Utilities.showTimeList(jsonUnits);
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
            JSONObject conversions = timeAPI.getConversionJSON(convertFrom, null, null);
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
