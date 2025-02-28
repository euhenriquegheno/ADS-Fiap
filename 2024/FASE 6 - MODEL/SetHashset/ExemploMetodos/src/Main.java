import java.util.HashSet;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        // Criação do conjunto usando HashSet
        Set<String> frutas = new HashSet<>();
        // Adicionando elementos ao conjunto
        System.out.println("Adicionando 'Maçã': " + frutas.add("Maçã")); // Deve retornar true
        System.out.println("Adicionando 'Banana': " + frutas.add("Banana")); // Deve retornar true
        System.out.println("Tentando adicionar 'Maçã' novamente: " + frutas.add("Maçã")); // Deve retornar false
        // Verificando se o conjunto contém um elemento
        System.out.println("Conjunto contém 'Banana': " + frutas.contains("Banana")); // Deve retornar true
        System.out.println("Conjunto contém 'Laranja': " + frutas.contains("Laranja")); // Deve retornar false
        // Removendo um elemento do conjunto
        System.out.println("Removendo 'Banana': " + frutas.remove("Banana")); // Deve retornar true
        System.out.println("Tentando remover 'Laranja': " + frutas.remove("Laranja")); // Deve retornar false
        // Verificando o tamanho do conjunto
        System.out.println("Número de elementos no conjunto: " + frutas.size()); // Deve ser 1
        // Verificando se o conjunto está vazio
        System.out.println("Conjunto está vazio: " + frutas.isEmpty()); // Deve retornar false
        //Percorrendo o set e exibindo o valor do item
        for (String item : frutas){
            System.out.println(item);
        }
        // Limpando o conjunto
        frutas.clear();
        System.out.println("Conjunto após limpar: " + frutas); // Deve ser {}
        System.out.println("Conjunto está vazio: " + frutas.isEmpty()); // Deve retornar true
    }
}