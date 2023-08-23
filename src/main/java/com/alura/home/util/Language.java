package com.alura.home.util;

public class Language {

    public enum languages {ES, EN}

    private static String lang = languages.EN.name();

    public static String getLang() {
        return lang;
    }


    public static void setLang(String lang) throws Exception {
        if (lang.equalsIgnoreCase(languages.ES.name())) Language.lang = languages.ES.name();
        else if (lang.equalsIgnoreCase(languages.EN.name())) Language.lang = languages.EN.name();
        else throw new Exception("We can't change to this language");
    }
}

