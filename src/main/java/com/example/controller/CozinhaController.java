package com.example.controller;

import java.io.IOException;

import com.example.model.Carrinho;
import com.example.model.Cozinha;
import com.example.model.Pedido;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CozinhaController {

    @FXML private VBox containerPedidos;
    @FXML private Button btnNovoPedido;

    @FXML
    public void initialize() {
        carregarPedidos();
    }

    private void carregarPedidos() {
        containerPedidos.getChildren().clear();
        btnNovoPedido.setDisable(!Cozinha.listarTodos().isEmpty());

        // Recarrega a tela separando os pedidos em andamento dos pedidos entregues.
        if (Cozinha.listarTodos().isEmpty() && Cozinha.listarEntregues().isEmpty()) {
            Label vazio = new Label("Nenhum pedido em preparo.");
            vazio.getStyleClass().add("pedido-label");
            containerPedidos.getChildren().add(vazio);
            return;
        }

        if (!Cozinha.listarTodos().isEmpty()) {
            adicionarTitulo("Pedidos em andamento");
        }

        for (Pedido pedido : Cozinha.listarTodos()) {
            adicionarPedido(pedido);
        }

        if (!Cozinha.listarEntregues().isEmpty()) {
            adicionarTitulo("Pedidos entregues");
        }

        for (Pedido pedido : Cozinha.listarEntregues()) {
            adicionarPedido(pedido);
        }
    }

    private void adicionarTitulo(String texto) {
        Label titulo = new Label(texto);
        titulo.getStyleClass().add("pedido-subtitulo");
        containerPedidos.getChildren().add(titulo);
    }

    private void adicionarPedido(Pedido pedido) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/PedidoCard.fxml"));
            Parent card = loader.load();

            PedidoCardController controller = loader.getController();
            controller.setPedido(pedido, this::carregarPedidos);

            containerPedidos.getChildren().add(card);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onNovoPedido() {
        try {
            Carrinho.getInstancia().getMeuCarrinho().clear();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/views/Cardapio.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) containerPedidos.getScene().getWindow();
            stage.setTitle("Cardapio");
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
