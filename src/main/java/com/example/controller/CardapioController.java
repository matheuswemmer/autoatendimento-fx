package com.example.controller;

import java.io.IOException;

import com.example.model.Cardapio;
import com.example.model.Produto;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CardapioController {

    @FXML
    private VBox containerProdutos; // container vazio no FXML da tela inicial

    @FXML
    public void initialize() {
        carregarProdutos();
    }

    @FXML
       private void onVerCarrinho() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/Carrinho.fxml"));
            Parent root = loader.load();

            Stage popup = new Stage();
            popup.setTitle("Seu Carrinho");
            popup.initModality(Modality.APPLICATION_MODAL); // bloqueia a tela de trás até fechar
            popup.setScene(new Scene(root));
            popup.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void carregarProdutos() {
        for (Produto produto : Cardapio.getProdutos()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/ProdutoCard.fxml"));
                Parent card = loader.load();

                ProdutoCardController controller = loader.getController();
                controller.setProduto(produto);

                containerProdutos.getChildren().add(card);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
