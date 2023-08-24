//package com.alura.home.api;
//
//import javafx.scene.layout.Pane;
//import org.json.JSONObject;
//
//import java.io.File;
//import java.io.FileReader;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//
//public class TemperatureAPI {
//    private final static String URL_JSON_TEMPERATURE = "src/main/resources/json-files/temperature.json";
//
//    public static String getConversionJSON(String convertFrom, String convertTo, String amount) throws Exception {
//        FileReader fileReader = new FileReader(URL_JSON_TEMPERATURE);
//        JSONObject jsonObject = new JSONObject(Files.lines(Paths.get(URL_JSON_TEMPERATURE)).collect(Collectors.joining()));
//        System.out.println(jsonObject.getJSONObject("celsius").getString("kelvin"));
//        return "";
//    }
//}
