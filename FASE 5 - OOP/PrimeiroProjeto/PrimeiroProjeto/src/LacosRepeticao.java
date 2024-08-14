public class LacosRepeticao {
    public static void main(String[] args) {
        //EXEMPLO WHILE
        System.out.println("Exemplo WHILE");
        int n = 1;
        while (n <= 5) {
            System.out.println(n);
            n++;
        }

        //EXEMPLO DO-WHILE
        System.out.println("Exemplo D0-WHILE");
        int contador = 1;

        do {
            System.out.println("contagem: " + contador);
            contador++;
        } while (contador <= 5);

        //EXEMPLO FOR
        System.out.println("Exemplo FOR");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }



    }
}
