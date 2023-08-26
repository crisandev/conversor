package com.alura.home.api;

import com.alura.home.enums.Languages;
import com.alura.home.interfaces.ApiJSONFiles;
import com.alura.home.language.Language;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CurrenciesAPI implements ApiJSONFiles {

    private static final String API = "https://api.getgeoapi.com/v2";
    private static final String API_KEY = "?api_key=16c656e6f9c92710b5876e82963edb7fad9857e8";
    private static final String CONVERSION_REQUEST = "/currency/convert";
    private static final String JSON_CURRENCIES_URL_ES = "src/main/resources/json-files/currencies-countries-es.json";
    private static final String JSON_CURRENCIES_URL_EN = "src/main/resources/json-files/currencies-countries-en.json";

    private static String apiRequest(String str) throws Exception {
        URL url = new URL(str);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        Scanner sc = new Scanner(url.openStream());
        conn.disconnect();
        return sc.nextLine();
    }

    @Override
    public String getJSON() throws Exception {
        if (Language.getLang() == Languages.ES) {
            return new String(Files.readAllBytes(Path.of(JSON_CURRENCIES_URL_ES)));
        }
        return new String(Files.readAllBytes(Path.of(JSON_CURRENCIES_URL_EN)));
    }

    @Override
    public JSONObject getConversionJSON(String convertFrom, String convertTo, String amount) throws Exception {
        String converionURL = API + CONVERSION_REQUEST + API_KEY + "&from=" + convertFrom + "&to=" + convertTo + "&amount=" + amount + "&format=json";
        return new JSONObject(apiRequest(converionURL));
    }


}
