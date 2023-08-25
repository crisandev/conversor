package com.alura.home.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class LongitudeAPI {

    private static final String JSON_LONGITUDE_URL_EN = "src/main/resources/json-files/longitude-list-en.json";
    private static final String JSON_LONGITUDE_URL_ES = "src/main/resources/json-files/longitude-list-es.json";

    public static String getLongitudesJSON() throws Exception {
        return new String(Files.readAllBytes(Path.of(JSON_LONGITUDE_URL_EN)));
    }

    public static JSONObject getConversionJSON(String convertFrom, String convertTo) throws Exception {
        String longitudes = getLongitudesJSON();
        JSONObject json = new JSONObject(longitudes);
        JSONArray jsonUnits = json.getJSONArray("units");

        for (int i = 0; i < jsonUnits.length(); i++) {
            JSONObject element = jsonUnits.getJSONObject(i);
            if (element.getString("name").equalsIgnoreCase(convertFrom)) {
                return element.getJSONObject("conversions");
            }
        }
        return null;
    }
}
