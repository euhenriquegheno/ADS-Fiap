import java.io.*;
public class LeituraArquivo {
    public static void main(String[] args) {
        File file = new File("alunos.txt");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        }catch (FileNotFoundException e){
            System.err.println("Arquivo não encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}