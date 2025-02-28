import java.util.Scanner;

public class EscolhaPoltronaCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Matriz representando os assentos do cinema (0 = livre, 1 = ocupado)
        int[][] salaCinema = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0}
        };

        // Exibe a situação atual dos assentos
        System.out.println("Situação atual dos assentos (L = Livre, O = Ocupado):");
        for (int i = 0; i < salaCinema.length; i++) {
            for (int j = 0; j < salaCinema[i].length; j++) {
                System.out.print(salaCinema[i][j] == 0 ? "L " : "O ");
            }
            System.out.println(" <- Fila " + (i + 1));
        }

        // Recebe a escolha do usuário
        System.out.println("Escolha a fila:");
        int filaEscolhida = scanner.nextInt() - 1; // Ajusta para índice do vetor (base 0)

        System.out.println("Escolha o número do assento:");
        int assentoEscolhido = scanner.nextInt() - 1; // Ajusta para índice do vetor (base 0)

        // Verifica e atualiza a reserva do assento
        if (filaEscolhida >= 0 && filaEscolhida < salaCinema.length &&
                assentoEscolhido >= 0 && assentoEscolhido < salaCinema[filaEscolhida].length) {
            if (salaCinema[filaEscolhida][assentoEscolhido] == 0) {
                salaCinema[filaEscolhida][assentoEscolhido] = 1;
                System.out.println("Assento reservado com sucesso!");
            } else {
                System.out.println("O assento já está ocupado, por favor escolha outro.");
            }
        } else {
            System.out.println("Escolha inválida, tente novamente.");
        }

        // Fecha o scanner
        scanner.close();
    }
}