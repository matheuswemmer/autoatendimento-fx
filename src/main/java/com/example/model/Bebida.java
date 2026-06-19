package com.example.model;

public class Bebida extends Produto {
    
    private int volume; // em ml
    private boolean alcoolica;

    public Bebida(String nome, double valor, String descricao, int volume, boolean alcoolica) {
        super(nome, valor, descricao);
        this.volume = volume;
        this.alcoolica = alcoolica;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + "Volume: " + volume + " ml\n" +
               "Alcoólica: " + (alcoolica ? "Sim" : "Não") + "\n";
    }
}
