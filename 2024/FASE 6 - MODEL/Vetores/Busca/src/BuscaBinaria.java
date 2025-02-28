public class BuscaBinaria {
    public static void main(String[] args) {
        int[] vetorOrdenado = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        int elementoProcurado = 55;
        int inicio = 0;
        int fim = vetorOrdenado.length - 1;
        int posicaoEncontrada = -1; // Assume-se inicialmente que o elemento não está presente

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (vetorOrdenado[meio] == elementoProcurado) {
                posicaoEncontrada = meio; // Elemento encontrado
                break;
            } else if (vetorOrdenado[meio] < elementoProcurado) {
                inicio = meio + 1; // Continua a busca na metade superior
            } else {
                fim = meio - 1; // Continua a busca na metade inferior
            }
        }

        if (posicaoEncontrada != -1) {
            System.out.println("Elemento encontrado no índice: " + posicaoEncontrada);
        } else {
            System.out.println("Elemento não encontrado no vetor.");
        }
    }
}