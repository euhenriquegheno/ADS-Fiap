package br.com.fiap.fintech.model;

public class Investimento {

    private String usuario;
    private String tipo;
    private String banco;
    private String nome;
    private double valor;
    private String dataInvestimento;
    private String dataVencimento;

    public Investimento() {
    }

    public Investimento(String usuario, String tipo, String banco, String nome, double valor, String dataInvestimento, String dataVencimento) {
        this.usuario = usuario;
        this.tipo = tipo;
        this.banco = banco;
        this.nome = nome;
        this.valor = valor;
        this.dataInvestimento = dataInvestimento;
        this.dataVencimento = dataVencimento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNome() {
        return nome;
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

    public String getDataInvestimento() {
        return dataInvestimento;
    }

    public void setDataInvestimento(String dataInvestimento) {
        this.dataInvestimento = dataInvestimento;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getInvestimento() {
        return "Tipo: " + this.getTipo()
                + " Banco: " + this.getBanco()
                + " Nome do investimento: " + this.getNome()
                + " Valor: " + this.getValor()
                + " Data do Investimento: " + this.getDataInvestimento()
                + " Data do Vencimento: " + this.getDataVencimento();
    }
}
