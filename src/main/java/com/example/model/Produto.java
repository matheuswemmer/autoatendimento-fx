package com.example.model;

import java.util.*;

public class Produto {
    
    private String nome;
    private double valor;
    private final int idDoProduto;
    private static int proxId = 1;
    private ArrayList<String> ingredientes = new ArrayList<>();

    public Produto (String nome, double valor, List<String> ingredientes){
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = new ArrayList<>(ingredientes);
        this.idDoProduto = proxId++;
    }

    public String getNome() {
        return nome;
    }

    public int getIdDoProduto() {
        return idDoProduto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getDetalhes(){
    return ("ID: " + idDoProduto + " " + nome + "\n" +
            "Ingredientes: " + String.join(", ", ingredientes) + "\n" +
            "Valor: R$" + valor + "\n");
    }
    
}
