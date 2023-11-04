package com.alura.home.api;

import com.alura.home.enums.Languages;
import com.alura.home.interfaces.ApiJSONFiles;
import com.alura.home.language.Language;
import com.alura.home.util.Utilities;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Path;

public class TimeAPI implements ApiJSONFiles {
    private static final String JSON_TIME_URL_EN = Utilities.getPath("time-list-en.json");
//    private static final String JSON_TIME_URL_EN = "src/main/resources/json-files/time-list-en.json";
    private static final String JSON_TIME_URL_ES = Utilities.getPath("time-list-es.json");
//    private static final String JSON_TIME_URL_ES = "src/main/resources/json-files/time-list-es.json";


    @Override
    public String getJSON() throws Exception {
        if (Language.getLang() == Languages.ES) {
            return new String(Files.readAllBytes(Path.of(JSON_TIME_URL_ES)));
        }
        return new String(Files.readAllBytes(Path.of(JSON_TIME_URL_EN)));
    }

    @Override
    public JSONObject getConversionJSON(String convertFrom, String convertTo, String amount) throws Exception {
        return Utilities.getConversionJSON(convertFrom, this);
    }
}
