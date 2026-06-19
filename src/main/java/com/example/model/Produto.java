package com.example.model;

public abstract class Produto {
    
    private String nome;
    private double valor;
    private final int idDoProduto;
    private static int proxId = 1;
    private String descricao;
    private int quantidade; 

    protected Produto (String nome, double valor, String descricao){
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.idDoProduto = proxId++;
        this.quantidade = 0;
    }

    public String getDetalhes(){
    return ("ID: " + idDoProduto + " " + nome + "\n" +
            "Descrição: " + descricao + "\n" +
            "Valor: R$" + valor + "\n");
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

    
    public void aumentarQuantidade(){
        this.quantidade++;
    }

    public boolean diminuirQuantidade() {
    if (this.quantidade > 0) {
        this.quantidade--;
        return true;
    }
    return false;
}

    public String getDescricao() {
        return descricao;
    }


     public void setDescricao(String descricao) {
         this.descricao = descricao;
     }

    public int getQuantidade(){
        return this.quantidade;
    }
}
