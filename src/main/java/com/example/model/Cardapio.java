package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private static final List<Produto> produtos = new ArrayList<>();

    static {
        produtos.add(new Comida("Frango P", 12.0, "Porção pequena de frango grelhado", 280, 150));
        produtos.add(new Comida("Frango M", 18.0, "Porção média de frango grelhado", 420, 250));
        produtos.add(new Comida("Frango G", 24.0, "Porção grande de frango grelhado", 580, 350));
        produtos.add(new Comida("Frango GG", 30.0, "Porção extra grande de frango grelhado", 740, 450));

        produtos.add(new Bebida("Coca-Cola", 6.0, "Refrigerante gelado", 350, false));
        produtos.add(new Bebida("Suco de Laranja", 7.0, "Suco natural gelado", 300, false));
        produtos.add(new Bebida("Cerveja Long Neck", 9.0, "Cerveja gelada", 355, true));
    }

    private Cardapio() {}

    public static List<Produto> getProdutos() {
        return produtos;
    }
}