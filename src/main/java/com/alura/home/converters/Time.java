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
    @Override
    public List<String> insertComboBoxValues() {
        try {
            String times = TimeAPI.getTimeJSON();
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
            String time = TimeAPI.getTimeJSON();
            if (time.equalsIgnoreCase("")) throw new NullPointerException("Ocurrió un error");

            JSONObject json = new JSONObject(time);
            JSONArray jsonUnits = json.getJSONArray("units");
            for (int i = 0; i < jsonUnits.length(); i++) {
                JSONObject element = jsonUnits.getJSONObject(i);
                if (element.getString("name").equalsIgnoreCase(convertFrom)) {
                    JSONObject conversions = element.getJSONObject("conversions");
                    BigDecimal conversion = BigDecimal.valueOf(conversions.getDouble(convertTo));
                    return amountDouble * conversion.doubleValue();
                }
            }
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
