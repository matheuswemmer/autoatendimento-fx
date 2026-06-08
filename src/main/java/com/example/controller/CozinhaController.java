package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class CozinhaController {

    @FXML
    private void registerNewProduct() throws IOException {
        System.out.println("Olá Mundo");;
    }

    @FXML
    private void seeMenuProducts() throws IOException {
        System.out.println("Cardápio");;
    }
    @FXML

    private void swithToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
}
