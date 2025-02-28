import java.util.ArrayList;
import java.util.List;

public class MetodosInterfaceList {
    public static void main(String[] args) {
        // Criação de uma lista de Strings
        List<String> cores = new ArrayList<>();

        // Adição de elementos
        cores.add("Vermelho");
        cores.add("Azul");
        cores.add("Verde");
        cores.add("Amarelo");

        // Acesso a um elemento
        System.out.println("Elemento na posição 2: " + cores.get(2));

        // Modificação de um elemento
        cores.set(2, "Roxo");
        System.out.println("Lista após modificar o elemento na posição 2: " + cores);

        // Remoção de elementos
        cores.remove("Amarelo"); // Pelo objeto
        cores.remove(0); // Pelo índice
        System.out.println("Lista após remoções: " + cores);

        // Tamanho da lista
        System.out.println("Tamanho da lista: " + cores.size());

        // Verificar se um elemento está presente
        if (cores.contains("Azul")) {
            System.out.println("A lista contém a cor Azul.");
        }

        //Percorre a lista e imprime a posição e o valor do elemento
        for (int i=0; i<cores.size(); i++){
            System.out.println("Cor [" + i + "] = " + cores.get(i));
        }

        // Limpar a lista
        cores.clear();
        System.out.println("Lista após limpar: " + cores);

        // Verificar se a lista está vazia
        if (cores.isEmpty()) {
            System.out.println("A lista está vazia.");
        }

    }
}