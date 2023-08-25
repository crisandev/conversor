package com.alura.home.interfaces;

import java.util.List;

public interface Converter {

    List<String> insertComboBoxValues();
    Double convert(String convertFrom, String convertTo, String amount);



}
