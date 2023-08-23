package com.alura.home.controller;

import com.alura.home.converters.Currency;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrencyController extends Controllers {



    public void CurrencyController(ComboBox<String> cbCurrencies, ComboBox<String> cbCurrenciesChange, Currency currencyConverter) {
        comboBoxInitializing(cbCurrencies, currencyConverter);
        comboBoxInitializing(cbCurrenciesChange, currencyConverter);
    }

    @Override
    public void onMouseOver(MouseEvent me) {
    }

//    @Override
//    public void changeSection(ActionEvent e) {
//
//    }

//    public void textChange(KeyEvent event) {
//        String[] currentComboBoxFrom = cb1.getSelectionModel().getSelectedItem().split(" ");
//        String[] currentComboBoxTo = cb2.getSelectionModel().getSelectedItem().split(" ");
//        String convertFrom = currentComboBoxFrom[0];
//        String convertTo = currentComboBoxTo[0];
//        try {
//            if (!inputCurrency.getText().equalsIgnoreCase("")) Integer.parseInt(inputCurrency.getText());
//            alertJustNumber.setVisible(false);
//            btnConvertCurrency.setDisable(false);
//        } catch (NumberFormatException ex) {
//            alertJustNumber.setText("*Invalid input format");
//            alertJustNumber.setVisible(true);
//            btnConvertCurrency.setDisable(true);
//        }
//    }


}
