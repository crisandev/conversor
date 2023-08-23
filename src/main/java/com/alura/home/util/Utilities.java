package com.alura.home.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Utilities {

    public static List<String> showCountryCurrencies(HashMap<String, String> hashMap) {
        List<String> listCurrencies = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            String formatString = key.toUpperCase() + " - " + hashMap.get(key).toUpperCase();
            listCurrencies.add(formatString);
        }
        listCurrencies.sort(String::compareToIgnoreCase);
        return listCurrencies;
    }
}
