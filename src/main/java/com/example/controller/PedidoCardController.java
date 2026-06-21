package com.example.controller;

import java.util.Map;

import com.example.model.Cozinha;
import com.example.model.Pedido;
import com.example.model.Produto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PedidoCardController {

    @FXML private Label lblNumeroPedido;
    @FXML private Label lblStatus;
    @FXML private Label lblItens;
    @FXML private Label lblValorTotal;
    @FXML private Button btnAvancarStatus;

    private Pedido pedido;
    private Runnable onStatusAlterado;

    public void setPedido(Pedido pedido, Runnable onStatusAlterado) {
        this.pedido = pedido;
        this.onStatusAlterado = onStatusAlterado;
        atualizarView();
    }

    @FXML
    private void onAvancarStatus() {
        Cozinha.avancarStatus(pedido);

        if (onStatusAlterado != null) {
            onStatusAlterado.run();
        } else {
            atualizarView();
        }
    }

    private void atualizarView() {
        lblNumeroPedido.setText(String.valueOf(pedido.getIdDoPedido()));
        lblStatus.setText(formatarStatus(pedido.getStatus()));
        lblItens.setText(formatarItens());
        lblValorTotal.setText(String.format("R$ %.2f", pedido.getValorTotal()));

        switch (pedido.getStatus()) {
            case EM_PREPARO -> btnAvancarStatus.setText("Marcar como pronto");
            case PRONTO -> btnAvancarStatus.setText("Marcar como entregue");
            case ENTREGUE -> {
                btnAvancarStatus.setText("Pedido entregue");
                btnAvancarStatus.setDisable(true);
            }
        }
    }

    private String formatarItens() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Produto, Integer> item : pedido.getItens().entrySet()) {
            sb.append(item.getKey().getNome())
                    .append(" - Quantidade: ")
                    .append(item.getValue())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    private String formatarStatus(Pedido.Status status) {
        return switch (status) {
            case EM_PREPARO -> "Em preparo";
            case PRONTO -> "Pronto";
            case ENTREGUE -> "Entregue";
        };
    }
}
