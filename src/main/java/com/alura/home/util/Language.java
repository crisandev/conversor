package com.alura.home.util;

import com.alura.home.enums.Languages;

public class Language {

    private static String lang = Languages.EN.name();

    public static String getLang() {
        return lang;
    }


    public static void setLang(String lang) throws Exception {
        if (lang.equalsIgnoreCase(Languages.ES.name())) Language.lang = Languages.ES.name();
        else if (lang.equalsIgnoreCase(Languages.EN.name())) Language.lang = Languages.EN.name();
        else throw new Exception("We can't change to this language");
    }
}

