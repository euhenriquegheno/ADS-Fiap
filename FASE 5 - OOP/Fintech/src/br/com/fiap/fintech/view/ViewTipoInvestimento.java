package br.com.fiap.fintech.view;

import br.com.fiap.fintech.model.TipoInvestimento;

import java.util.Scanner;

public class ViewTipoInvestimento {
    private static void exibirMenu() {
        System.out.println("Você deve selecionar uma operação:");
        System.out.println("1-Cadastrar/Alterar tipo de investimento");
        System.out.println("2-Exibir tipo de investimento");
        System.out.println("3-Sair");
        System.out.println("Digite o número da opção ");
    }

    private static TipoInvestimento cadastrarTipoInvestimento() {
        TipoInvestimento tipoInvestimento = new TipoInvestimento();
        Scanner sc = new Scanner(System.in);

        System.out.println("Para cadastrar um objetivo financeiro, informe os dados solicitados.");
        System.out.println("Informe o usuário: ");
        tipoInvestimento.setUsuario(sc.nextLine());
        System.out.println("Informe o nome do tipo de investimento: ");
        tipoInvestimento.setNome(sc.nextLine());

        return tipoInvestimento;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TipoInvestimento tipoInvestimento = null;
        int op;
        do {
            exibirMenu();
            op = sc.nextInt();
            switch (op){
                case 1:
                    tipoInvestimento = cadastrarTipoInvestimento();
                    break;
                case 2:
                    if (tipoInvestimento != null)
                        System.out.println(tipoInvestimento.getTipoInvestimento());
                    else
                        System.out.println("Nenhum tipo de investimento cadastrado");
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
