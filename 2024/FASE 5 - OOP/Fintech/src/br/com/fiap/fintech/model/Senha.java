package br.com.fiap.fintech.model;

public class Senha {

    private String senhaAntiga;
    private String novaSenha;
    private String novaSenhaRepetida;

    public Senha() {
    }

    public Senha(String senhaAntiga, String novaSenha, String novaSenhaRepetida) {
        this.senhaAntiga = senhaAntiga;
        this.novaSenha = novaSenha;
        this.novaSenhaRepetida = novaSenhaRepetida;
    }

    public String getSenhaAntiga() {
        return senhaAntiga;
    }

    public void setSenhaAntiga(String senhaAntiga) {
        this.senhaAntiga = senhaAntiga;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getNovaSenhaRepetida() {
        return novaSenhaRepetida;
    }

    public void setNovaSenhaRepetida(String novaSenhaRepetida) {
        this.novaSenhaRepetida = novaSenhaRepetida;
    }

}
