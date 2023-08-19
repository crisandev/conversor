package com.alura.home.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class MonedasController {

    public Collection insertComboBoxValues() {
        HashMap map = new HashMap();

        try {
            URL url1 = new URL("https://api.getgeoapi.com/v2/currency/list?api_key=16c656e6f9c92710b5876e82963edb7fad9857e8&format=json");
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            StringBuilder info = new StringBuilder();
            Scanner sc = new Scanner(url1.openStream());
            info.append(sc.nextLine());
            sc.close();
            String str = info.substring(15, info.length() - 21);
            var arr = str.split(",");
            for (int i = 0; i < arr.length; i++) {
                var arr2 = arr[i].split(":");
                map.put(arr2[0], arr2[1]);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.getMessage();
        }


        return map.values();
    }

}
