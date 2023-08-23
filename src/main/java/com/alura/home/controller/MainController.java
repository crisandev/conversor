package com.alura.home.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends Controllers implements Initializable {
    //CONTAINERS

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

//    @Override
//    public void changeSection(ActionEvent e) {
//        setCurrentBtn((Button) e.getSource());
//        if (e.getSource() == getBtnMonedas()) {
//            setContainerVisible(getContainerMonedas(), getContainerTemperatura(), getContainerPeso(), getContainerDistancias(), getContainerTiempo());
//            btnSelected();
//        } else if (e.getSource() == getBtnTemperatura()) {
//            setContainerVisible(getContainerTemperatura(), getContainerMonedas(), getContainerPeso(), getContainerDistancias(), getContainerTiempo());
//            btnSelected();
//        } else if (e.getSource() == getBtnPeso()) {
//            setContainerVisible(getContainerPeso(), getContainerTemperatura(), getContainerMonedas(), getContainerDistancias(), getContainerTiempo());
//            btnSelected();
//        } else if (e.getSource() == getBtnDistancia()) {
//            setContainerVisible(getContainerDistancias(), getContainerPeso(), getContainerTemperatura(), getContainerMonedas(), getContainerTiempo());
//            btnSelected();
//        } else if (e.getSource() == getBtnTiempo()) {
//            setContainerVisible(getContainerTiempo(), getContainerDistancias(), getContainerPeso(), getContainerTemperatura(), getContainerMonedas());
//            btnSelected();
//        }
//    }


//    @Override
//    public void onTextChange(KeyEvent event) {
//        getCurrencyController().textChange(event);
//    }
//
//    protected void paintSelected(Pane container, Button btn) {
//        if (container.isVisible()) btn.setStyle("-fx-background-color: rgb(51, 80, 113);");
//        else btn.setStyle("-fx-background-color: #1c2b45;");
//    }
//
//
//
//    private void setContainerVisible(Pane active, Pane inactive1, Pane inactive2, Pane inactive3, Pane inactive4) {
//        active.setVisible(true);
//        inactive1.setVisible(false);
//        inactive2.setVisible(false);
//        inactive3.setVisible(false);
//        inactive4.setVisible(false);
//    }
//
//
//    private void btnSelected() {
//        paintSelected(getContainerMonedas(), getBtnMonedas());
//        paintSelected(getContainerTemperatura(), getBtnTemperatura());
//        paintSelected(getContainerDistancias(), getBtnDistancia());
//        paintSelected(getContainerPeso(), getBtnPeso());
//        paintSelected(getContainerTiempo(), getBtnTiempo());
//    }
//
//    @Override
//    public void onMouseOver(MouseEvent me) {
//        setCurrentBtn((Button) me.getSource());
//        getCurrentBtn().setBackground(setBgColor(51, 80, 113));
//    }
}