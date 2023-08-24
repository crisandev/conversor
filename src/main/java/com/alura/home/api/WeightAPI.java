package com.alura.home.api;

import java.nio.file.Files;
import java.nio.file.Path;

public class WeightAPI {

    private static final String JSON_WEIGHT_URL_EN = "src/main/resources/json-files/weight-list-en.json";
    private static final String JSON_WEIGHT_URL_ES = "src/main/resources/json-files/weight-list-es.json";

    public static String getWeightsJSON() throws Exception {
        return new String(Files.readAllBytes(Path.of(JSON_WEIGHT_URL_EN)));
    }
}
