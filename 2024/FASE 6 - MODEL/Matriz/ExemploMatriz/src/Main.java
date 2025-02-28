//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Inicialização da matriz 3x3 com valores
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        //Acessando um elemento específico (segunda linha, terceira coluna)
        System.out.println("Valor original na posição [1][2]: " + matriz[1][2]);

        //Modificando o valor na posição [1][2] para 10
        matriz[1][2] = 10;

        //Exibindo todos os dados da matriz após modificação
        System.out.println("Exibindo todos os valores da matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(matriz[i][j] + " ");
            }
            System.out.println(); //Quebra de linha para formatar a saida como uma matriz
        }
    }
}