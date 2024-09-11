package br.com.fiap.fintech.view;

import br.com.fiap.fintech.model.Senha;
import java.util.Scanner;

public class ViewSenha {
    private static String validaNovaSenha(Senha senha) {
        if (senha.getSenhaAntiga().equals(senha.getNovaSenha())) {
            return "Informe uma senha diferente da atual!";
        } else if (!senha.getNovaSenha().equals(senha.getNovaSenhaRepetida())) {
            return "As novas senhas não conferem, tente novamente!";
        } else {
            // Lógica para alterar a senha com os dados do parâmetro
            return "Sua senha foi alterada com sucesso!";
        }
    }

    private static Senha alterarSenha() {
        Senha senha = new Senha();
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe a senha antiga: ");
        senha.setSenhaAntiga(sc.next() + sc.nextLine());
        System.out.println("Informe a nova senha: ");
        senha.setNovaSenha(sc.nextLine());
        System.out.println("Informe a nova senha novamente: ");
        senha.setNovaSenhaRepetida(sc.nextLine());

        System.out.println(validaNovaSenha(senha));
        return senha;

    }

    public static void main(String[] args) {
        Senha senha = null;

        senha = alterarSenha();
    }


}
