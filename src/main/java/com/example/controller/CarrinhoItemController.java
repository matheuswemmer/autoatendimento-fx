package com.example.controller;

import com.example.model.Carrinho;
import com.example.model.Produto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CarrinhoItemController {

    @FXML private Label lblNome;
    @FXML private Label lblSubtotal;
    @FXML private Label lblQuantidade;

    private Produto produto;

    /** Chamado pelo Controller pai (tela/popup do Carrinho) ao injetar cada item.
     *  onAlteracao é executado após qualquer +/- pra avisar o pai e ele atualizar o total. */
    private Runnable onAlteracao;

    public void setProduto(Produto produto, Runnable onAlteracao) {
        this.produto = produto;
        this.onAlteracao = onAlteracao;
        atualizarView();
    }

    @FXML
    private void onAdicionar() {
        Carrinho.getInstancia().adicionarProduto(produto);
        atualizarView();
        if (onAlteracao != null) onAlteracao.run();
    }

    @FXML
    private void onRemover() {
        Carrinho.getInstancia().removerProduto(produto);
        atualizarView();
        if (onAlteracao != null) onAlteracao.run();
    }

    private void atualizarView() {
        int quantidade = Carrinho.getInstancia().getQuantidade(produto);
        lblNome.setText(produto.getNome());
        lblQuantidade.setText(String.valueOf(quantidade));
        lblSubtotal.setText(String.format("R$ %.2f", produto.getValor() * quantidade));
    }

    /** True quando a quantidade desse item zerou — o pai usa isso pra remover o card da tela. */
    public boolean foiZerado() {
        return Carrinho.getInstancia().getQuantidade(produto) == 0;
    }
}
