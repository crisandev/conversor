package com.alura.home.language;

import com.alura.home.enums.Languages;
import com.alura.home.util.PopupWindow;
import javafx.scene.control.Alert;

public class Language {

    private static Languages lang = Languages.EN;

    public static Languages getLang() {
        return lang;
    }

    public static void setLang(Languages language) {

        if (language == Languages.ES) {
            CurrentLanguageText.setJSONSource(Languages.ES);
            lang = Languages.ES;
        } else {
            CurrentLanguageText.setJSONSource(Languages.EN);
            lang = Languages.EN;
        }
    }


    public static String getTitle(String title) {
        try {
            return CurrentLanguageText.getTitles(title);
        } catch (Exception e) {
            PopupWindow.alertMessage("Text not found", "");
            return null;
        }
    }

    public static String getSubTitle(String subTitle) {
        try {
            return CurrentLanguageText.getSubTitle(subTitle);
        } catch (Exception e) {
            PopupWindow.alertMessage("Text not found", "");
            return null;
        }
    }

    public static String getLabel(String label) {
        try {
            return CurrentLanguageText.getLabels(label);
        } catch (Exception e) {
            PopupWindow.alertMessage("Text not found", "");
            return null;
        }
    }

    public static String getButton(String btn) {
        try {
            return CurrentLanguageText.getButtons(btn);
        } catch (Exception e) {
            PopupWindow.alertMessage("Text not found", "");
            return null;
        }
    }

    public static String getComboBoxPrompt(String promptText) {
        try {
            return CurrentLanguageText.getComboBox(promptText);
        } catch (Exception e) {
            PopupWindow.alertMessage("Text not found", "");
            return null;
        }
    }
}

