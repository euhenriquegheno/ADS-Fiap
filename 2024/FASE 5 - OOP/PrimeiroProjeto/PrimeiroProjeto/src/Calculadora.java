import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro valor: ");
        double primeiroValor = scanner.nextDouble();
        System.out.print("Digite o segundo valor: ");
        double segundoValor = scanner.nextDouble();

        double soma = primeiroValor + segundoValor;
        double subtracao = primeiroValor - segundoValor;
        double multiplicacao = primeiroValor * segundoValor;
        double divisao = primeiroValor / segundoValor;

        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);
        System.out.println("Divisão: " + divisao);

        scanner.close();
    }
}
