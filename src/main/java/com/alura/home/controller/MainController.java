package com.alura.home.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbMonedas.setItems(FXCollections.observableArrayList("Cristian", "Juan"));
        cbMonedas.getSelectionModel().select(0);
//        comboBoxMonedasStyling();
//        comboBoxHover();

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
        paintSelected(containerMonedas,btnMonedas);
        paintSelected(containerTemperatura,btnTemperatura);
        paintSelected(containerDistancias,btnDistancia);
        paintSelected(containerPeso,btnPeso);
        paintSelected(containerTiempo,btnTiempo);
    }
    private void paintSelected(Pane container, Button btn){
        if (container.isVisible()) btn.setStyle("-fx-background-color: rgb(51, 80, 113);");
        else btn.setStyle("-fx-background-color: #1c2b45;");
    }

}
//    public class MainController implements Initializable {
//    Button currentBtn;
//    @FXML
//    private Button btnUno;
//
//    @FXML
//    private Button btnDos;
//
//    @FXML
//    private Button btnTres;
//
//    @FXML
//    private Button btnCuatro;
//
//    @FXML
//    private Button btnCinco;
//
//    @FXML
//    private GridPane bgSection;
//
//    @FXML
//    private ComboBox<String> cbMonedas;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        cbMonedas.setItems(FXCollections.observableArrayList("Cristian", "Juan"));
//        cbMonedas.getSelectionModel().select(0);
//        comboBoxMonedasStyling();
//        comboBoxHover();
//    }
//
//
//    @FXML
//    private void comboBoxMonedasStyling() {
//        cbMonedas.setCellFactory(param -> new ListCell<>() {
//            @Override
//            protected void updateItem(String item, boolean empty) {
//                super.updateItem(item, empty);
//                setText(item);
//                setTextFill(Color.web("#8cb0d4"));
//                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), null, null)));
//                setStyle("-fx-font-size: 18px;");
//                setCursor(Cursor.HAND);
//            }
//        });
//        cbMonedas.setButtonCell(new ListCell<String>() {
//            @Override
//            protected void updateItem(String item, boolean empty) {
//                setText(item);
//                setTextFill(Color.web("#8cb0d4"));
//                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), null, null)));
//                setStyle("-fx-font-size: 18px; -fx-padding: 0px 0px 0px 0px;");
//            }
//        });
//    }
//
//    @FXML
//    private void comboBoxHover() {
//        cbMonedas.setOnMouseEntered(event -> cbMonedas.setButtonCell(new ListCell<String>() {
//            @Override
//            protected void updateItem(String item, boolean empty) {
//                cbMonedas.setStyle("-fx-background-color: #151f35;" + "-fx-border-color: #0a1229;");
//                setText(item);
//                setTextFill(Color.web("#8cb0d4"));
//                setBackground(new Background(new BackgroundFill(Color.web("#151f35"), null, null)));
//                setStyle("-fx-font-size: 18px; -fx-padding: 0px 0px 0px 0px;");
//            }
//        }));
//        cbMonedas.setOnMouseExited(event -> cbMonedas.setButtonCell(new ListCell<String>() {
//            @Override
//            protected void updateItem(String item, boolean empty) {
//                cbMonedas.setStyle("-fx-background-color: #1b2942;" + "-fx-border-color: #0a1229;");
//                setText(item);
//                setTextFill(Color.web("#8cb0d4"));
//                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), null, null)));
//                setStyle("-fx-font-size: 18px; -fx-padding: 0px 0px 0px 0px;");
//            }
//        }));
//
//    }
//
//    @FXML
//    private void handleClick(ActionEvent e) {
//
//        if (e.getSource() == btnUno) {
//            bgSection.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
//        } else if (e.getSource() == btnDos) {
//            bgSection.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
//        } else if (e.getSource() == btnTres) {
//            bgSection.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));
//        } else if (e.getSource() == btnCuatro) {
//            bgSection.setBackground(new Background(new BackgroundFill(Color.VIOLET, CornerRadii.EMPTY, Insets.EMPTY)));
//        } else if (e.getSource() == btnCinco) {
//            bgSection.setBackground(new Background(new BackgroundFill(Color.STEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
//        }
//    }
//
//    @FXML
//    private void onMouseOver(MouseEvent me) {
//        currentBtn = (Button) me.getSource();
//        currentBtn.setBackground(new Background(new BackgroundFill(Color.rgb(51, 80, 113), CornerRadii.EMPTY, Insets.EMPTY)));
//    }
//}