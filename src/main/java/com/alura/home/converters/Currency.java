package com.alura.home.converters;

import com.alura.home.api.CurrenciesAPI;
import com.alura.home.interfaces.Converter;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;
import javafx.scene.control.Alert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
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
        } catch (UnknownHostException ex) {
            PopupWindow.errorMessage("Connect to internet.", "You need to connect to internet to use the Currency Converter");
        } catch (Exception ex) {
            PopupWindow.errorMessage("An error occurred", "");
        }
        return Utilities.showCountryCurrencies(currenciesHashMap);
    }

    @Override
    public Double convert(String convertFrom, String convertTo, String amount) {
        try {
            JSONObject json = new JSONObject(CurrenciesAPI.getConversionJSON(convertFrom, convertTo, amount));
            JSONObject rates = json.getJSONObject("rates");
            JSONObject currencyResult = rates.getJSONObject(convertTo);
            String result = currencyResult.getString("rate_for_amount");
            return Double.parseDouble(result);
        } catch (NoRouteToHostException ex) {
            PopupWindow.errorMessage("Connection error or api error", "We couldn't connect with server");
            return 0.0;
        } catch (JSONException ex) {
            PopupWindow.errorMessage("An error occurred.", "An error occurred finding the result.");
            return 0.0;
        }catch (Exception ex) {
            PopupWindow.errorMessage("An error occurred", "");
            return 0.0;
        }
    }

}
