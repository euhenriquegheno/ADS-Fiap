package br.com.fiap.loja.model;

public class Cliente {

    protected String nome;
    protected String cpf;

    protected boolean ativo;

    public void exibirDados() {
        System.out.println(nome + " " + cpf + " " + formatarDado());
    }

    private String formatarDado(){
        if (ativo)
            return "Ativo";
        else
            return "Inativo";
    }

    //Atalho ALT + INSERT para criar os metodos "getters and setters"
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
