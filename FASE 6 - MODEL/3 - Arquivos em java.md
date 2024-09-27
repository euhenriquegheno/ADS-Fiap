# 3 - Arquivos em java

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

### Métodos da interface List

Principais métodos da interface List:

- add(E e): Adiciona o elemento especifico ao final desta lista. Este método também é sobrecarregado na forma add(int index, E element), permitindo adicionar um elemento em uma posição específica, deslocando os elementos atuais para a direita(adiciona um elemento na posição index e os subsequentes são movidos);

- get(int index): Retorna o elemento na posição especifica nesta lista. Permite o acesso direto aos elementos com base no índice;

- set(int index, E element): Substitui o elemento na posição especificada nessa lista pelo elemento especificado. É útil para atualizar um valor já existente em uma posição especifica.

- remove(int index): Remove o elemento na posição especificada nesta lista, deslocando qualquer elemento subsequente para a esquerda (subtrai um dos seus indices). Existe também uma versão sobrecarregada, remove(Object o), que remove a primeira ocorrencia do elemento especificado nesta lista.

- size(): Retorna o número de elementos nesta lista. Este método é essencial para iterar sobre a lista quando combinado com o método get(int index);

- clear(): Remove todos os elementos desta lista. A lista estará vazia após esta chamada retornar;

- subList(int fromIndex, int toIndex): Retorna uma visão da porção desta lista entre os índices especificados fromIndex, inclusive, e toIndex, exclusivo. Isso permite trabalhar com um segmento da lista sem a necessidade de criar uma lista;

- contains(Object o): Retorna "true" se esta lista contém o elemento especificado. É um método útil para verificar a presença de um elemento na lista;

- toArray(): Converte a lista em um array. Isso é particularmente útil quando você precisa passar a lista para um método que aceita apenas arrays;

Exemplo de uso: [Repositório de exemplos dos métodos do ArrayList](https://github.com/euhenriquegheno/ADS-Fiap/tree/main/FASE%206%20-%20MODEL/ListArrayList)

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

  

Vamos entender os principais métodos do Set, perceba que são muito parecidos ou iguais ao da List.

-   add(E e): Adiciona o elemento especificado ao conjunto se ele ainda não estiver presente. Retorna true se o conjunto não continha o elemento (e, portanto, o elemento foi adicionado) e false caso contrário.
    
-   remove(Object o): Remove o elemento especificado do conjunto, se estiver presente. Retorna true se o conjunto continha o elemento (e o elemento foi removido) e false caso contrário.
    
-   contains(Object o): Verifica se o conjunto contém o elemento especificado. Retorna true se o conjunto contém o elemento e false se não contém.
    
-   size(): Retorna o número de elementos no conjunto. Este método é útil para saber quantos elementos únicos estão armazenados no conjunto.
    
-   isEmpty(): Verifica se o conjunto está vazio, ou seja, se não contém nenhum elemento. Retorna true se o conjunto estiver vazio e false se contiver pelo menos um elemento.
    
-   clear(): Remove todos os elementos do conjunto. Após a chamada deste método, o conjunto estará vazio.
    
-   toArray(): Retorna um array contendo todos os elementos no conjunto. Este método oferece uma maneira de obter uma representação de array dos elementos do conjunto.

Exemplo de uso dos métodos: [Repositório de exemplos dos métodos do HashSet](https://github.com/euhenriquegheno/ADS-Fiap/tree/main/FASE%206%20-%20MODEL/SetHashset/ExemploMetodos)
