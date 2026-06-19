package com.example.model;

import java.util.Map;

public class Pedido {
    public enum Status{
        EM_PREPARO,
        PRONTO,
        ENTREGUE
    }

    private final Map<Produto, Integer> itens;
    private Status status;

    public Pedido(Map<Produto, Integer> itens, Status status){
        this.itens = itens;
        this.status = status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    

    public Map<Produto, Integer> getItens() {
        return itens;
    }

    public Status getStatus() {
        return status;
    }

    public String listarItensDoPedido() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Produto, Integer> item : itens.entrySet()) {
            sb.append(item.getKey().getNome())
            .append(" - Quantidade: ")
            .append(item.getValue())
            .append("\n");
        }

        sb.append(status);

        return sb.toString();
    }   
}
