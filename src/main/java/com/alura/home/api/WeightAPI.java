package com.alura.home.api;

import com.alura.home.interfaces.ApiJSONFiles;
import com.alura.home.util.Utilities;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;

public class WeightAPI implements ApiJSONFiles {

    private static final String JSON_WEIGHT_URL_EN = "src/main/resources/json-files/weight-list-en.json";
    private static final String JSON_WEIGHT_URL_ES = "src/main/resources/json-files/weight-list-es.json";


    @Override
    public String getJSON() throws Exception {
        return new String(Files.readAllBytes(Path.of(JSON_WEIGHT_URL_EN)));
    }

    @Override
    public JSONObject getConversionJSON(String convertFrom, String convertTo, String amount) throws Exception {
        return Utilities.getConversionJSON(convertFrom, this);
    }
}
