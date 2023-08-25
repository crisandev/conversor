package com.alura.home.util;

import com.alura.home.api.WeightAPI;
import com.alura.home.controllers.MainController;
import com.alura.home.enums.Languages;
import com.alura.home.interfaces.ApiJSONFiles;
import com.alura.home.language.Language;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

    public static JSONObject getConversionJSON(String convertFrom, ApiJSONFiles apiJSONFiles) throws Exception {
        String jsonFilesJSON = apiJSONFiles.getJSON();
        JSONObject json = new JSONObject(jsonFilesJSON);
        JSONArray jsonUnits = json.getJSONArray("units");

        for (int i = 0; i < jsonUnits.length(); i++) {
            JSONObject element = jsonUnits.getJSONObject(i);
            if (element.getString("name").equalsIgnoreCase(convertFrom)) {
                return element.getJSONObject("conversions");
            }
        }
        return null;
    }

    public static void reset(ComboBox<String> cb, ComboBox<String> cbChange, TextField input, TextField inputResult, Label validationMessage, String measure) {
        cb.getSelectionModel().select("SELECT A " + measure);
        cbChange.getSelectionModel().select("SELECT A " + measure);
        input.setText(null);
        input.setPromptText("0.0");
        inputResult.setText(null);
        input.setPromptText("0.0");
        validationMessage.setVisible(false);
    }

    public static void showResult(Double result, TextField inputResult) {
        NumberFormat numFormat = NumberFormat.getInstance(Locale.US);
        if (result < 1) {
            numFormat.setMaximumFractionDigits(15);
        } else {
            numFormat.setMaximumFractionDigits(2);
        }
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

    public static List<String> showTimeList(JSONArray jsonArray) throws Exception {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < jsonArray.length(); i++) list.add(jsonArray.getJSONObject(i).getString("name"));
        return list;
    }

    public static List<String> showLongitudesList(JSONArray jsonArray) throws Exception {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < jsonArray.length(); i++) list.add(jsonArray.getJSONObject(i).getString("name"));
        return list;
    }

    public static List<String> showLanguagesList() {
        List<String> list = new LinkedList<>();
        if (Language.getLang() == Languages.ES.name()) {
            list.add("Español");
            list.add("Inglés");
        } else {
            list.add("English");
            list.add("Spanish");
        }
        return list;
    }
}
