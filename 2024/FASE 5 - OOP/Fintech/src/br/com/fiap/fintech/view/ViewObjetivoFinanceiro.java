package br.com.fiap.fintech.view;

import br.com.fiap.fintech.model.ObjetivoFinanceiro;

import java.util.Scanner;

public class ViewObjetivoFinanceiro {
    private static void exibirMenu() {
        System.out.println("Você deve selecionar uma operação:");
        System.out.println("1-Cadastrar/Alterar objetivo financeiro");
        System.out.println("2-Exibir objetivo financeiro");
        System.out.println("3-Sair");
        System.out.println("Digite o número da opção ");
    }

    private static ObjetivoFinanceiro cadastrarObjetivoFinanceiro() {
        ObjetivoFinanceiro objetivoFinanceiro = new ObjetivoFinanceiro();
        Scanner sc = new Scanner(System.in);

        System.out.println("Para cadastrar um objetivo financeiro, informe os dados solicitados.");
        System.out.println("Informe o usuário");
        objetivoFinanceiro.setUsuario(sc.nextLine());
        System.out.println("Informe o nome do objetivo");
        objetivoFinanceiro.setNome(sc.nextLine());
        System.out.println("Informe uma descrição");
        objetivoFinanceiro.setDescricao(sc.nextLine());
        System.out.println("Informe o valor");
        objetivoFinanceiro.setValor(sc.nextDouble());
        System.out.println("Informe a data para o objetivo:");
        objetivoFinanceiro.setData(sc.nextLine());

        return objetivoFinanceiro;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ObjetivoFinanceiro objetivoFinanceiro = null;
        int op;
        do {
            exibirMenu();
            op = sc.nextInt();
            switch (op){
                case 1:
                    objetivoFinanceiro = cadastrarObjetivoFinanceiro();
                    break;
                case 2:
                    if (objetivoFinanceiro != null)
                        System.out.println(objetivoFinanceiro.getObjetivoFinanceiro());
                    else
                        System.out.println("Nenhum objetivo financeiro cadastrado");
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
