package br.com.fiap.fintech.model;

public abstract class FinanceiroMovimento {

    private String usuario;
    private String categoria;
    private double valor;
    private String data;
    private String descricao;

    public FinanceiroMovimento() {
    }

    public FinanceiroMovimento(String usuario, String categoria, double valor, String data, String descricao) {
        this.usuario = usuario;
        this.categoria = categoria;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract String getMovimento();
}
