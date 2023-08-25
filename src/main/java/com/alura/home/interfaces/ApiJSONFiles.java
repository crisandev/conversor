package com.alura.home.interfaces;

import org.json.JSONObject;

public interface ApiJSONFiles {
    String getJSON() throws Exception;

    JSONObject getConversionJSON(String convertFrom, String convertTo, String amount) throws Exception;
}
