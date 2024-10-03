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



