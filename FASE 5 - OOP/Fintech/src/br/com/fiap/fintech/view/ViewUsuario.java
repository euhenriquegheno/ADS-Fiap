package br.com.fiap.fintech.view;

import br.com.fiap.fintech.model.Usuario;

import java.util.Scanner;

public class ViewUsuario {
    private static void exibirMenu() {
        System.out.println("Você deve selecionar uma operação:");
        System.out.println("1-Cadastrar/Alterar usuário");
        System.out.println("2-Exibir usuário");
        System.out.println("3-Sair");
        System.out.println("Digite o número da opção ");
    }

    private static Usuario cadastrarUsuario() {
        Usuario usuario = new Usuario();
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome completo: ");
        usuario.setNomeCompleto(sc.next() + sc.nextLine());
        System.out.println("Data de nascimento: ");
        usuario.setDataNascimento(sc.nextLine());
        System.out.println("Genero: ");
        usuario.setGenero(sc.nextLine());
        System.out.println("Email: ");
        usuario.setEmail(sc.nextLine());
        System.out.println("Senha: ");
        usuario.setSenha(sc.nextLine());

        return usuario;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = null;

        int op;
        do {
            exibirMenu();
            op = sc.nextInt();
            switch (op){
                case 1:
                    usuario = cadastrarUsuario();
                    break;
                case 2:
                    if (usuario != null)
                        System.out.println(usuario.getUsuario());
                    else
                        System.out.println("Nenhum usuário cadastrado");
                    break;
                case 3:
                    System.out.println("Finalizando o programa!");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        } while (op != 3);

        sc.close();
    }

}
