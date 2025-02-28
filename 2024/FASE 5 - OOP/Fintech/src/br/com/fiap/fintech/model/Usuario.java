package br.com.fiap.fintech.model;

public class Usuario {
    private String nomeCompleto;
    private String dataNascimento;
    private String genero;
    private String email;
    private String senha;

    // Construtor padrão
    public Usuario() {}

    // Construtor com parâmetros
    public Usuario(String nomeCompleto, String dataNascimento,
                 String genero, String email, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.email = email;
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return "Dados usuário " +
                "\nUsuario: " + this.getNomeCompleto();
    }

}
