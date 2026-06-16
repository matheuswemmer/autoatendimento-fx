package com.example.model;


import java.util.*;

public class Carrinho {    

    private final List<Produto> meuCarrinho = new ArrayList<>();

    public void adicionarProduto(Produto produto){
        produto.aumentarQuantidade();
        if (!meuCarrinho.contains(produto)) {
            meuCarrinho.add(produto);        
        }
    }

    public void removerProdutos(Produto produto){
        produto.diminuirQuantidade();
        if (produto.getQuantidade() == 0){ 
        meuCarrinho.remove(produto);
        }
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

    public List<Produto> getMeuCarrinho() {
        return meuCarrinho;
    }

}
