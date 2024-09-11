public class GerenciamentoNotasEstudantes {
    public static void main(String[] args) {
        // Matriz representando as notas dos estudantes em diferentes disciplinas
        // Linhas = estudantes, Colunas = disciplinas
        double[][] notasEstudantes = {
                {7.5, 8.0, 9.0}, // Notas do estudante 1
                {6.0, 7.5, 8.5}, // Notas do estudante 2
                {8.0, 9.0, 9.5}, // Notas do estudante 3
        };

        // Calcula e exibe a média das notas para cada estudante
        for (int i = 0; i < notasEstudantes.length; i++) {
            double somaNotas = 0;
            for (int j = 0; j < notasEstudantes[i].length; j++) {
                somaNotas += notasEstudantes[i][j];
            }
            double media = somaNotas / notasEstudantes[i].length;
            System.out.printf("Média do estudante %d: %.2f\n", i + 1, media);
        }
    }
}