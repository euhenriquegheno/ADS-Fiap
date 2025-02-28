//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double[] notasAluno = {7.5, 8.0, 9.0, 6.5, 8.0}; //Inicializando um vetor com valores

        //Calculando a média das notas
        double somaNotas = 0;
        for (int i = 0; i< notasAluno.length; i++) {
            somaNotas += notasAluno[i];
        }
        double media = somaNotas / notasAluno.length;

        System.out.println("Média do aluno: " + media);
        if (media >= 7.0) {
            System.out.println("Aluno aprovado!");
        } else {
            System.out.println("Aluno reprovado.");
        }

    }
}