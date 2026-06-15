package com.example.model;

import java.util.*;

public class Cardapio {

    private final List<Produto> produtosDisponiveis = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtosDisponiveis.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtosDisponiveis.remove(produto);
    }

    public void exibirProdutos() {
        for (Produto p : produtosDisponiveis) {
            System.out.println(p.getDetalhes());
        }
    }

}