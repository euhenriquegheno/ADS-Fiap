package br.com.fiap.fintech.view;

import br.com.fiap.fintech.model.Login;

import java.util.Scanner;

public class ViewLogin {

    private static Login fazerLogin() {
        Login login = new Login();
        Scanner sc = new Scanner(System.in);

        System.out.println("Usuario: ");
        login.setUsuario(sc.next() + sc.nextLine());
        System.out.println("Senha: ");
        login.setSenha(sc.nextLine());

        System.out.println("Login efetuado com sucesso!");
        return login;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = null;

        login = fazerLogin();

        sc.close();
    }

}
