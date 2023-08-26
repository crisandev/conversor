package com.alura.home.language;

import com.alura.home.enums.Languages;
import com.alura.home.util.PopupWindow;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;

class CurrentLanguageText {
    private static final String JSON_LANGUAGE_URL_EN = "src/main/java/com/alura/home/language/en.json";
    private static final String JSON_LANGUAGE_URL_ES = "src/main/java/com/alura/home/language/es.json";
    private static JSONObject JSONTexts;
    private static String JSONSource = JSON_LANGUAGE_URL_EN;

    public static void setJSONSource(Languages lang) {
        if (lang == Languages.ES) {
            JSONSource = JSON_LANGUAGE_URL_ES;
        } else {
            JSONSource = JSON_LANGUAGE_URL_EN;
        }
    }

    private static JSONObject getText() throws Exception {
        String jsonPath = new String(Files.readAllBytes(Path.of(JSONSource)));
        return new JSONObject(jsonPath).getJSONObject("text");
    }

    public static String getTitles(String title) throws Exception {
        JSONTexts = getText();
        JSONObject titles = JSONTexts.getJSONObject("titles");
        return titles.getString(title);
    }

    public static String getSubTitle(String subTitle) throws Exception {
        JSONTexts = getText();
        JSONObject subTitles = JSONTexts.getJSONObject("sub-titles");
        return subTitles.getString(subTitle);
    }

    public static String getLabels(String label) throws Exception {
        JSONTexts = getText();
        JSONObject labels = JSONTexts.getJSONObject("labels");
        return labels.getString(label);
    }

    public static String getButtons(String btn) throws Exception {
        JSONTexts = getText();
        JSONObject btns = JSONTexts.getJSONObject("buttons");
        return btns.getString(btn);
    }
    public static String getComboBox(String promptText) throws Exception {
        JSONTexts = getText();
        JSONObject comboBoxs = JSONTexts.getJSONObject("combo-box");
        return comboBoxs.getString(promptText);
    }

}
