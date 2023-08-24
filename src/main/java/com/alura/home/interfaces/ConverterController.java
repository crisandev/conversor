package com.alura.home.interfaces;

import com.alura.home.controllers.MainController;
import javafx.scene.input.KeyEvent;

public interface ConverterController {
    void init();

    void reset();

    boolean textChangedValidation(KeyEvent event);

    void conversionRequest();

}
