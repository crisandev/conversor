package com.alura.home.interfaces;

import javafx.scene.input.KeyEvent;

public interface ConverterController {
    void reset();

    void init();

    boolean textChangedValidation(KeyEvent event);

    void conversionRequest();

}
