package com.example.model;

import java.util.*;

public class GerenciadorDePedidos {

    private final Map<Integer, Pedido> pedidos = new HashMap<>();
    private final List<Pedido> pedidosEntregues = new ArrayList<>();

    public void adicionarPedido(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
    }

    public void setStatus(int idDoPedido, Pedido.Status status) {
        Pedido pedido = pedidos.get(idDoPedido);
        if (pedido != null) {
            pedido.setStatus(status);
            if (status == Pedido.Status.ENTREGUE) {
                pedidosEntregues.add(pedido);
                pedidos.remove(idDoPedido);
            }
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    public void exibirPedidosEntregues(){
        for (Pedido p : pedidosEntregues){
            p.exibirPedido();
        }
    }

    public void exibirPedidos(){
        for (Pedido p : pedidos.values()){
            p.exibirPedido();
        }
    }


}