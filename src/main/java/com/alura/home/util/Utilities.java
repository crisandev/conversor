package com.alura.home.util;

import com.alura.home.api.WeightAPI;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.NoSuchFileException;
import java.text.NumberFormat;
import java.util.*;

public class Utilities {


    public static boolean validateText(TextField input, Label lblMessage, Button btn) {
        try {
            if (input.getText().equalsIgnoreCase("")) throw new NullPointerException();
            Double.parseDouble(input.getText());
            lblMessage.setVisible(false);
            btn.setDisable(false);
            return true;
        } catch (NumberFormatException ex) {
            lblMessage.setVisible(true);
            btn.setDisable(true);
            lblMessage.setText("*Just number values are accepted");
        } catch (NullPointerException ex) {
            lblMessage.setVisible(false);
            btn.setDisable(true);
        }
        return false;
    }

    public static void showResult(Double result, TextField inputResult, int digits) {
        NumberFormat numFormat = NumberFormat.getInstance(Locale.US);
        numFormat.setMaximumFractionDigits(digits);
        String formatResult = numFormat.format(result);
        inputResult.setText(formatResult);
    }

    public static List<String> showCurrenciesList(HashMap<String, String> hashMap) {
        List<String> listCurrencies = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            String formatString = key.toUpperCase() + " - " + hashMap.get(key).toUpperCase();
            listCurrencies.add(formatString);
        }
        listCurrencies.sort(String::compareToIgnoreCase);
        return listCurrencies;
    }

    public static List<String> showTemperaturesList() {
        List<String> list = new LinkedList<>();
        list.add("Fahrenheit");
        list.add("Celsius");
        list.add("Kelvin");
        return list;
    }

    public static List<String> showWeightsList(JSONArray jsonArray) throws Exception {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < jsonArray.length(); i++) list.add(jsonArray.getJSONObject(i).getString("name"));
        list.sort(String::compareToIgnoreCase);
        return list;
    }

    public static List<String> showTimeList(JSONArray jsonArray) throws Exception{
        List<String> list = new LinkedList<>();
        for (int i = 0; i < jsonArray.length(); i++) list.add(jsonArray.getJSONObject(i).getString("name"));
        return list;
    }

    public static List<String> showLongitudesList(JSONArray jsonArray) throws Exception {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < jsonArray.length(); i++) list.add(jsonArray.getJSONObject(i).getString("name"));
        return list;
    }
}
