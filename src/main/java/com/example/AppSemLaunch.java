package com.example;

import java.util.*;

public class AppSemLaunch {
    public static void main(String[] args) throws Exception {

        Cardapio cardapio = new Cardapio();

        List<String> ingredientesDaPizza = new ArrayList<>();
        ingredientesDaPizza.add("Queijo");
        ingredientesDaPizza.add("Calabresa");
        ingredientesDaPizza.add("Molho de Tomate");


        Produto Pizza1 = new Produto("Pizza", 129.90 , ingredientesDaPizza);
        cardapio.adicionarProduto(Pizza1);

        Produto Pizza2 = new Produto("Pizza", 70.10, ingredientesDaPizza);
        cardapio.adicionarProduto(Pizza2);


        // cardapio.exibirProdutos();

        Carrinho meuCarrinho = new Carrinho();

        meuCarrinho.adicionarProduto(Pizza1);
        meuCarrinho.adicionarProduto(Pizza2);

        //meuCarrinho.exibirProdutos();
        //System.out.println(meuCarrinho.getValorTotal());

        Pedido novoPedido = new Pedido(meuCarrinho);

        novoPedido.exibirPedido();

        
    }
}
