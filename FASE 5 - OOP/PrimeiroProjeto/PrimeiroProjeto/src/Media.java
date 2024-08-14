import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nomeAluno = scanner.nextLine();

        System.out.print("Informe sua primeira nota: ");
        double primeiraNota = scanner.nextDouble();
        System.out.print("Informe sua segunda nota: ");
        double segundaNota = scanner.nextDouble();

        double media = (primeiraNota + segundaNota) / 2;

        System.out.println("A nota média do aluno " + nomeAluno + " é " + media);

        double teste = (((10 + 3) / 2) * 5) % 3;
        System.out.println(teste);

        scanner.close();
    }
}
