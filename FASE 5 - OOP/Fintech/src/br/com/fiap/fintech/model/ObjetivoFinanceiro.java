package br.com.fiap.fintech.model;

public class ObjetivoFinanceiro {

    private String usuario;
    private String nome;
    private String descricao;
    private double valor;
    private String data;

    public ObjetivoFinanceiro() {
    }

    public ObjetivoFinanceiro(String usuario, String nome, String descricao, double valor, String data) {
        this.usuario = usuario;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObjetivoFinanceiro() {
        return "Nome do objetivo: " + this.getNome()
                + " Descrição: " + this.getDescricao()
                + " Data: " + this.getData()
                + " Valor: " + this.getValor();
    }
}
