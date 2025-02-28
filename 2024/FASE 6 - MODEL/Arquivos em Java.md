# Arquivos em JAVA
## List e ArrayList
As listas suportam elementos duplicados e garantem uma ordem especifica na qual os elementos são inseridos, permitindo assim uma manipulação flexível e intuitiva dos dados.

Implementações como ArrayList, LinkedList, e Vector oferecem diversas opções com características de desempenho variadas, tornando a interface List um componente versátil para uma ampla gama de aplicações.

A declaração de uma variável ArrayList envolve especificar o tipo da variável seguido pelo nome da variável, que voce utilizará para se referir a lista no seu código.

Antes de tudo é essencial importar tanto a interface List quanto a classe ArrayList do pacote java.util.

Exemplo de declaração:

```java
import java.util.ArrayList;
import java.util.List;

public class ListaTeste {
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
```

## SET E HASHSET

Uma coleção que não aceitar elementos duplicados, garantindo assim a unicidade de cada item dentro da coleção.
O Hashset não garante nenhum ordem para os elementos armazenados.

```java
import java.util.HashSet;
import java.util.Set;

public class SetTeste {
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
```

## MAP E HASHMAP

Uma estrutura de dados que armazena pares de chave-valor. Não é uma coleção de valores individuais, mas sim de pares, onde cada chave é unida e mapeada para exatamente um valor.

```java
import java.util.HashMap;
import java.util.Map;

public class NotasAlunos {
    public static void main(String[] args) {
        // Criação do mapa de alunos e notas
        Map<String, Double> notasAlunos = new HashMap<>();
        
        // Adicionando elementos ao mapa
        notasAlunos.put("Maria", 9.5);
        notasAlunos.put("João", 7.8);
        notasAlunos.put("Ana", 8.7);
        notasAlunos.put("Pedro", 5.4);
        
        // Acessando a nota de um aluno específico
        System.out.println("Nota de Ana: " + notasAlunos.get("Ana"));
        
        // Atualizando a nota de um aluno
        notasAlunos.put("Ana", 9.0);
        System.out.println("Nota atualizada de Ana: " + notasAlunos.get("Ana"));
        
        // Removendo um aluno do mapa
        notasAlunos.remove("Pedro");
        System.out.println("Mapa após a remoção de Pedro: " + notasAlunos);
        
        // Iterando sobre o mapa para exibir todos os alunos e suas notas
        System.out.println("\nLista de Alunos e suas Notas:");
        for (Map.Entry<String, Double> entrada : notasAlunos.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}
```

## Manipulação de arquivos

### LEITURA DE ARQUIVOS
Focaremos no uso das classes File, FileReader e BufferedReader para ler arquivos de texto.

```java
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
```

### ESCRITA EM ARQUIVOS

Focaremos no uso das classes FileWrite e BufferedWrite para escrever em arquivos de texto.

```java
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
```

### EXEMPLO
Programa que permite o usuario a criar e gerenciar uma lista de compras de forma interativa:
```java
import java.io.*;
import java.util.Scanner;

public class GerenciadorListaDeCompras {
    public static void main(String[] args) {
        adicionarItem();
        exibirLista();
    }
    
    public static void adicionarItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um item para adicionar à lista de compras (ou digite 'sair' para finalizar):");
        String item = scanner.nextLine();
        while (!item.equalsIgnoreCase("sair")) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("listaDeCompras.txt", true))) {
                bw.write(item);
                bw.newLine();
                System.out.println("Item '" + item + "' adicionado com sucesso!");
            } catch (IOException e) {
                System.err.println("Erro ao escrever no arquivo.");
                e.printStackTrace();
            }
            System.out.println("\nDigite outro item (ou 'sair' para finalizar):");
            item = scanner.nextLine();
        }
    }
    
    public static void exibirLista() {
        System.out.println("\nLista de Compras:");
        try (BufferedReader br = new BufferedReader(new FileReader("listaDeCompras.txt"))) {
            String itemLido;
            while ((itemLido = br.readLine()) != null) {
                System.out.println("- " + itemLido);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
    }
}
```

### MANIPULAÇÃO AVANÇADA DE ARQUIVOS
**COPIAR ARQUIVO E COLAR**
```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopiaArquivosArquivos {
    public static void main(String[] args) {
        try {
            Path origem = Paths.get("exemplo.txt");
            Path destino = Paths.get("exemplo_copiado.txt");
            Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Arquivo copiado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**REMOÇÃO DE ARQUIVO**
```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RemocaoDeArquivo {
    public static void main(String[] args) {
        try {
            Files.delete(Path.of("alunos.txt"));
            System.out.println("Arquivo excluído com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

**LISTAGEM DE ARQUIVOS**
```java
import java.io.IOException;
import java.nio.file.*;

public class ListandoArquivos {
    public static void main(String[] args) {
        Path dir = Paths.get("/caminho/do/diretorio");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
    }
}
```

**OBTENÇÃO DE DADOS DO ARQUIVO**
```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ObterDadosArquivo {
    public static void main(String[] args) {
        Path file = Paths.get("listaDeCompras.txt");
        try {
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println("Tamanho: " + attr.size());
            System.out.println("Data de criação: " + attr.creationTime());
            System.out.println("Última modificação: " + attr.lastModifiedTime());
            System.out.println("É um diretório? " + attr.isDirectory());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```


