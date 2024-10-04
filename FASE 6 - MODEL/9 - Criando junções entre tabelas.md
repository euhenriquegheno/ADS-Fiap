# 9 - CRIANDO UNÇÕES ENTRE TABELAS

## COMANDOS DRS

### JOIN
Consultas que recuperam dados de duas ou mais tabelas, que chamamos de junções.

### JUNÇÃO DE TABELAS

O comando SELECT a partir de junções (JOIN) nos permite a pesquisa em múltiplas tabelas. Esta pesquisa é necessária, quando precisamos recuperar dados que estão distribuídos em várias tabelas.

A operação JUNÇÃO (JOIN) é usada para combinas registros e linhas relacionados dentro de único registro/linha. Esta operação nos permite processas os relacionamentos entre os registros (linhas) das tabelas.

O critério de relacionamento estabelecido pode ser baseado em junções idênticas (equijoins), não identicas (non-equijoins), internas (inner join), externa (left join, rigth join ou full join) ou auto junções (self-join).

### CONDIÇÕES DE *JOIN*
**EQUIJOINS**: Utilizam o operador de igualdade ( = ). São consideradas como consequência de um modelo relaciona, ou seja, espelham a relação dos dados representados em um modelo E-R. São as relações em que temos a presença das chaves primárias e estrangeira.

**NON-EQUIJOINS**: Utilizam um operador que não é o de igualdade, como <, >, BETWEEN etc. São consideradas como junções atípicas, em que não há a presença de chave primaria e nem mesmo chave estrangeira. Os relacionamentos são feitos por meio de colunas, normalmente não chaves primarias nem únicas, mas que possuem algum tipo de relação associada a necessidade de negócio, para que possamos expressar a junção.

### TIPO DE *JOIN*
* **Joins Internas:** Retornam um registro somente quando as colunas da junção tiverem valores que satisfaçam a condição da junção.
* **Joins Externas:** Retornam um registro mesmo quando uma das colunas na condição de junção tiver um valor nulo.
* **Autojoins:** Retornam registros, possuem valores associados na mesma tabela.

### COMANDO *SELECT* UTILIZANDO JUNÇÕES
Sintaxe básica do comando SELECT utilizando junções:
```
SELECT tabela1.coluna, tabela2.coluna
FROM tabela1
	[CROSS JOIN tabela2] |
	[NATURAL JOIN tabela2] |
	[JOIN tabela2 USING (nome_coluna)] |
	[JOIN tabela2
	ON(tabela1.nome_coluna = tabela2.nome_coluna)] |
	[LEFT|RIGHT|FULL OUTER JOIN tabela2
	ON (tabela1.nome_coluna = tabela2.nome_coluna)];
```

## PESQUISA EM MÚLTIPLAS TABELAS

### QUALIFICADORES DE NOME
Consistem no nome da tabela seguido de um ponte e o nome da coluna da tabela. Exemplo:
![Exemplo de código-fonte SQL–comando SELECT com qualificador de nomes](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/03/21135635/On-image-codigo-4.jpg)

Colocar a identificação (qualificador) é opcional, porém é uma prática recomendada para facilitar o entendimento do comando. Quando estivermos recuperando colunas com o mesmo nome, em tabelas diferentes, se faz necessário informar a tabela que se deseja recuperar a informação, e neste caso, a utilização do qualificador se torna obrigatória.

Exemplo:
```
-- Exemplo de consulta com qualificador de nomes
SELECT   T_SIP_FUNCIONARIO.NR_MATRICULA ,
         T_SIP_FUNCIONARIO.CD_DEPTO     ,
         T_SIP_FUNCIONARIO.DT_ADMISSAO  ,
         T_SIP_FUNCIONARIO.VL_SALARIO_MENSAL
  FROM   T_SIP_FUNCIONARIO ;
```

### ALIAS - APELIDO PARA TABELAS
Podemos também utilizar **ALIAS - APELIDO PARA TABELAS**
Exemplo do SQL sem ALIAS/APELIDO:
```
-- Exemplo de consulta a duas tabelas sem ALIAS
SELECT T_SIP_FUNCIONARIO.NM_FUNCIONARIO ,
       T_SIP_FUNCIONARIO.CD_DEPTO       ,
       T_SIP_DEPARTAMENTO.NM_DEPTO
  FROM T_SIP_DEPARTAMENTO INNER JOIN T_SIP_FUNCIONARIO 
    ON T_SIP_DEPARTAMENTO.CD_DEPTO = T_SIP_FUNCIONARIO.CD_DEPTO;
```

Exemplo com ALIAS/APELIDO para as tabelas:
```
-- Exemplo de consulta a duas tabelas com ALIAS
SELECT F.NM_FUNCIONARIO ,
       F.CD_DEPTO       ,
       D.NM_DEPTO
  FROM T_SIP_DEPARTAMENTO D INNER JOIN T_SIP_FUNCIONARIO F
       ON (D.CD_DEPTO = F.CD_DEPTO);
```

### *CROSS JOIN* JUNÇÃO CRUZADA
É conhecida também por **Produto Cartesiano**.

**Ocorrerá um produto cartesiano sempre que:**
* Não houver uma condição para união (ausencia da cláusula WHERE).
* Condição de união entre as tabelas inválida (cláusula WHERE incorreta).
* Todas as linhas da primeira tabela estiverem unidas a todas as linhas da segunda tabela.

Para evitar um produto cartesiano, utilize uma condição válida para junção na cláusula WHERE.

Exemplo de junção cruazada (CROSS JOIN) entre as tabelas: "DEPARTAMENTO" e "FUNCIONARIO"
Tabela Departamento:
![Conteúdo da tabela DEPARTAMENTO](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07132221/on-image-613.jpg)

Tabela Funcionário:
![Conteúdo da tabela FUNCIONARIO](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07132232/on-image-711.jpg)

Comando SQL:
```
-- UTILIZANDO O PADRÃO ANSI SQL/99
-- CROSS JOIN 
SELECT * 
  FROM T_SIP_DEPARTAMENTO , 
       CROSS JOIN T_SIP_FUNCIONARIO;
```

Resultado:
![Resultado do CROSS JOIN](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07133727/on-image-812.jpg)

As linhas da primeira tabela forma combinadas com as linhas da segunda tabela, demonstrando um resultado na maior parte das vezes indesejado.

Então há necessidade de colocar a condição após a cláusula WHERE associando a chave primária e estrangeira das tabelas. Utilize o modelo de dados e visualize  relacionamento para facilitar.


### *INNER JOIN* JUNÇÃO INTERNA
A junção do tipo **INNER JOIN** segue a **padronização ANSI** e implica, por sua vez, em criar a **junção interna entre duas tabelas**.

Nesse tipo de junção, caso sejam unidas duas tabelas, serão exibidos todos os dados existentes nas duas tabelas envolvidas na consulta, em que encontrarmos correspondência entre as chaves primaria e estrangeira.

A condição de junção é estabelecida na cláusula ON, em que comparamos a chave primária a chave estrangeira com o objetivo de recuperar a interseção entre as tabelas.

Sintaxe:
```
SELECT * FROM <nome da tabela1> <apelido da tabela 1>
INNER JOIN <nome da tabela 2> <apelido da tabela 2>
	ON <apelido da tabela 1>.<coluna tabela 1> = <apelido da tabela 2>.<coluna tabela 2>
```

Exemplo de uso:
```
-- EXEMPLO - INNER JOIN – Padrão SQL/99
  SELECT F.NR_MATRICULA, F.CD_DEPTO,
         D.NM_DEPTO, F.NM_FUNCIONARIO   
    FROM T_SIP_DEPARTAMENTO D INNER JOIN T_SIP_FUNCIONARIO  F 
         ON ( D.CD_DEPTO = F.CD_DEPTO )
ORDER BY D.NM_DEPTO;
```

Resultado:
![Resultado do INNER JOIN](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07132303/on-image-109.jpg)


### *INNER JOIN* COM CLÁUSULA *USING* - JUNÇÃO INTERNA
Caso as colunas tenham o mesmo nome, mas tipos de dados diferentes, podemos modificar a cláusula **INNER JOIN** com a  **cláusula USING** para especificar as colunas que devem ser usadas em uma junção.
**Não utilize apelido ou nome de tabelas nas colunas** em que a referencia for feita (chave primária/chave estrangeira).

Exemplo:
```
-- EXEMPLO - INNER JOIN com a cláusula USING
  SELECT F.NR_MATRICULA, 
         CD_DEPTO,
         D.NM_DEPTO, F.NM_FUNCIONARIO 
    FROM T_SIP_DEPARTAMENTO D INNER JOIN T_SIP_FUNCIONARIO  F
         USING ( CD_DEPTO )
ORDER BY NM_DEPTO;
```

Resultado:
![Resultado do INNER JOIN com USING](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07132303/on-image-109.jpg)


### JUÇÕES EXTERNAS
Junção externa é utilizada para recuperar as linhas de um EQUIJOIN, sendo que em alguma das tabelas pode não existir registros (linhas) correspondentes. A junção externa pode ser esquerda, direita ou completa.

Existem 3 formas de realizar a união externa:
* LEFT OUTER JOIN: A junção externa a esquerda recupera todas as linhas do EQUIJOIN, além das que não possuem correspondentes na tabela a esquerda da operação.
* RIGHT OUTER JOIN: A junção externa a direita recupera todas as linhas do EQUIJOIN, além das que não possuem correspondentes na tabela a direita da operação.
* FULL OUTER JOIN: A junção completa recupera todas as linhas do EQUIJOIN, além das que não possuem correspondentes na tabela a direita e a esquerda da operação.

### *LEFT OUTER JOIN* - JUNÇÕES EXTERNAS
Nesse tipo de junção, todas as linhas da tabela a esquerda serão recuperadas, independentemente da existência de ocorrência relacionadas na tabela da direita, ou seja, correspondência entre a chave primária a chave estrangeira.

Preserva as linhas sem correspondência da primeira tabela (esquerda), juntando-as com uma linha nula na forma da segunda tabela (direita).

Denomina-se união regular (EQUIJOIN) aquelas uniões que tem a cláusula WHERE indicando a chave primária a estrangeira das tabelas afetadas pelo comando SELECT.

Exemplos de junção externa:
| LEFT OUTER JOIN | LEFT OUTER JOIN WHERE NULL |
|--|--|
| ![LEFT OUTER JOIN](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07132328/on-image-1212.jpg) | ![LEFT OUTER JOIN com WHERE NULL](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07132338/on-image-1310.jpg)
|

 A condição de junção é estabelecida na cláusula ON, na qual comparamos a chave primária a chave estrangeira com o objetivo de recuperar a intersecção ou não, entre as tabelas.

Exemplo:
```
-- EXEMPLO LEFT OUTER JOIN - PADRÃO SQL/99
SELECT   P.CD_PROJETO, P.NM_PROJETO, P.DT_INICIO,
               I.NR_MATRICULA, I.DT_ENTRADA         
  FROM   T_SIP_PROJETO P LEFT OUTER JOIN T_SIP_IMPLANTACAO I
         ON ( P.CD_PROJETO = I.CD_PROJETO );
```

Resultado:
![Resultado do LEFT OUTER JOIN](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07134205/on-image-148.jpg)

### *RIGHT OUTER JOIN* - JUNÇÕES EXTERNAS

Nesse tipo de junção, todas as linhas da tabela a direita serão recuperadas, independentemente da existência de ocorrência relacionadas na tabela da esquerda, ou seja, correspondência entre a chave primária a chave estrangeira.

Preserva as linhas sem correspondência da primeira tabela (direita), juntando-as com uma linha nula na forma da segunda tabela (esquerda).

Denomina-se união regular (EQUIJOIN) aquelas uniões que tem a cláusula WHERE indicando a chave primária a estrangeira das tabelas afetadas pelo comando SELECT.

Exemplo:
| RIGHT OUTER JOIN | RIGHT OUTER JOIN - WHERE NULL |
|--|--|
| ![RIGHT OUTER JOIN](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07132359/on-image-165.jpg) | ![RIGHT OUTER JOIN com WHERE NULL](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07132405/on-image-174.jpg) |

A condição de junção é estabelecida na cláusula ON, na qual comparamos a chave primária a chave estrangeira com o objetivo de recuperar a intersecção ou não, entre as tabelas.

Exemplo:
```
-- EXEMPLO RIGHT OUTER JOIN - PADRÃO SQL/99
SELECT F.NR_MATRICULA,
       I.CD_PROJETO, I.DT_ENTRADA,I.DT_SAIDA
FROM  T_SIP_IMPLANTACAO I RIGHT OUTER JOIN T_SIP_FUNCIONARIO F
         ON ( F.NR_MATRICULA = I.NR_MATRICULA );
```

Resultado:
![Resultado do RIGHT OUTER JOIN](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07134451/on-image-185.jpg)

### *FULL OUTER JOIN* - JUNÇÕES EXTERNAS
Nesse tipo de junção, todas as linhas da tabela a direita e a esquerda serão recuperadas, independentemente da existência de ocorrência relacionadas na tabela da esquerda ou da direita, ou seja, correspondência entre a chave primária a chave estrangeira.

Preserva as linhas sem correspondência da primeira tabela (direita ou esquerda), juntando-as com uma linha nula na forma da segunda tabela (esquerda ou direita).

Denomina-se união regular (EQUIJOIN) aquelas uniões que tem a cláusula WHERE indicando a chave primária a estrangeira das tabelas afetadas pelo comando SELECT.

Exemplo:
| FULL OUTER JOIN | OUTER JOIN - WHERE NULL |
|--|--|
| ![FULL OUTER JOIN](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07132424/on-image-204.jpg) | ![FULL OUTER JOIN com WHERE NULL](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07132435/on-image-2112.jpg) |

A condição de junção é estabelecida na cláusula ON, na qual comparamos a chave primária a chave estrangeira com o objetivo de recuperar a intersecção ou não, entre as tabelas.

Tabela exemplo:
![Modelo de dados com relacionamento opcional](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07132444/on-image-229.jpg)

Exemplo:
```
-- EXEMPLO FULL OUTER JOIN - PADRÃO SQL/99
SELECT EC.CD_EMPRESA_CONV,
       EC.DS_RAZAO_SOCIAL,
       M.NR_MATRICULA_ALUNO,
       M.CD_ALUNO
  FROM T_SCA_EMPRESA_CONV EC FULL OUTER JOIN T_SCA_MATRICULA M
       ON (EC.CD_EMPRESA_CONV = M.CD_EMPRESA_CONV);
```

Resultado:
![Resultado do FULL OUTER JOIN](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2024/03/07134834/on-image-255.jpg)


### SELF JOIN OU AUTOJUNÇÃO
As junções do tipo **SELF JOIN** são utilizadas em casos que temos no modelo de dados, a figura do **auto relacionamento (relacionamento recursivo)**.

A condição de junção é estabelecida na cláusula ON, em que comparamos a chave primária a chave estrangeira com o objetivo de recuperar a intersecção entre a própria tabela.

### *NON-EQUIJOINS* - JUNÇÕES NÃO IDENTICAS
União de tabelas sem colunas em comum (non-equijoin) é um tipo de junção que não requer a comparação entre as chaves primárias e estrangeiras.

A condição de junção é estabelecida na cláusula WHERE, na qual  comparamos os campos que possuem uma faixa de valores correspondentes.













