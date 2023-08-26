package com.alura.home.controllers;

public abstract class ConverterController {
    protected String promptText;
    protected String title;
    protected String subtitle;
    protected MainController mc;

    public abstract void init();

    public abstract void reset();

    public abstract boolean textChangedValidation();

    public abstract void conversionRequest();
}
