import java.util.Scanner;

public class SistemaPedidoCafe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Café Java!");

        double valorTotal = 0;
        int quantidadeCafes = 0;
        boolean continuarPedido = true;

        do {
            System.out.println("Escolha o tamanho do seu café: (P) Pequeno, (M) Médio, (G) Grande");
            String tamanhoCafe = scanner.next().toUpperCase();

            if (tamanhoCafe.equals("F")) {
                continuarPedido = false;
            } else {
                System.out.println("Escolha o tipo de café: (E) Espresso, (C) Cappuccino, (L) Latte");
                String tipoCafe = scanner.next().toUpperCase();

                double preco = 0;

                switch (tamanhoCafe) {
                    case "P":
                        preco += 2.50;
                        break;
                    case "M":
                        preco += 3.00;
                        break;
                    case "G":
                        preco += 3.50;
                        break;
                    default:
                        System.out.println("Opção de tamanho inválida!");
                        continue;
                }

                switch (tipoCafe) {
                    case "E":
                        preco += 1.50;
                        System.out.println("Café Espresso selecionado");
                        break;
                    case "C":
                        preco += 2.00;
                        System.out.println("Café Cappuccino selecionado");
                        break;
                    case "L":
                        preco += 2.50;
                        System.out.println("Café Latte selecionado");
                        break;
                    default:
                        System.out.println("Opção de café inválida!");
                        continue;
                }

                valorTotal += preco;
                quantidadeCafes++;

                System.out.println("Café adicionado ao pedido!");
            }
        } while (continuarPedido);

        System.out.println("Seu pedido foi finalizado. Total a pagar: R$" + valorTotal);
        System.out.println("Quantidade de cafés pedidos: " + quantidadeCafes);
        scanner.close();
    }
}