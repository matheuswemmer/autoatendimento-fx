package com.example.model;


import java.util.*;

public class Carrinho {    

    private final List<Produto> meuCarrinho = new ArrayList<>();

    public void adicionarProduto(Produto produto){
        meuCarrinho.add(produto);
    }

    public void removerProdutos(Produto produto){
        meuCarrinho.remove(produto);
    }

    public double getValorTotal(){
        double valorTotal = 0;
    for (Produto p : meuCarrinho) {
        valorTotal += p.getValor();
        }
        return valorTotal;
    }

    public List<Produto> getProdutos(){
        return meuCarrinho;
    }

    public void exibirProdutos(){
        for (Produto p : meuCarrinho){
            System.out.println(p.getDetalhes());
        }
    }

}
