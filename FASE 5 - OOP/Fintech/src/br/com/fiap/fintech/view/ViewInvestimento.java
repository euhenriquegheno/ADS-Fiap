package br.com.fiap.fintech.view;

import br.com.fiap.fintech.model.Investimento;

import java.util.Scanner;

public class ViewInvestimento {
    private static void exibirMenu() {
        System.out.println("Você deve selecionar uma operação:");
        System.out.println("1-Cadastrar/Alterar investimento");
        System.out.println("2-Exibir investimento");
        System.out.println("3-Sair");
        System.out.println("Digite o número da opção ");
    }

    private static Investimento cadastrarInvestimento() {
        Investimento investimento = new Investimento();
        Scanner sc = new Scanner(System.in);

        System.out.println("Para cadastrar um investimento, informe os dados solicitados.");
        System.out.println("Informe o usuário");
        investimento.setUsuario(sc.nextLine());
        System.out.println("Informe o nome do investimento");
        investimento.setNome(sc.nextLine());
        System.out.println("Informe o valor");
        investimento.setValor(sc.nextDouble());
        System.out.println("Informe o banco");
        investimento.setBanco(sc.nextLine());
        System.out.println("Informe o tipo de investimento");
        investimento.setTipo(sc.nextLine());
        System.out.println("Informe a data do investimento:");
        investimento.setDataInvestimento(sc.nextLine());
        System.out.println("Informe a data de vencimento do investimento:");
        investimento.setDataVencimento(sc.nextLine());

        return investimento;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Investimento investimento = null;
        int op;
        do {
            exibirMenu();
            op = sc.nextInt();
            switch (op){
                case 1:
                    investimento = cadastrarInvestimento();
                    break;
                case 2:
                    if (investimento != null)
                        System.out.println(investimento.getInvestimento());
                    else
                        System.out.println("Nenhum investimento cadastrado");
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
