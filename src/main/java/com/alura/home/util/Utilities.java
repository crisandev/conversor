package com.alura.home.util;

import java.util.*;

public class Utilities {

    public static List<String> showCountryCurrencies(HashMap<String, String> hashMap) {
        List<String> newValues = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            String formatString = hashMap.get(key).toUpperCase() + "(" + key.toUpperCase() + ")";
            newValues.add(formatString);
        }
        newValues.sort(String::compareToIgnoreCase);
        return newValues;
    }

}
