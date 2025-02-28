import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class EscritaArquivo {
    public static void main(String[] args) {
        List<String> linhas = Arrays.asList("Thiago Yamamoto", "Juliana Souza", "Matheus Araujo", "Maria Silva");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("saida.txt", true))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine(); // Adiciona uma quebra de linha
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}