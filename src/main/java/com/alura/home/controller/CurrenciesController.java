package com.alura.home.controller;

import com.alura.home.util.Utilities;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class CurrenciesController {


    public List<String> insertComboBoxValues() {
        HashMap<String, String> countriesHashMap = new HashMap<>();
        try {


            URL url = new URL("https://api.getgeoapi.com/v2/currency/list?api_key=16c656e6f9c92710b5876e82963edb7fad9857e8&format=json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            Scanner sc = new Scanner(url.openStream());
            String currencies = sc.nextLine();
            JSONObject jsonObject = new JSONObject(currencies);
            System.out.println(jsonObject.getJSONObject("currencies").names().get(0));
            JSONObject obj = jsonObject.getJSONObject("currencies");


            for (Object key: obj.names()) {
                countriesHashMap.put(key.toString(),obj.getString(key.toString()));
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Utilities.showCountryCurrencies(countriesHashMap);
    }
}
