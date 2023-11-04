package com.alura.home.api;

import com.alura.home.enums.Languages;
import com.alura.home.interfaces.ApiJSONFiles;
import com.alura.home.language.Language;
import com.alura.home.util.Utilities;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Path;

public class LongitudeAPI implements ApiJSONFiles {

    private static final String JSON_LONGITUDE_URL_EN = Utilities.getPath("longitude-list-en.json");
//    private static final String JSON_LONGITUDE_URL_EN = "src/main/resources/json-files/longitude-list-en.json";
    private static final String JSON_LONGITUDE_URL_ES = Utilities.getPath("longitude-list-es.json");
//    private static final String JSON_LONGITUDE_URL_ES = "src/main/resources/json-files/longitude-list-es.json";


    @Override
    public String getJSON() throws Exception {
        if (Languages.ES == Language.getLang()) {
            return new String(Files.readAllBytes(Path.of(JSON_LONGITUDE_URL_ES)));
        }
        return new String(Files.readAllBytes(Path.of(JSON_LONGITUDE_URL_EN)));
    }

    @Override
    public JSONObject getConversionJSON(String convertFrom, String convertTo, String amount) throws Exception {
        return Utilities.getConversionJSON(convertFrom, this);
    }
}
