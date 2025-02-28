package br.com.fiap.game.model;

public class Item {
    private String nome;
    private String descricao;
    private boolean raro;
    private int nivelPoder;

    // Construtor
    public Item(String nome, String descricao, boolean raro, int nivelPoder) {
        this.nome = nome;
        this.descricao = descricao;
        this.raro = raro;
        this.nivelPoder = nivelPoder;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isRaro() {
        return raro;
    }

    public void setRaro(boolean raro) {
        this.raro = raro;
    }

    public int getNivelPoder() {
        return nivelPoder;
    }

    public void setNivelPoder(int nivelPoder) {
        this.nivelPoder = nivelPoder;
    }
}