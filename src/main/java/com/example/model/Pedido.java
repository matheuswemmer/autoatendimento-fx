package com.example.model;

import java.util.*;

public class Pedido {
     public enum Status {
        EM_PREPARO,
        PRONTO,
        ENTREGUE
    }

    private List<Produto> pedidos = new ArrayList<>();
    private final int id;
    private static int proximoId = 1; 
    private Status status; 
    
    public Pedido(Carrinho carrinho){
        this.pedidos = carrinho.getProdutos();     
        this.id = proximoId++;
        this.status = Status.EM_PREPARO;
    }

    public void exibirPedido() {
        System.out.println("Pedido: " + id + " - Status: " + status);
        for (Produto p : pedidos){
            System.out.println(p.getDetalhes());
        }
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public List<Produto> getPedidos() {
        return pedidos;
    }
}
