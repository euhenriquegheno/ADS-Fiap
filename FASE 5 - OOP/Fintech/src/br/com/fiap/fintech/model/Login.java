package br.com.fiap.fintech.model;

public class Login {
    private String usuario;
    private String senha;

    // Construtor padrão
    public Login() {}

    // Construtor com parâmetros
    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    // Exemplo de método
    public void fazerLogin() {
        // Lógica para realizar o login
        System.out.println("Realizando login para o usuário: " + usuario);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}