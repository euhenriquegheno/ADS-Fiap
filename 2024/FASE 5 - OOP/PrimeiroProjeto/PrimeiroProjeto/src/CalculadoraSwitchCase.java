import java.util.Scanner;

public class CalculadoraSwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à Calculadora!");
        System.out.println("Por favor, escolha a operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");

        int escolha = scanner.nextInt();
        System.out.println("Digite dois números:");

        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double resultado = 0;

        switch (escolha) {
            case 1:
                resultado = num1 + num2;
                System.out.println("Resultado da Soma: " + resultado);
                break;
            case 2:
                resultado = num1 - num2;
                System.out.println("Resultado da Subtração: " + resultado);
                break;
            case 3:
                resultado = num1 * num2;
                System.out.println("Resultado da Multiplicação: " + resultado);
                break;
            case 4:
                if (num2 != 0) { //Se o segundo numero for diferente de 0, entao faz a divisão
                    resultado = num1 / num2;
                    System.out.println("Resultado da Divisão: " + resultado);
                } else {
                    System.out.println("Não é possível dividir por zero!");
                }
                break;
            default:
                System.out.println("Operação inválida!");
        }
    }
}