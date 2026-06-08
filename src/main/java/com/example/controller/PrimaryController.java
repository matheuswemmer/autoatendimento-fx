package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToCozinha() throws IOException {
        App.setRoot("cozinha");
    }
    @FXML
    private void switchToClientes() throws IOException {
        App.setRoot("cozinha");
    }
}
