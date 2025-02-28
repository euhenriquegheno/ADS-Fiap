package br.com.fiap.fintech.view;

import br.com.fiap.fintech.model.Banco;

import java.util.Scanner;

public class ViewBanco {
    private static void exibirMenu() {
        System.out.println("Você deve selecionar uma operação:");
        System.out.println("1-Cadastrar/Alterar banco");
        System.out.println("2-Exibir banco");
        System.out.println("3-Sair");
        System.out.println("Digite o número da opção ");
    }

    private static Banco cadastrarBanco() {
        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);

        System.out.println("Para cadastrar um banco, informe os dados solicitados.");
        System.out.println("Informe o usuário");
        banco.setUsuario(sc.nextLine());
        System.out.println("Informe o nome do banco");
        banco.setNome(sc.nextLine());

        return banco;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = null;
        int op;
        do {
            exibirMenu();
            op = sc.nextInt();
            switch (op){
                case 1:
                    banco = cadastrarBanco();
                    break;
                case 2:
                    if (banco != null)
                        System.out.println(banco.getBanco());
                    else
                        System.out.println("Nenhum banco cadastrado");
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
