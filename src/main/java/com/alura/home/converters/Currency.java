package com.alura.home.converters;

import com.alura.home.api.CurrenciesAPI;
import com.alura.home.enums.Languages;
import com.alura.home.interfaces.Converter;
import com.alura.home.language.Language;
import com.alura.home.util.PopupWindow;
import com.alura.home.util.Utilities;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.NoRouteToHostException;
import java.net.UnknownHostException;
import java.util.*;

public class Currency implements Converter {

    private final String errorOccurredText;
    private final String[] connectToInternetText = new String[2];
    private final String[] serverErrorText = new String[2];
    private final HashMap<String, String> currenciesHashMap = new HashMap<>();
    private final CurrenciesAPI currenciesAPI = new CurrenciesAPI();

    public Currency() {
        this.errorOccurredText = Language.getLang() == Languages.ES ? "Ocurrió un error" : "An error occurred";
        this.connectToInternetText[0] = Language.getLang() == Languages.ES ? "Conectate a internet" : "Connect to internet";
        this.connectToInternetText[1] = Language.getLang() == Languages.ES ? "Necesitas conectarte a internet para usar el Convertidor de Monedas" : "You need to connect to internet to use the Currency Converter";
        this.serverErrorText[0] = Language.getLang() == Languages.ES ? "Error de conexión o con la api" : "Connection error or api error";
        this.serverErrorText[1] = Language.getLang() == Languages.ES ? "No pudimos conectar con el servidor" : "We couldn't connect with server";
    }

    @Override
    public List<String> insertComboBoxValues() {
        try {
            String currencies = currenciesAPI.getJSON();
            if (currencies == null) throw new NullPointerException(errorOccurredText);

            JSONObject json = new JSONObject(currencies);
            JSONObject jsonCurrencies = json.getJSONObject("currencies");

            for (Object key : jsonCurrencies.names()) {
                currenciesHashMap.put(key.toString(), jsonCurrencies.getString(key.toString()));
            }
        } catch (UnknownHostException ex) {
            PopupWindow.errorMessage(connectToInternetText[0], connectToInternetText[1]);
        } catch (Exception ex) {
            PopupWindow.errorMessage("Error", errorOccurredText);
        }
        return Utilities.showCurrenciesList(currenciesHashMap);
    }

    @Override
    public Double convert(String convertFrom, String convertTo, String amount) {
        try {
            JSONObject json = currenciesAPI.getConversionJSON(convertFrom, convertTo, amount);
            JSONObject rates = json.getJSONObject("rates");
            JSONObject currencyResult = rates.getJSONObject(convertTo);
            String result = currencyResult.getString("rate_for_amount");
            return Double.parseDouble(result);
        } catch (NoRouteToHostException ex) {
            PopupWindow.errorMessage(serverErrorText[0], serverErrorText[1]);
            return 0.0;
        } catch (JSONException ex) {
            String complement = Language.getLang() == Languages.ES ? " encontrando el resultado" : "finding the result";
            PopupWindow.errorMessage("Error", errorOccurredText + complement);
            return 0.0;
        } catch (Exception ex) {
            PopupWindow.errorMessage("Error", errorOccurredText);
            return 0.0;
        }
    }

}
