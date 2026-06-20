package com.example.controller;

import com.example.model.Carrinho;
import com.example.model.Produto;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CarrinhoController {

    @FXML private VBox containerItens;
    @FXML private Label lblValorTotal;

    // guarda qual Node da tela corresponde a qual Controller de item,
    // pra poder remover o card quando a quantidade chegar a zero
    private final Map<Node, CarrinhoItemController> cardsAtivos = new HashMap<>();

    @FXML
    public void initialize() {
        carregarItens();
    }

    private void carregarItens() {
        containerItens.getChildren().clear();
        cardsAtivos.clear();

        for (Produto produto : Carrinho.getInstancia().getMeuCarrinho().keySet()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/CarrinhoItem.fxml"));
                Parent card = loader.load();

                CarrinhoItemController controller = loader.getController();
                controller.setProduto(produto, this::onItemAlterado);

                cardsAtivos.put(card, controller);
                containerItens.getChildren().add(card);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        atualizarValorTotal();
    }

    /** Chamado pelo card filho sempre que um +/- é clicado. */
    private void onItemAlterado() {
        // remove da tela qualquer card cuja quantidade tenha zerado
        cardsAtivos.entrySet().removeIf(entry -> {
            boolean zerado = entry.getValue().foiZerado();
            if (zerado) {
                containerItens.getChildren().remove(entry.getKey());
            }
            return zerado;
        });
        atualizarValorTotal();
    }

    private void atualizarValorTotal() {
        lblValorTotal.setText(String.format("R$ %.2f", Carrinho.getInstancia().getValorTotal()));
    }

    @FXML
    private void onFinalizarPedido() {
        boolean sucesso = Carrinho.getInstancia().finalizarCarrinho();

        Alert alert = new Alert(sucesso ? Alert.AlertType.INFORMATION : Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText(sucesso
                ? "Pedido enviado para a cozinha!"
                : "Seu carrinho está vazio.");
        alert.showAndWait();

        if (sucesso) {
            Stage stage = (Stage) lblValorTotal.getScene().getWindow();
            stage.close();
        }
    }
}
