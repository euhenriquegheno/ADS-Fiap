package br.com.fiap.fintech.view;

import br.com.fiap.fintech.model.Pagamento;

import java.util.Scanner;

public class ViewPagamento {
    private static void exibirMenu() {
        System.out.println("Você deve selecionar uma operação:");
        System.out.println("1-Cadastrar/Alterar pagamento");
        System.out.println("2-Exibir pagamento");
        System.out.println("3-Sair");
        System.out.println("Digite o número da opção ");
    }

    private static Pagamento cadastrarPagamento() {
        Pagamento pagamento = new Pagamento();
        Scanner sc = new Scanner(System.in);

        System.out.println("Para cadastrar um movimento, informe os dados solicitados.");
        System.out.println("Informe o usuário");
        pagamento.setUsuario(sc.nextLine());
        System.out.println("Informe a categoria");
        pagamento.setCategoria(sc.nextLine());
        System.out.println("Informe o valor");
        pagamento.setValor(sc.nextDouble());
        System.out.println("Informe a data");
        pagamento.setData(sc.nextLine());
        System.out.println("Informe a descrição:");
        pagamento.setDescricao(sc.nextLine());

        return pagamento;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pagamento pagamento = null;
        int op;
        do {
            exibirMenu();
            op = sc.nextInt();
            switch (op){
                case 1:
                    pagamento = cadastrarPagamento();
                    break;
                case 2:
                    if (pagamento != null)
                        System.out.println(pagamento.getMovimento());
                    else
                        System.out.println("Nenhum pagamento cadastrado");
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
