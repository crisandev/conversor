package com.alura.home.util;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.*;

public class Utilities {

    public static boolean validateText(TextField input, Label lblMessage, Button btn){

        try {
            if (input.getText().equalsIgnoreCase("")) throw new NullPointerException();
            Double.parseDouble(input.getText());
            lblMessage.setVisible(false);
            btn.setDisable(false);
            return true;
        } catch (NumberFormatException ex) {
            lblMessage.setVisible(true);
            btn.setDisable(true);
            lblMessage.setText("*Invalid input format");
        } catch (NullPointerException ex) {
            lblMessage.setVisible(false);
            btn.setDisable(true);
        }
        return false;
    }

    public static List<String> showCountryCurrencies(HashMap<String, String> hashMap) {
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
}
