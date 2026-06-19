package com.example.model;

public class Comida extends Produto {
    
    private int calorias;
    private int peso; // em gramas

    public Comida(String nome, double valor, String descricao, int calorias, int peso) {
        super(nome, valor, descricao);
        this.calorias = calorias;
        this.peso = peso;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + "Calorias: " + calorias + " kcal\n";
    }
}
