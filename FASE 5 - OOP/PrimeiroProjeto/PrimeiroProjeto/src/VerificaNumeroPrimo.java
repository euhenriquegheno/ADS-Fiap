import java.util.Scanner;

public class VerificaNumeroPrimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo maior que 1: ");
        int numero = scanner.nextInt();

        if(numero <= 1) {
            System.out.println("Número inválido. Digite um número inteiro positivo maior que 1.");
        } else {
            boolean ehPrimo = true;

            for(int i = 2; i < numero; i++) {
                if(numero % i == 0) {
                    ehPrimo = false;
                    break;
                }
            }

            if(ehPrimo) {
                System.out.println("O número " + numero + " é um número primo.");
            } else {
                System.out.println("O número " + numero + " não é um número primo.");
            }
        }

        scanner.close();
    }
}