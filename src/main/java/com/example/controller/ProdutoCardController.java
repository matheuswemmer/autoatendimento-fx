package com.example.controller;

import com.example.model.Carrinho;
import com.example.model.Produto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ProdutoCardController {

    @FXML private Label lblNome;
    @FXML private Label lblDetalhes;
    @FXML private Label lblValor;
    @FXML private Label lblQuantidade;

    private Produto produto;

    /**
     * Chamado pelo Controller pai (tela do Cardápio) logo após carregar este FXML,
     * pra injetar qual produto este card específico representa.
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
        atualizarView();
    }

    @FXML
    private void onAdicionar() {
        Carrinho.getInstancia().adicionarProduto(produto);
        atualizarQuantidade();
    }

    @FXML
    private void onRemover() {
        Carrinho.getInstancia().removerProduto(produto);
        atualizarQuantidade();
    }

    private void atualizarView() {
        lblNome.setText(produto.getNome());
        lblDetalhes.setText(produto.getDetalhes());
        lblValor.setText(String.format("R$ %.2f", produto.getValor()));
        atualizarQuantidade();
    }

    private void atualizarQuantidade() {
        int qtd = Carrinho.getInstancia().getQuantidade(produto);
        lblQuantidade.setText(String.valueOf(qtd));
    }
}
