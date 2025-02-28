package br.com.fiap.restaurante.model;

public abstract class Produto { //Classe abstrata (nao é possivel ser instanciada)
    private String nome;
    private String ingredientes;
    private Double preco;

    public Produto() {

    }

    public Produto(String nome, String ingredientes, Double preco) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    //Criando método abtrato que deverá ser
    //implementado pela subclasse
    public abstract String getResumo();
}