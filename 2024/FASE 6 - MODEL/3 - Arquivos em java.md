# 3 - Arquivos em java
## Coleções e manipulação de arquivos
### Explicação do Conteúdo usando analogias
Imagine que você está em uma biblioteca (o Java) e você precisa organizar seus livros (dados). O framework de coleções é como as prateleiras dessa biblioteca, onde você pode escolher diferentes tipos de prateleiras para diferentes tipos de livros. 

* List é como uma prateleira onde você pode colocar seus livros em ordem, como uma estante com prateleiras numeradas. Você pode adicionar, remover ou acessar um livro em uma posição específica.
* Set é como uma prateleira onde você só pode colocar um exemplar de cada livro. Não é permitido ter dois iguais, assim como em uma estante onde você só coloca um livro por título.
* Queue é como uma fila na biblioteca. Os livros que você coloca para leitura são retirados na ordem que foram adicionados, como as pessoas na fila.
* Map é como um catálogo da biblioteca, onde cada livro tem um identificador único (chave) e você pode encontrá-lo rapidamente usando esse identificador.

Agora, sobre a manipulação de arquivos, imagine que você está anotando informações em um caderno (arquivos). As classes como File, FileReader, e FileWriter são as ferramentas que você usa para escrever e ler as páginas desse caderno. E, com as técnicas mais avançadas, como a API NIO.2, você pode até fazer coisas como copiar anotações de um caderno para outro, mover páginas e organizar tudo da melhor forma.

## Interfaces do FrameWork de coleções

As interfaces são a espinha dorsal do framework de coleções em Java, fornecendo uma fundação comum sobre a qual as coleções são construídas. Cada interface define um tipo específico de comportamento de coleção, como listas ordenadas, conjuntos únicos ou filas de elementos.

## List e ArrayList

As listas suportam elementos duplicados e garantem uma ordem especifica na qual os elementos são inseridos, permitindo assim uma manipulação flexível e intuitiva dos dados.
Implementações como ArrayList, LinkedList, e Vector oferecem diversas opções com características de desempenho variadas, tornando a interface List um componente versátil para uma ampla gama de aplicações.

A declaração de uma variável ArrayList envolve especificar o tipo da variável seguido pelo nome da variável, que voce utilizará para se referir a lista no seu código.

Antes de tudo é essencial importar tanto a interface List quanto a classe ArrayList do pacote java.util.

Exemplo de declaração:

    import java.util.ArrayList;
    import java.util.List;
    public class ExemploArrayList {
	     public static void main(String[] args) {
	       // Declaração e inicialização de um ArrayList de Strings
	       List<String> frutas = new ArrayList<>();
	       // Adicionando elementos à lista
	       frutas.add("Maçã");
	       frutas.add("Banana");
	       frutas.add("Morango");
	       // Exibindo os elementos da lista
	       System.out.println(frutas);
	     }
    }

### Métodos da interface List - ArrayList

Principais métodos da interface List:

- **add(E e)**: Adiciona o elemento especifico ao final desta lista. Este método também é sobrecarregado na forma add(int index, E element), permitindo adicionar um elemento em uma posição específica, deslocando os elementos atuais para a direita(adiciona um elemento na posição index e os subsequentes são movidos);

- **get(int index)**: Retorna o elemento na posição especifica nesta lista. Permite o acesso direto aos elementos com base no índice;

- **set(int index, E element)**: Substitui o elemento na posição especificada nessa lista pelo elemento especificado. É útil para atualizar um valor já existente em uma posição especifica.

- **remove(int index)**: Remove o elemento na posição especificada nesta lista, deslocando qualquer elemento subsequente para a esquerda (subtrai um dos seus indices). Existe também uma versão sobrecarregada, remove(Object o), que remove a primeira ocorrencia do elemento especificado nesta lista.

- **size()**: Retorna o número de elementos nesta lista. Este método é essencial para iterar sobre a lista quando combinado com o método get(int index);

- **clear()**: Remove todos os elementos desta lista. A lista estará vazia após esta chamada retornar;

- **subList(int fromIndex, int toIndex)**: Retorna uma visão da porção desta lista entre os índices especificados fromIndex, inclusive, e toIndex, exclusivo. Isso permite trabalhar com um segmento da lista sem a necessidade de criar uma lista;

- **contains(Object o)**: Retorna "true" se esta lista contém o elemento especificado. É um método útil para verificar a presença de um elemento na lista;

- **toArray()**: Converte a lista em um array. Isso é particularmente útil quando você precisa passar a lista para um método que aceita apenas arrays;

### Exemplos
***Exemplo de uso dos métodos:*** [Repositório de exemplos dos métodos do ArrayList](https://github.com/euhenriquegheno/ADS-Fiap/tree/main/FASE%206%20-%20MODEL/ListArrayList/MetodosInterfaceList)

***Exercício:*** [Repositório do exercício;]()

## Set e HashSet

O set é uma interface no Java Collections Framework projetada para representar uma coleção que não aceita elementos duplicados, garantindo a unicidade de cada item dentro da coleção. Dentre suas várias implementações, o HashSet é uma das mais utilizadas, caracterizando-se pelo uso de uma tabela hash para armazenar os elementos. Isso confere ao HashSet uma performance notável para as operações de adicionar, remover e verificar a existência de itens, como tempo de execução constante na média para essas operações.

O HashSet não garante nenhuma ordem para os elementos armazenados, podendo parecer aleatória durante a iteração.

Exemplo de declaração:

    import java.util.HashSet;
    import java.util.Set;
    public class HashSetExample {
      public static void main(String[] args) {
        Set<String> frutas = new HashSet<>();
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Morango");
        frutas.add("Maçã"); // Tentativa de adicionar duplicata
        System.out.println(frutas); // Observe a ausência de duplicatas
      }
    }

  
### Métodos da interface Set - HashSet
Vamos entender os principais métodos do Set, perceba que são muito parecidos ou iguais ao da List.

-   **add(E e)**: Adiciona o elemento especificado ao conjunto se ele ainda não estiver presente. Retorna true se o conjunto não continha o elemento (e, portanto, o elemento foi adicionado) e false caso contrário.
    
-   **remove(Object o)**: Remove o elemento especificado do conjunto, se estiver presente. Retorna true se o conjunto continha o elemento (e o elemento foi removido) e false caso contrário.
    
-   **contains(Object o)**: Verifica se o conjunto contém o elemento especificado. Retorna true se o conjunto contém o elemento e false se não contém.
    
-   **size()**: Retorna o número de elementos no conjunto. Este método é útil para saber quantos elementos únicos estão armazenados no conjunto.
    
-  **isEmpty()**: Verifica se o conjunto está vazio, ou seja, se não contém nenhum elemento. Retorna true se o conjunto estiver vazio e false se contiver pelo menos um elemento.
    
-   **clear()**: Remove todos os elementos do conjunto. Após a chamada deste método, o conjunto estará vazio.
    
-   **toArray()**: Retorna um array contendo todos os elementos no conjunto. Este método oferece uma maneira de obter uma representação de array dos elementos do conjunto.

### Exemplos
***Exemplo de uso dos métodos:*** [Repositório de exemplos dos métodos do HashSet;](https://github.com/euhenriquegheno/ADS-Fiap/tree/main/FASE%206%20-%20MODEL/SetHashset/ExemploMetodos)

***Exercício:*** [Repositório do exercício;]()

## Map e HashMap
O Map representa uma estrutura de dados que armazena pares de **chave-valor**. Diferentemente de coleções como List e Set, um Map não é uma coleção de valores individuais, mas sim de pares, onde cada chave é única e mapeada para exatamente um valor.

O HashMap é conhecido por sua eficiência em operações de busca, inserção e remoção, pois não mantém nenhuma ordem para as chaves ou valores.

Exemplo de declaração:

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
      }
    }

### Métodos da interface Map - HashMap

- **put(K key, V value)**: Adiciona uma nova chave e valor ao HashMap. Se a chave já existir, atualiza o valor.

- **get(Object key)**: Retorna o valor associado à chave especificada. Se a chave não estiver presente, retorna null.

-  **remove(Object key)**: Remove a entrada que corresponde à chave especificada do HashMap.

-  **containsKey(Object key)**: Verifica se o HashMap contém a chave especificada. Retorna true se a chave estiver presente, false caso contrário.

-  **containsValue(Object value)**: Verifica se existe algum valor associado a uma chave no HashMap. Retorna true se o valor estiver presente.

-  **keySet()**: Retorna um conjunto (Set) que contém todas as chaves do HashMap.

-  **values()**: Retorna uma coleção (Collection) que contém todos os valores do HashMap.

-  **size()**: Retorna o número de pares chave-valor presentes no HashMap.

-  **clear()**: Remove todas as entradas do HashMap, deixando-o vazio.

### Exemplos
***Exemplo de uso dos métodos:*** [Repositório de exemplos dos métodos do HashMap;](https://github.com/euhenriquegheno/ADS-Fiap/tree/main/FASE%206%20-%20MODEL/MapHashMap/ExemplosMetodos)

***Exercício:*** [Repositório do exercício;]()


## Manipulação de Arquivos

A manipulação de arquivos é uma necessidade comum em muitas alicações, permitindo que programas leiam, criem, editem ou excluam arquivos no sistema de arquivos.

Java utiliza várias classes localizadas nos pacotes *java.io* e *java.nio.file* para oferecer um controle detalhado sobre os arquivos. Com essas classes podemos criar arquivos, ler o conteúdo de arquivos, escrever dados em arquivos, copiar, mover e excluir arquivos.

## Leitura de arquivos

Focaremos no uso das classes File, FileReader e BufferedReader para ler arquivos de texto.

A classe File do pacote *java.io* é utilizada para representar os metadas de um arquivo, ou diretório do sistema de arquivos. Não é usado diretamente para ler ou escrever conteudo.

    File file = new File("caminho/do/seu/arquivo.txt");

Para ler o arquivo texto e ler as suas linhas, utilizamos as classes FileReader e BufferedReader.

FileReader é uma classe conveniente para ler arquivos de texto, que le caracteres. Para melhor eficiencia e facilidade de uso, é comum envolver um FileReader com um BufferesReader. Ele aumenta a eficiencia da leitura atraves do uso de um buffer e oferece o método readLine() para ler uma linha de texto de cada vez.

Exemplo de como ler e exibir o conteúdo de um arquivo de texto chamado alunos.txt:

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

FileNotFoundException = Se o arquivo especificado não for encontrado.
IOException = Exceção mais genérica para erros de I/O.

***Exemplo de leitura:*** [Repositório com exemplo de leitura de arquivo;](https://github.com/euhenriquegheno/ADS-Fiap/tree/main/FASE%206%20-%20MODEL/ManipulacaoArquivos/ExemploLeitura)

## Escrita em arquivos

Classes FileWrite e BufferedWrite. Fornecem métodos para escrever texto em arquivos, tanto para criar arquivos quanto para adicionar conteúdos a arquivos existentes.

FileWrite serve para escrever caracteres em um arquivo. Basta instanciar um objeto FileWrite, especificando o caminho e o nome do arquivo que deseja escrever ou criar. É possivel tambem sobrescrever o arquivo existente ou adicionar ao final dele, atraves de um constructor que aceita um parametro booleano para indicar essa escolha.

Exemplo declaração:

    // Adiciona ao arquivo se existir
    FileWriter fw = new FileWriter("saida.txt", true);

Para melhorar a eficiencia, envolver o FileWrite em um BufferedWrite. Ele fornece o mpetodo newLine() para inserir quebras de linhas.

Exemplo: 
    BufferedWriter bw = new BufferedWriter(new FileWriter("saida.txt"));

***Exemplo que demonstra como criar um arquivo e escrever nele algumas linhas de texto:*** [Repositório com exemplo;](https://github.com/euhenriquegheno/ADS-Fiap/tree/main/FASE%206%20-%20MODEL/ManipulacaoArquivos/ExemploEscrita)
