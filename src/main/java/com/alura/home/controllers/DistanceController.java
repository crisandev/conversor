package com.alura.home.controllers;

import com.alura.home.interfaces.ConverterController;
import javafx.scene.input.KeyEvent;

public class DistanceController extends Controller implements ConverterController {

    private MainController mc;

    public DistanceController(MainController mainController) {
        this.mc = mainController;
    }

    @Override
    public void init() {

    }

    @Override
    public void reset() {

    }

    @Override
    public boolean textChangedValidation(KeyEvent event) {
        return false;
    }

    @Override
    public void conversionRequest() {

    }
}
