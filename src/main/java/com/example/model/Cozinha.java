package com.example.model;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Pedido.Status;

public class Cozinha {

    private static List<Pedido> pedidos = new ArrayList<>();
    private static List<Pedido> pedidosEntregues = new ArrayList<>();

    public Cozinha(List<Pedido> pedidos){
        Cozinha.pedidos = pedidos;
    };

    public static void enviarParaCozinha(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    public void finalizarPedido(Pedido pedido) {
            pedido.setStatus(Status.ENTREGUE);
            pedidos.remove(pedidos.indexOf(pedido));
            pedidosEntregues.add(pedido);
        }

    public List<Pedido> listarEntregues() {
            return pedidosEntregues;
    }

    public List<Pedido> listarTodos() {
    return pedidos;
    }    
   
}
