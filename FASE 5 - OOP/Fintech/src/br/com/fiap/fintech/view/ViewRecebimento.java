package br.com.fiap.fintech.view;

import br.com.fiap.fintech.model.Recebimento;

import java.util.Scanner;

public class ViewRecebimento {
    private static void exibirMenu() {
        System.out.println("Você deve selecionar uma operação:");
        System.out.println("1-Cadastrar/Alterar recebimento");
        System.out.println("2-Exibir recebimento");
        System.out.println("3-Sair");
        System.out.println("Digite o número da opção ");
    }

    private static Recebimento cadastrarRecebimento() {
        Recebimento recebimento = new Recebimento();
        Scanner sc = new Scanner(System.in);

        System.out.println("Para cadastrar um movimento, informe os dados solicitados.");
        System.out.println("Informe o usuário");
        recebimento.setUsuario(sc.nextLine());
        System.out.println("Informe a categoria");
        recebimento.setCategoria(sc.nextLine());
        System.out.println("Informe o valor");
        recebimento.setValor(sc.nextDouble());
        System.out.println("Informe a data");
        recebimento.setData(sc.nextLine());
        System.out.println("Informe a descrição:");
        recebimento.setDescricao(sc.nextLine());

        return recebimento;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Recebimento recebimento = null;
        int op;
        do {
            exibirMenu();
            op = sc.nextInt();
            switch (op){
                case 1:
                    recebimento = cadastrarRecebimento();
                    break;
                case 2:
                    if (recebimento != null)
                        System.out.println(recebimento.getMovimento());
                    else
                        System.out.println("Nenhum recebimento cadastrado");
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
