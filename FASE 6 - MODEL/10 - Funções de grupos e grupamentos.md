# CRIANDO FUNÇÕES DE GRUPOS E AGRUPAMENTOS

SELECT, a partir de agrupamentos (GROUP BY), nos permite a pesquisa através de agrupamento de registro. Um agrupamento representa a união de um ou mais registros em um único resultado, de tal forma que os registros sejam agrupados.

É necessário o uso de funções de grupo, por exemplo: MIN, MAX, AVG, COUNT, SUM, como uma coluna a ser apresentada pelo comando SELECT.

| FUNÇÃO DE GRUPO | DESCRIÇÃO |
|--|--|
| COUNT() | Retorna número de linhas afetadas pelo comando. |
| SUM() | Retorna a somatória do valor das colunas especificadas. |
| AVG() | Retorna a média aritmética dos valores das colunas. |
| MIN() | Retorna o menor valor da coluna de um grupo de linhas. |
| MAX() | Retorna o maior valor da coluna de um grupo de linhas. |
| STDDEV() | Retorna o desvio padrão da coluna. |
| VARIANCE() | Retorna a variância de coluna. |


### COMANDO SELECT, SINTAXE BÁSICA PARA MANUPULAÇÃO DE GRUPOS DE DADOS

Sintaxe básica do comando SELECT para manipulação de grupos de dados:
```
SELECT [ coluna, ] funçao_de_grupo (coluna)
   FROM tabela
[ WHERE condição ]
   [ GROUP BY coluna ]
     [ HAVING condiçao ]
  [  ORDER BY coluna [, coluna, ...]
```

Na qual:
* *SELECT*: Especifica as colunas necessárias para a pequisa.
* *FUNÇÃO DE GRUPO [coluna]*: Indica o nome da função que será utilizada e cujos dados da coluna definida serão consideradas como parâmetro para a função.
* *FROM*: Indica em que tabelas serão efetuadas estas pesquisas.
* *WHERE*: Condição para que se execute a pesquisa (filtra dados)
* *ORDER BY*: Especifica em que ordem deverá ser apresentada a pesquisa desejada, por qual campo estará ordenada (de forma crescente ou decrescente).
* *GROUP By [coluna]*: Permite criar os grupos de dados.
* *HAVING [condição]*: Similar a cláusula WHERE, aplicando somente a agrupamentos. Permite limitar(filtrar) os grupos a serem recuperados.
* *`<nome-tabela>`*: Tabela que terá os dados recuperados.
* *`<nome-coluna>`*: Colunas que serão recuperadas da tabela.
* *`<condição>`*: Condição (filtro) utilizado no momento da recuperação dos dados da tabela.

**NOTA**: A cláusula **GROUP BY** deve vir antes do **ORDER BY** e após o **WHERE**. A lista de colunas que se quer agrupar deve corresponder a mesma sequencia da cláusula **GROUP BY**.

## VISUALIZANDO A APLICAÇÃO DE UMA FUNÇÃO DE GRUPO
Para que possamos contas a quantidade de registros de uma determinada coluna, por exemplo, precisamos aplicar a função de grupo COUNT(), informando o argumento.

### FUNÇÃO DE GRUPO: *COUNT()*
A função de grupo COUNT() retorna números de linhas afetadas através do comando SELECT.

A função COUNT() pode ser utilizada de duas maneiras:
* **COUNT (*)**: Retorna o número de linhas/registros de uma tabela, inclusive linhas duplicadas e linhas contendo nulos em alguma coluna.
* **COUNT (coluna)**: Retorna o número de linhas não nulos da coluna, identificada por coluna.

Exemplo:
```
-- EXEMPLO – FUNÇÃO COUNT (*)
SELECT COUNT(*) FROM T_SIP_DEPARTAMENTO;
```
Resultado:
![Resultado do SELECT com COUNT(*)](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/04/24132907/on-image-318.jpg)

Caso informado a coluna na função COUNT(coluna), retornará a quantidade total de linhas da coluna especificada, com o conteúdo diferente de nulo.
```
-- EXEMPLO – FUNÇÃO COUNT (coluna)
SELECT COUNT(DT_TERMINO) FROM T_SIP_PROJETO;
```
Resultado:
![Resultado do SELECT com COUNT(coluna)](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/04/24132925/on-image-416.jpg)

### FUNÇÃO DE GRUPO: *SUM()*
A função de grupo SUM() retorna o somatório dos valores da coluna especificada através de um comando SELECT. Este comando, através da função SUM(coluna), retornará o somatório dos valores das linhas da coluna especificada, com o conteúdo diferente de nulo.

Exemplo:
```
-- EXEMPLO – FUNÇÃO SUM (coluna) 
SELECT SUM(VL_SALARIO_MENSAL) FROM T_SIP_FUNCIONARIO;
```

Resultado:
![Resultado do SELECT com SUM(coluna)](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/04/24133034/on-image-710.jpg)

### FUNÇÃO DE GRUPO: *AVG()*
A função de grupo AVG() retorna a média aritmética dos valores da coluna especificada, através de um comando SELECT. Este comando, através da função AVG(coluna), retornará a média aritmética dos valores das linhas da coluna especificada, com o conteúdo diferente de nulo.

Exemplo:
```
-- EXEMPLO – FUNÇÃO AVG (coluna) 
SELECT AVG(VL_SALARIO_MENSAL) FROM T_SIP_FUNCIONARIO;
```

Resultado:
![Resultado do SELECT com AVG (coluna)](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/04/24133107/on-image-810.jpg)

### FUNÇÃO DE GRUPO: *MIN()*
A função de grupo MIN() retorna o menor valor da coluna especificada.

Exemplo:
```
-- EXEMPLO – FUNÇÃO MIN (coluna) 
SELECT MIN(VL_SALARIO_MENSAL) FROM T_SIP_FUNCIONARIO;
```

Resultado:
![Resultado do SELECT com MIN(coluna)](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/04/24133143/on-image-99.jpg)

### FUNÇÃO DE GRUPO: *MAX()*
A função de grupo MAX() retorna o maior valor da coluna especificada.

Exemplo:
```
-- EXEMPLO – FUNÇÃO MAX (coluna) 
SELECT MAX(VL_SALARIO_MENSAL) FROM T_SIP_FUNCIONARIO;
```

Resultado:
![Resultado do SELECT com MAX(coluna)](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/04/24133204/on-image-109.jpg)

### FUNÇÃO DE GRUPO: *STDDEV()*
A função de grupo STDDEV() retorna o desvio padrão, referente aos valores da coluna especificada.

**Nota**: Em probabilidade e estatística, o desvio padrão é a medida mais comum de dispersão estatística. O desvio padrão define-se como a raiz quadrada da variância. Na teoria da probabilidade e na estatística, a variância de uma variável aleatória é uma medida da sua dispersão estatística. Indicando quão longe em geral os seus valores se encontram do valor esperado.

Exemplo:
```
-- EXEMPLO – FUNÇÃO STDDEV (coluna) 
SELECT STDDEV(VL_SALARIO_MENSAL) FROM T_SIP_FUNCIONARIO;
```

Resultado:
![Resultado do SELECT com STDDEV(coluna)](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/04/24133220/on-image-1116.jpg)

### FUNÇÃO DE GRUPO: *VARIANCE()*
A função de grupo VARIANCE() retorna a variância referente aos valores da coluna especificada,.

**Nota**: Na teoria da probabilidade e na estatística, a variância de uma variável aleatória é uma medida de dispersão estatística, indicando quão longe em geral os seus valores se encontram do valor esperado.

Exemplo:
```
-- EXEMPLO – FUNÇÃO VARIANCE (coluna) 
SELECT VARIANCE(VL_SALARIO_MENSAL) FROM T_SIP_FUNCIONARIO;
```

Resultado:
![Resultado do SELECT com VARIANCE(coluna)](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/04/24133234/on-image-1214.jpg)


### VISUALIZANDO A APLICAÇÃO DE UM AGRUPAMENTO

Um agrupamento possibilita a apresentação de um resultado para cada agrupamento especificado.

**Pontos de atenção**
* Para limitar o resultado de linhas que será envolvido no agrupamento, deve-se utilizar a cláusula WHERE e, em seguida, a cláusula GROUP BY.
* Todas as colunas individuais envolvidas na consulta, isto é, que não estão participando de funções de grupo, devem ser incluídas na clausula GROUP BY.
* A função de grupo não deve estar no GROUP BY.
* A coluna GROUP BY não precisa estar na cláusula SELECT.
* Pode-se usar a função de grupo na cláusula ORDER BY.

## DESVIO CONDICIONAL *(INSTRUÇÃO CASE)*
Podemos criar desvio condicionais, através da estrutura "CASE".

Sintaxe básica da instrução "CASE":
```
CASE 
     WHEN <CONDIÇÃO 1> THEN <VALOR 1>
     WHEN <CONDIÇÃO 2> THEN <VALOR 2>
     WHEN <CONDIÇÃO 3> THEN <VALOR 3>
     .
     .
     .
     ELSE <VALOR 4>
END
```

