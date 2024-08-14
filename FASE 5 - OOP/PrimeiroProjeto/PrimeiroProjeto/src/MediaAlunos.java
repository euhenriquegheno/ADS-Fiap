import java.util.Scanner;

public class MediaAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int alunos = 10;
        double totalNotas = 0;
        double media = 0;

        System.out.println("Informe as notas dos " + alunos + " alunos:");

        for (int i = 1; i <= alunos; i++) {
            System.out.println("Digite a nota do aluno " + i + ": ");
            totalNotas += scanner.nextDouble();
        }

        media = totalNotas / alunos;
        System.out.println("A média dos alunos foi de " + media + " pontos");
        scanner.close();
    }
}
