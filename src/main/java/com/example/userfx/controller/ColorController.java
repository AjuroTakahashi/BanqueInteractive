package com.example.userfx.controller;

import com.example.userfx.model.Color;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ColorController implements Initializable {

    String numberPattern = "^([01]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])$";

    private Color color;
    @FXML
    private TextField textFieldRed;
    @FXML
    private TextField textFieldGreen;
    @FXML
    private TextField textFieldBlue;
    @FXML
    private TextField textFieldHex;

    @FXML
    private Slider sliderRed;
    @FXML
    private Slider sliderGreen;
    @FXML
    private Slider sliderBlue;

    @FXML
    private Pane paneColor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        color = new Color(0,0,0);

        sliderRed.valueProperty().addListener((observable, oldValue, newValue) -> {
            textFieldRed.setText(Integer.toString(newValue.intValue()));
        });

        sliderGreen.valueProperty().addListener((observable, oldValue, newValue) -> {
            textFieldGreen.setText(Integer.toString(newValue.intValue()));
        });

        sliderBlue.valueProperty().addListener((observable, oldValue, newValue) -> {
            textFieldBlue.setText(Integer.toString(newValue.intValue()));
        });

        textFieldRed.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(numberPattern)) {
                if (oldValue.isEmpty() || newValue.isEmpty()) {
                    textFieldRed.setText("0");
                } else {
                    textFieldRed.setText(oldValue);
                }
            } else {
                color.setRed(Integer.parseInt(newValue));
                sliderRed.setValue(Integer.parseInt(newValue));
                textFieldHex.setText(color.getHexValue());
            }
        });

        textFieldGreen.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(numberPattern)) {
                if (oldValue.isEmpty() || newValue.isEmpty()) {
                    textFieldGreen.setText("0");
                } else {
                    textFieldGreen.setText(oldValue);
                }
            } else {
                color.setGreen(Integer.parseInt(newValue));
                sliderGreen.setValue(Integer.parseInt(newValue));
                textFieldHex.setText(color.getHexValue());
            }
        });

        textFieldBlue.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches(numberPattern)) {
                if (oldValue.isEmpty() || newValue.isEmpty()) {
                    textFieldBlue.setText("0");
                } else {
                    textFieldBlue.setText(oldValue);
                }
            } else {
                color.setBlue(Integer.parseInt(newValue));
                sliderBlue.setValue(Integer.parseInt(newValue));
                textFieldHex.setText(color.getHexValue());
            }
        });

        textFieldHex.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                color.setHexValue(newValue);
                textFieldRed.setText(String.valueOf(color.getRed()));
                textFieldGreen.setText(String.valueOf(color.getGreen()));
                textFieldBlue.setText(String.valueOf(color.getBlue()));
                paneColor.setStyle("-fx-background-color: " + color.getHexValue());
            } catch (Exception e) {
                e.getStackTrace();
            }
        });
    }
}