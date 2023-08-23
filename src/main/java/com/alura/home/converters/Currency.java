package com.alura.home.converters;

import com.alura.home.api.CurrenciesAPI;
import com.alura.home.interfaces.Converter;
import com.alura.home.util.Utilities;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class Currency implements Converter {

    private HashMap<String, String> currenciesHashMap = new HashMap<>();

    @Override
    public List<String> insertComboBoxValues() {

        try {
            if (CurrenciesAPI.getCurrenciesJSON() == null) throw new NullPointerException("Ocurrió un error");

            JSONObject json = new JSONObject(CurrenciesAPI.getCurrenciesJSON());
            JSONObject jsonCurrencies = json.getJSONObject("currencies");

            for (Object key : jsonCurrencies.names()) {
                currenciesHashMap.put(key.toString(), jsonCurrencies.getString(key.toString()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Utilities.showCountryCurrencies(currenciesHashMap);
    }

    @Override
    public String convert(String convertFrom, String convertTo, String amount) {
        try {
            JSONObject json = new JSONObject(CurrenciesAPI.getConversionJSON(convertFrom, convertTo, amount));
            JSONObject rates =  json.getJSONObject("rates");
            JSONObject currencyResult = rates.getJSONObject(convertTo);
            String result = currencyResult.getString("rate_for_amount");
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "0.0";
        }
    }

}
