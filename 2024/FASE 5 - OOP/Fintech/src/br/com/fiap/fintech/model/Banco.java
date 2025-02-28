package br.com.fiap.fintech.model;

public class Banco {

    private String usuario;
    private String nome;

    public Banco() {
    }

    public Banco(String usuario, String nome) {
        this.usuario = usuario;
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBanco() {
        return "Banco: " + this.getNome();
    }
}
