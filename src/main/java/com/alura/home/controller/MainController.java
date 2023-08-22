package com.alura.home.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    //CONTAINERS
    @FXML
    private Pane containerMonedas;
    @FXML
    private Pane containerTemperatura;
    @FXML
    private Pane containerPeso;
    @FXML
    private Pane containerDistancias;
    @FXML
    private Pane containerTiempo;
    @FXML
    private Pane sidebar;
    @FXML
    private AnchorPane layout;

    @FXML
    private VBox sidebarContainer;

    @FXML
    private Text title;

    @FXML
    private Button currentBtn;
    @FXML
    private Button btnMonedas;

    @FXML
    private Button btnTemperatura;

    @FXML
    private Button btnPeso;

    @FXML
    private Button btnDistancia;

    @FXML
    private Button btnTiempo;


    @FXML
    private Text titleMonedas;

    @FXML
    private Text subtitleMonedas;

    @FXML
    private TextField inputMoneda;

    @FXML
    private TextField inputResultMoneda;

    @FXML
    private ComboBox<String> cbMonedas;

    @FXML
    private ComboBox<String> cbCambioMonedas;

    CurrenciesController monedasController = new CurrenciesController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currencyInitialize();
    }

    private void currencyInitialize(){
        cbMonedas.setItems(FXCollections.observableArrayList(monedasController.insertComboBoxValues()));
        cbMonedas.getSelectionModel().select("SELECT A CURRENCY");
        ComboBoxController.comboBoxStyling(cbMonedas);
        ComboBoxController.comboBoxHover(cbMonedas);

        cbCambioMonedas.setItems(FXCollections.observableArrayList(monedasController.insertComboBoxValues()));
        cbCambioMonedas.getSelectionModel().select("SELECT A CURRENCY");
        ComboBoxController.comboBoxStyling(cbCambioMonedas);
        ComboBoxController.comboBoxHover(cbCambioMonedas);
    }

    @FXML
    private void changeSection(ActionEvent e) {
        currentBtn = (Button) e.getSource();
        if (e.getSource() == btnMonedas) {
            setContainerVisible(containerMonedas, containerTemperatura, containerPeso, containerDistancias, containerTiempo);
            btnSelected();
        } else if (e.getSource() == btnTemperatura) {
            setContainerVisible(containerTemperatura, containerMonedas, containerPeso, containerDistancias, containerTiempo);
            btnSelected();
        } else if (e.getSource() == btnPeso) {
            setContainerVisible(containerPeso, containerTemperatura, containerMonedas, containerDistancias, containerTiempo);
            btnSelected();
        } else if (e.getSource() == btnDistancia) {
            setContainerVisible(containerDistancias, containerPeso, containerTemperatura, containerMonedas, containerTiempo);
            btnSelected();
        } else if (e.getSource() == btnTiempo) {
            setContainerVisible(containerTiempo, containerDistancias, containerPeso, containerTemperatura, containerMonedas);
            btnSelected();
        }
    }


    @FXML
    private void onMouseOver(MouseEvent me) {
        currentBtn = (Button) me.getSource();
        currentBtn.setBackground(setBgColor(51, 80, 113));
    }

    public Background setBgColor(int i, int i1, int i2) {
        return new Background(new BackgroundFill(Color.rgb(i, i1, i2), CornerRadii.EMPTY, Insets.EMPTY));
    }

    public Background setBgColor(String color) {
        return new Background(new BackgroundFill(Color.web(color), CornerRadii.EMPTY, Insets.EMPTY));
    }


    private void setContainerVisible(Pane active, Pane inactive1, Pane inactive2, Pane inactive3, Pane inactive4) {
        active.setVisible(true);
        inactive1.setVisible(false);
        inactive2.setVisible(false);
        inactive3.setVisible(false);
        inactive4.setVisible(false);
    }


    private void btnSelected() {
        paintSelected(containerMonedas, btnMonedas);
        paintSelected(containerTemperatura, btnTemperatura);
        paintSelected(containerDistancias, btnDistancia);
        paintSelected(containerPeso, btnPeso);
        paintSelected(containerTiempo, btnTiempo);
    }

    private void paintSelected(Pane container, Button btn) {
        if (container.isVisible()) btn.setStyle("-fx-background-color: rgb(51, 80, 113);");
        else btn.setStyle("-fx-background-color: #1c2b45;");
    }

}