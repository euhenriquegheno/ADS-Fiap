# RECUPERANDO DADOS

### INTRODUÇÃO
* Consultas simples.
* Consultas baseadas em condições simples ou compostas.
* Consultas que recuperam dados de diferentes tabelas (junções).
* Consultas que utilizam funções para realização de diferentes operações.
* Consultas que manipulam grupos de dados.
* Consultas baseadas no resultado de outras consultas.

A instrução utilizada para a realização de consultar é o SELECT, que faz parte da categoria de operações DML (Data Manipulation Language).

## DIVISÃO DRS OU SQL

São operadores de recuperação de dados de tabelas de um banco de dados.

* SELECT simples.
* SELECT com operadores.
* SELECT a partir de junções.
* SELECT  a partir de agrupamentos.

### COMANDO *SELECT*

Para recuperar os dados das tabelas de um banco de dados, utilizamos o comando SELECT, que é um comando dentro da divisão DRS/DQL da linguagem SQL.

Sintaxe básica do comando SELECT:
```
SELECT [ DISTINCT | ALL] { * | coluna  [, coluna, … ] }
  FROM tabela
 WHERE condição
    ORDER BY coluna [, coluna, ...]
```

Na qual:
* *SELECT*: especifica as colunas necessárias para a pesquisa.
* *DISTINCT*: não mostra eventuais valores repetidos de colunas.
* *ALL*: mostra todos os valores, mesmo que repetidos; esse é o padrão se o DISTINCT não for definido, portanto, não precisamos escreve-lo.
* *(asterisco)*: indica que devem ser mostradas todas as colunas da tabela.
* *FROM*: indica em que tabela serão efetuas essas pesquisas.
* *WHERE*: condição para que se execute a pesquisa.
* *ORDER BY*: especifica em que ordem deverá ser apresentada a pesquisa desejada; por qual campo estará ordenada (de forma crescente (asc) ou decrescente (desc)).
* `<nome-tabela`>: tabela que terá os dados recuperados.
* `<nome-coluna>`: colunas que serão recuperadas da tabela.
* `<condição>`: condição (filtro) utilizado no momento da recuperação dos dados da tabela.

**OBSERVAÇÃO**
Não é uma boa prática utilizar a cláusula SELECT *. Quando utilizamos, todas as colunas serão retornadas. É importante recuperar apenas as colunas que realmente serão necessária, ou seja, que serão utilizadas nas funcionalidades que estão sendo desenvolvidas.

### OPERADORES ARITMÉTICOS
Sempre que houver mais de um operador, a precedência matemática será respeitada, ou seja, a multiplicação e a divisão serão avaliadas em primeiro lugar e, o uso dos parênteses pode alterar a ordem de execução dos operadores.

Operador| Descrição
------- | -----
+ | Adição
- | Subtração
* | Multiplicação
/ | Divisão

### APELIDO PARA COLUNAS
Os apelidos são uteis para melhorar a legibilidade do resultado da consulta, facilitando o entendimento por parte do usuário, portanto, é possível renomear o cabeçalho (rótulo) da coluna que será recuperada.

É muito útil quando queremos retornar um nome adequado para o resultado de um cálculo, por exemplo.

Deve ser escrito após o nome da coluna ou cálculo.
Podemos utilizar o "AS" (opcional) para explicitar o apelido de uma coluna.

Exemplo de consulta utilizando ALIAS(apelido) para colunas:
```
-- EXEMPLOS DE APELIDOS DE COLUNAS
SELECT NR_MATRICULA, 
 NM_FUNCIONARIO FUNCIONARIO, 
 VL_SALARIO_MENSAL "SALÁRIO MENSAL",
 VL_SALARIO_MENSAL * 1.05 AS "SALÁRIO REAJUSTADO"
  FROM T_SIP_FUNCIONARIO;
```

### CLÁUSULA *ORDER BY*
A cláusula ORDER BY é utilizada para classificar (ordernar) as linhas recuperadas por uma consulta. Podemos especificar uma ou mais colunas para classificar (ordernar) os dados de uma tabela.

Pode ordenar o resultado em ordem ascendente ("ASC", que é a opção "DEFAULT") e descendente ("DESC").

Exemplo de SQL:
```
-- APRESENTANDO RESULTADOS DE FORMA ORDENADA
-- ORDER BY ASC
  SELECT CD_DEPTO, NM_DEPTO
    FROM T_SIP_DEPARTAMENTO
ORDER BY NM_DEPTO;
```

Ou de forma descendente:
```
-- APRESENTANDO RESULTADOS DE FORMA ORDENADA
-- ORDER BY ASC
  SELECT CD_DEPTO, NM_DEPTO
    FROM T_SIP_DEPARTAMENTO
ORDER BY NM_DEPTO DESC;
```

## CONSULTA EM TABELAS UTILIZANDO *FILTROS*

### OPERADORES RELACIONAIS
Os operadores relacionais são utilizados para realizar comparações entre valores em estruturas de controle.

São operadores relacionais na linguagem SQL:

Operador| Significado| Exemplo 
------- | ---------- | -------
= | Igual | codigo=2
< | Menor que | preco<10
<= | Manor ou igual a | preco<=10
> | Maior que | preco>10
>= | Maior ou igual a | preco>=10
<> OU != | Diferente | codigo<>2

O conteúdo armazenado nas tabelas é "CASE SENSITIVE", ou seja, temos a diferenciação entre letras maiúsculas e minúsculas. Para minimizar isto durante a consulta e filtro por colunas que armazenam texto, utilizamos no momento da criação do filtro as funções `UPPER(<conteudo>)`, que converte um conteúdo para letras maiúsculas ou a `LOWER(<conteudo>)`, que converte um conteúdo para letras minúsculas.

Exemplo usando UPPER e LOWER:
```
-- UTILIZANDO A CONVERSÃO DE TEXTO
SELECT NR_MATRICULA, NM_FUNCIONARIO
  FROM T_SIP_FUNCIONARIO
 WHERE UPPER(NM_FUNCIONARIO) = 'JOAO DA SILVA'; 
-- OU 
 SELECT NR_MATRICULA, NM_FUNCIONARIO
  FROM T_SIP_FUNCIONARIO
 WHERE LOWER(NM_FUNCIONARIO) = 'joao da silva';
```

### OPERADORES LÓGICOS
Os operadores lógicos são utilizados para filtrar linhas de uma base de dados, utilizando mais de uma condição.

* O operador AND recupera uma linha, se todas as condições separadas por AND forem verdadeiras.
* O operador OR recupera uma linha, se qualquer uma das condições separadas por OR forem verdadeiras.
* O operador NOT recupera uma linha, se a condição (s) não for verdadeira.

São operadores lógicos, na linguagem SQL:

Operador| Descrição 
------- | ----------
AND | Retorna TRUE se ambas condições forem verdadeiras
OR | Retorna TRUE se ao menos uma das condições for verdadeira
NOT | Retorna TRUE se a condição for falta

### OPERADORES ESPECIAIS OU OPERADORES SQL
Os operadores SQL permitem limitas as linhas recuperadas com base na correspondência de padrão de *strings*, listas de valores, intervalos de valores e valores nulos.

São operadores especiais, na linguagem SQL:

Operador| Descrição 
------- | ----------
BETWEEN... AND... | Entre dois valores (inclusive)
IN | Compara o valor de uma coluna com um conjunto de valor
Like *valor* | Compara cadeia de caracteres
IS NULL / IS NOT NULL | É um valor nulo. Não nulo


**Exemplo BETWEEN**: Observe que no filtro que utilizamos o operador especial BETWEEN. neste exemplo, em funções do filtro, serão recuperados os funcionados admitido entre "01/01/2013" (inclusive) e "30/12/2015" (inclusive).
```
-- OPERADOR BETWEEN
SELECT NR_MATRICULA, NM_FUNCIONARIO, 
 CD_DEPTO, DT_ADMISSAO  
FROM   T_SIP_FUNCIONARIO 
WHERE  DT_ADMISSAO BETWEEN TO_DATE('01/01/2013','DD/MM/YYYY')
       AND  TO_DATE('30/12/2015','DD/MM/YYYY');
```

**Exemplo IN**: Observe que no filtro utilizamos o operador especial IN(). Neste exemplo, em função do filtro, serão recuperadores todos os funcionários alocados nos departamentos um, dois ou tres.
```
-- OPERADOR IN
SELECT NR_MATRICULA, NM_FUNCIONARIO, CD_DEPTO
  FROM   T_SIP_FUNCIONARIO
 WHERE  CD_DEPTO IN (1,2,3);
```

### OPERADOR SQL *LIKE*
O operador especial ou SQL LIKE é utilizado para recuperar linhas, quando se deseja procurar um padrão em uma string. Os padões são especificados usando uma combinação de caracteres normais e os dois caracteres curingas a seguir.

* Sublinhado (_): Corresponde a um caractere em uma posição especifica.
* Porcentagem (%)> Corresponde a qualquer número de caracteres a partir da posição especificada.

Expressão| Descrição 
------- | ----------
`LIKE 'A%'` | Todas as palavras que iniciem a letra A.
`LIKE '%A'` | Todas as palavras que terminam com a letra A
`LIKE '%A%'` | Todas as palavras que tenham a letra A em qualquer posição
`LIKE 'A_'` | String de dois caracteres que tenham a primeira letra A e o segundo caracteres seja qualquer um.
`LIKE '_A'` | String de dois caracteres cujo primeiro seja qualquer um e a última letra seja A.
`LIKE '_A_'` | String de tres caracteres cuja segunda letra seja A independentemente do primeiro ou último caractere.
`LIKE '%A_'` |Todas as palavras que tenham a letra A na penúltima posição e a última seja qualquer outro caractere.
`LIKE '_A%'` | Todos que tenham a letra A na segunda posição e o primeiro caractere seja qualquer um.

### OPERADOR DE CONCATENAÇÃO ( || )
Esse operador permite a concatenação de colunas ou *string* de caracteres com outras colunas. Representamos o operador através de de duas colunas verticais "||". A coluna resultante de uma consulta, em que utilizamos este operador, é uma expressão de caracteres.

Exemplo de consulta utilizando operador de concatenação. Será apresentado o texto `O funcionário <nome> foi admitido em <data admissão>`, onde "nome" e "data admissão" serão obtidos a partir da leitura das colunas, as demais informações representam uma *string* de caracteres que será concatenada aos campos, formando a frase desejada.

```
-- EXIBIR O TEXTO: "O FUNCIONARIO <NOME> FOI 
-- ADMITIDO EM <DATA ADMISSAO>"
SELECT NR_MATRICULA,
 'O FUNCIONARIO ' || 
 NM_FUNCIONARIO ||
 ', FOI ADMITIDO EM: ' || 
 DT_ADMISSAO "TEXTO"
  FROM T_SIP_FUNCIONARIO;
```


Resultado do campo texto:
Texto = `O FUNCIONARIO JOAO DA SILVA, FOI ADMITIDO EM: 15/09/12`

### PSEUDOCOLUNA ROWNUM
A pseudocoluna é utilizada quando precisamos limitar a quantidade de linhas retornadas através de um comando SELECT. No caso, a pseudocoluna ROWNUM numera os registros retornados por uma consulta.
Podemos utilizar, por exemplo, para recuperar um certo número de linhas por vez, para auxiliar a paginação em uma página WEB.

Exemplo de consulta:
```
--  Exemplo pseudocoluna ROWNUM
SELECT  ROWNUM   , 
        CD_DEPTO , 
        NM_DEPTO
 FROM   T_SIP_DEPARTAMENTO ;
```

O resultado vai mostrar uma coluna com o número da linha de cada uma.

Exemplo de consulta, restringindo a quantidade de linhas recuperadas durante a consulta:
```
-- RESTRINGINDO A QUANTIDADE DE LINHAS RECUPERADAS 
-- DURANTE A CONSULTA
SELECT    NR_MATRICULA ,
    CD_DEPTO ,
    DT_ADMISSAO ,
    VL_SALARIO_MENSAL ,
    (VL_SALARIO_MENSAL * 12) "SALÁRIO ANUAL"
  FROM   T_SIP_FUNCIONARIO
 WHERE  ROWNUM < 4;
```

O resultado vai nos trazer apenas 3 registros.

## CONFIGURANDO PARAMETROS NLS (NATIONAL LANGUAGE SUPPORT)
Os parametros NLS determinam o comportamente especifico do local no cliente e no servidor.
Os parametros "ALTER SESSION" podem ser usados para substituir os padrões definidos para uma sessão de arquivo de inicialização ou definido pelo cliente com definições de ambiente.

Podemos visualizar a configuração de todos os atributos NLS, através do comando:
```
-- VISUALIZAR A CONFIGURAÇÃO ATUAL DOS ATRIBUTOS NLS
-- ATUAIS PARA A SUA SESSÃO
SELECT * FROM V$NLS_PARAMETERS;
```

Exemplo de alteração de sessão para o formato de data igual a "DD/MM/YYYY":
Todas as consultas realizadas após essa alteração serão visualizadas com o novo formato.
```
-- Para alterar o formato de exibição de uma data 
-- é utilizado a sintaxe:
ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY';
```










