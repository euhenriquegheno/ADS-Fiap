public class Tabuada {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("\nTabuada do " + i);
            for (int x = 1; x <= 10; x++) {
                int multiplicacao = i * x;
                System.out.println(i + " x " + x + " = " + multiplicacao);
            }
        }
    }
}
