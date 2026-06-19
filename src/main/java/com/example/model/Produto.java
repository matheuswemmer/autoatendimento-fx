package com.example.model;

public abstract class Produto {
    
    private String nome;
    private double valor;
    private final int idDoProduto;
    private static int proxId = 1;
    private String descricao;

    protected Produto (String nome, double valor, String descricao){
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.idDoProduto = proxId++;
    }
    

    public String getDetalhes(){
    return ("ID: " + idDoProduto + " " + nome + "\n" +
            "Descrição: " + descricao + "\n" +
            String.format("Valor: R$ %.2f%n", valor));
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

    public String getDescricao() {
        return descricao;
    }


     public void setDescricao(String descricao) {
         this.descricao = descricao;
     }

}
