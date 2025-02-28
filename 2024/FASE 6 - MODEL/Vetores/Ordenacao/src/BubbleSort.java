public class BubbleSort {
    public static void main(String[] args) {
        int[] vetor = {64, 34, 25, 12, 22, 11, 90};

        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 1; i < vetor.length; i++) {
                //Compara elementos adjacentes
                if (vetor[i - 1] > vetor[i]) {
                    //Troca os elementos de lugar
                    int temp = vetor[i - 1];
                    vetor[i - 1] = vetor[i];
                    vetor[i] = temp;
                    houveTroca = true; //Indica que uma troca ocorreu
                }
            }
        } while (houveTroca); //Continua equanto houver trocas

        System.out.println("Vator ordenado: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i] + " ");
        }
    }
}
