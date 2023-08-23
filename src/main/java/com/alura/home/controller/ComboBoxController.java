package com.alura.home.controller;

import com.alura.home.converters.Currency;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ComboBoxController {
//    @FXML
//    private Label alertJustNumber;
//    @FXML
//    private Pane containerMonedas;
//    @FXML
//    private Pane containerTemperatura;
//    @FXML
//    private Pane containerPeso;
//    @FXML
//    private Pane containerDistancias;
//    @FXML
//    private Pane containerTiempo;
//    @FXML
//    private Pane sidebar;
//    @FXML
//    private AnchorPane layout;
//    @FXML
//    private VBox sidebarContainer;
//    @FXML
//    private Text title;
//    @FXML
//    private Button currentBtn;
//    @FXML
//    private Button btnMonedas;
//
//    @FXML
//    private Button btnTemperatura;
//
//    @FXML
//    private Button btnPeso;
//
//    @FXML
//    private Button btnDistancia;
//
//    @FXML
//    private Button btnTiempo;
//
//    @FXML
//    private Button btnConvertCurrency;
//
//    @FXML
//    private Text titleMonedas;
//
//    @FXML
//    private Text subtitleMonedas;
//
//    @FXML
//    private TextField inputCurrency;
//
//    @FXML
//    private TextField inputCurrencyResult;
//
//    @FXML
//    private ComboBox<String> cbCurrencies = new ComboBox<>();
//    @FXML
//    private ComboBox<String> cbCurrenciesChange = new ComboBox<>();
//
//    private Currency currencyConverter = new Currency();
//    private CurrencyController currencyController;
//

    @FXML
    public static void comboBoxStyling(ComboBox<String> comboBox) {
        comboBox.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), null, null)));
                setStyle("-fx-font-size: 17px;");
                setCursor(Cursor.HAND);
            }
        });

        comboBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), null, null)));
                setStyle("-fx-font-size: 18px; -fx-padding: 0px 0px 0px 0px;");
                setCursor(Cursor.HAND);
            }
        });
    }

    @FXML
    public static void comboBoxHover(ComboBox<String> comboBox) {
        comboBox.setOnMouseEntered(event -> comboBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                comboBox.setStyle("-fx-background-color: #151f35;" + "-fx-border-color: #0a1229;");
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#151f35"), null, null)));
                setStyle("-fx-font-size: 18px; -fx-padding: 0px 0px 0px 0px;");
            }
        }));

        comboBox.setOnMouseExited(event -> comboBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                comboBox.setStyle("-fx-background-color: #1b2942;" + "-fx-border-color: #0a1229;");
                setText(item);
                setTextFill(Color.web("#8cb0d4"));
                setBackground(new Background(new BackgroundFill(Color.web("#1b2942"), null, null)));
                setStyle("-fx-font-size: 18px; -fx-padding: 0px 0px 0px 0px;");
            }
        }));
    }

}
