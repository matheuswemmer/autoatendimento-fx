package com.example.model;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Pedido.Status;

public class Cozinha {

    private static List<Pedido> pedidos = new ArrayList<>();
    private static List<Pedido> pedidosEntregues = new ArrayList<>();

    private Cozinha() {} // ninguém pode instanciar

    public static void enviarParaCozinha(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    // Controla o fluxo do pedido: em preparo -> pronto -> entregue.
    public static void avancarStatus(Pedido pedido) {
        switch (pedido.getStatus()) {
            case EM_PREPARO -> pedido.setStatus(Status.PRONTO);
            case PRONTO -> {
                pedido.setStatus(Status.ENTREGUE);
                pedidos.remove(pedido);
                pedidosEntregues.add(pedido);
            }
            case ENTREGUE -> { /* nada a fazer */ }
        }
    }

    public static List<Pedido> listarEntregues() {
            return pedidosEntregues;
    }

    public static List<Pedido> listarTodos() {
    return pedidos;
    }    
   
}
