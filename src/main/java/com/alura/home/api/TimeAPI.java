package com.alura.home.api;

import java.nio.file.Files;
import java.nio.file.Path;

public class TimeAPI {
    private static final String JSON_TIME_URL_EN = "src/main/resources/json-files/time-list-en.json";
    private static final String JSON_TIME_URL_ES = "src/main/resources/json-files/time-list-es.json";

    public static String getTimeJSON() throws Exception {
        return new String(Files.readAllBytes(Path.of(JSON_TIME_URL_EN)));
    }
}
