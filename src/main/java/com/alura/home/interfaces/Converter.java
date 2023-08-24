package com.alura.home.interfaces;

import java.util.List;

public interface Converter {

    public List<String> insertComboBoxValues();
    public Double convert(String convertFrom, String convertTo, String amount);



}
