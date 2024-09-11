import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Produto produto = new Produto();
        Scanner sc = new Scanner(System.in);

        int op;
        do {
            System.out.println("Escolha uma opção:\n 1-Cadastrar Produto\n 2-Exibir Informações\n " +
                    "3-Vender\n 4-Adicionar Estoque\n 5-Aplicar Desconto\n 0-Sair");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    String nome = sc.next() + sc.nextLine();
                    System.out.println("Digite o preço:");
                    double preco =  sc.nextDouble();
                    System.out.println("Digite o estoque:");
                    int estoque = sc.nextInt();
                    produto.nome = nome;
                    produto.preco = preco;
                    produto.quantidade = estoque;
                    break;
                case 2:
                    produto.exibirInformacoes();
                    break;
                case 3:
                    System.out.println("Quantidade vendida");
                    int quantidadeVendida = sc.nextInt();

                    produto.vender(quantidadeVendida);
                    break;
                case 4:
                    System.out.println("Adicionar estoque:");
                    int quantidadeAdicionada = sc.nextInt();

                    produto.adicionarEstoque(quantidadeAdicionada);
                    break;
                case 5:
                    System.out.println("Desconto no preço %:");
                    double percentualDesconto = sc.nextDouble();

                    produto.aplicarDesconto(percentualDesconto);
                    break;
                case 0:
                    System.out.println("Finalizando o programa");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }while(op != 0);

        sc.close();
    }
}