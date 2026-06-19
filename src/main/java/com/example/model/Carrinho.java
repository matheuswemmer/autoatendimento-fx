package com.example.model;


import java.util.*;

public class Carrinho {    

    private final Map<Produto, Integer> meuCarrinho = new HashMap<>();
    private final Cozinha C = new Cozinha(null);

    public void verMeuCarrinho(){
        System.out.println("\n" + "===RESUMO DO PEDIDO===" + "\n");
        for (Map.Entry<Produto, Integer> entry : meuCarrinho.entrySet()){
            Produto p = entry.getKey();
            System.out.println(p.getDetalhes() + "Quantidade: " + entry.getValue() + "\n");
            }
            System.out.println(String.format("Valor total: R$%.2f%n", this.getValorTotal()));
    }

    public boolean finalizarCarrinho(){
        if(meuCarrinho.size() != 0){
            Pedido meuPedido = new Pedido(meuCarrinho, null);
            Cozinha.enviarParaCozinha(meuPedido);
            return true;
        }
        else return false;
    }

    public int getQuantidade(Produto produto){
        return meuCarrinho.getOrDefault(produto, 0);
    }

    public void adicionarProduto(Produto produto){
            meuCarrinho.put(produto, (this.getQuantidade(produto) + 1));
    }   
    
    public boolean removerProduto(Produto produto){
            if(meuCarrinho.getOrDefault(produto, 0) == 0){
                return false;
            }
                meuCarrinho.put(produto, (this.getQuantidade(produto) - 1));
                return true;
        }

    public double getValorTotal(){
        double valorTotal = 0;
        
        for (Map.Entry<Produto, Integer> entry : meuCarrinho.entrySet()){
            Produto p = entry.getKey();
            valorTotal += (p.getValor() * entry.getValue());
            }
        return valorTotal;
    }

    public Set<Produto> getProdutos(){
        Set<Produto> produtos = meuCarrinho.keySet();
        return produtos;
    }

    public Map<Produto, Integer> getMeuCarrinho() {
        return meuCarrinho;
    }

}
