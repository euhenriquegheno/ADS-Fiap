public class OperadoresAritmeticosExemplo {
    public static void main(String[] args){
        int a = 10;
        int b = 3;

        int soma = a + b;
        int subtracao = a - b;
        int multiplicacao = a * b;
        int divisao = a / b; //10 / 3 = 3 (a divisao de inteiros descarta as casas decimais)
        int modulo = a % b; //10 % 3 = 1 (resto da divisao)

        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);
        System.out.println("Divisão: " + divisao);
        System.out.println("Módulo: " + modulo);
    }
}
