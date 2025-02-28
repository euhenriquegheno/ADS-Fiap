# 7 - ARMAZENANDO E MANIPULANDO INFORMAÇÕES NO BANCO

DML: Data Manipulation Language - Linguagem de Manipulação de Dados.
São operadores de manutenção de dados de um bd;

* Inclusão ou inserção de dados de uma tabela;
* Alteração ou atualização de dados em uma tabela;
* Exclusão ou deleção de dados em uma tabela;

Populamos um banco de dados utilizando as instruções DML, que são: INSERT, UPDATE e DELETE.

## INCLUSÃO OU INSERÇÃO DE DADOS

Para inserir dados em uma tabela, utilizamos o comando INSERT.
Sintaxe básica do comando INSERT:
```
INSERT INTO  <nome-tabela> 
	[(<nome-coluna>, [<nome-coluna>],...)]
VALUES 
	(<conteúdo>, [<conteúdo>], ...);
```
Onde:
* `<nome-tabela>`: Tabela onde sera efetuada a inserção do registrou ou linha;
* `<nome-coluna>`: Colunas que terão os valores atribuidos;
* `<conteudo>`: Relação de valores a serem incluidos;

**IMPORTANTE**
Possíveis situações de ERROS durante a execução dos comando DML. **Comando INSERT**: Violação de chave primária (**Primary Key**). Violação de **UNIQUE** constraint. valor informado excede o tamanho de coluna. Tipo de dado incompatível com a coluna (caracteres em coluna).Violação de **CHECK** constraint. Violação de chave estrangeira (**Foreign Key**). Violação de **NOT NULL**.

### INSERÇÃO DE DADOS A PARTIR DE UMA SUBCONSULTA
A baixo, o código na linguagem SQL, que permite implementar a estrutura de bd utilizada para este exemplo:
```
-- CRIAR UMA TABELA EXEMPLO
-- A TABELA ARMAZENARÁ APENAS PROJETOS FINALIZADOS
CREATE TABLE T_SIP_COPY_PROJETO_FIN
(
    CD_PROJETO          NUMBER(5)       NOT NULL ,
    NM_PROJETO          VARCHAR2(40)    NOT NULL ,
    DT_INICIO           DATE            NOT NULL ,
    DT_TERMINO          DATE            NOT NULL 
);
-- CHAVE PRIMARIA DA TABELA 
   ALTER TABLE T_SIP_COPY_PROJETO_FIN
ADD CONSTRAINT PK_SIP_COPY_PROJETO_FIN
   PRIMARY KEY (CD_PROJETO);
```

Exemplo de comando INSERT, utilizando uma subconsulta (subquery). Com esta instrução, todas as linhas da tabela "PROJETO" serão copiadas para a tabela "T_SIP_COPY_PROJETO_FIN".

Observe que utilizamos um comando SELECT (consulta), por meio do qual recuperamos todas as linhas da tabela "PROJETO", que instrução de consulta é o q chamamos de subquery.

As linhas recuperadas através desta consulta serão inseridas na tabela "T_SIP_COPY_PROJETO_FIN".

Na primeira instrução SQL, declaramos todas as colunas no comando "INSERT" e o comando "SELECT". É importante ressaltar que as colunas das tabelas sejam equivalentes e estejam na mesma ordem para instrução ser executada com sucesso.
```
-- REALIZANDO A CÓPIA DOS DADOS DE UMA TABELA PARA OUTRA
-- UTILIZANDO O COMANDO INSERT E O COMANDO SELECT 
-- SUBCONSULTA OU SUBQUERY)
INSERT INTO T_SIP_COPY_PROJETO_FIN 
       (CD_PROJETO, NM_PROJETO, DT_INICIO, DT_TERMINO)
 (SELECT CD_PROJETO, NM_PROJETO, 
         DT_INICIO, DT_TERMINO
    FROM T_SIP_PROJETO
   WHERE DT_TERMINO IS NOT NULL);
```

Na segunda instrução SQL, omitimos as colunas no "INSERT" e no comando "SELECT", podemos escrever a instrução desta maneira, devido as colunas das duas tabelas estarem na mesma ordem. É importante ressaltar, que as colunas das tabelas sejam equivalentes e estejam na mesma ordem, para a instrução ser executada com sucesso.
```
-- REALIZANDO A CÓPIA DOS DADOS DE UMA TABELA PARA OUTRA
-- UTILIZANDO O COMANDO INSERT E O COMANDO SELECT 
-- SUBCONSULTA OU SUBQUERY)
INSERT INTO T_SIP_COPY_PROJETO_FIN 
       (CD_PROJETO, NM_PROJETO, DT_INICIO, DT_TERMINO)
 (SELECT CD_PROJETO, NM_PROJETO, 
         DT_INICIO, DT_TERMINO
    FROM T_SIP_PROJETO
   WHERE DT_TERMINO IS NOT NULL);
```
O operador especial "IS NOT NULL" permite validar se o conteúdo da coluna (campo) não é nulo.

## ALTERAÇÃO OU ATUALIZAÇÃO DE DADOS

Utilizamos o comando UPDATE.
Sintaxe básica do comando UPDATE:
```
UPDATE <nome-tabela>
SET <nome-coluna> = <novo conteúdo para o campo>         
  [,<nome-coluna> = <novo conteúdo para o campo>]
[WHERE <condição>]
```
Na qual:
* `<nome-tabela>`: Tabela onde sera efetuada a atualização do registrou ou linha;
* `<nome-coluna>`: Colunas que terão os valores atualizados;
* `<conteudo>`: Novo conteúdo atribuído a coluna;
* `<condição>`: Critério que indicará quais linhas serão afetadas, durante a atualização;

**IMPORTANTE**
Possíveis situações de ERROS durante a execução dos comando DML. **Comando UPDATE**: Violação de chave primária (**Primary Key**). Violação de **UNIQUE** constraint. valor informado excede o tamanho de coluna. Tipo de dado incompatível com a coluna (caracteres em coluna).Violação de **CHECK** constraint. Violação de chave estrangeira (**Foreign Key**). Violação de **NOT NULL**.

## EXCLUSÃO OU DELEÇÃO DE DADOS
Utilizamos o comando DELETE.
Sintaxe básica do comando DELETE:
```
DELETE FROM  <nome-tabela>
	[WHERE <condição>]
```
Na qual:
* `<nome-tabela>`: Tabela onde sera efetuada a exclusão do registrou ou linha;
* `<condição>`: Critério que indicará quais linhas serão afetadas, durante a exclusão;

**IMPORTANTE**
Possíveis situações de ERROS durante a execução dos comandos DML. **Comando DELETE:** Violação de chave estrangeira (**Foreign Key**).

## MANIPULAÇÃO DE CAMPOS DATA/HORA

Para manipulamos data/hora, devemos utilizar a função TO_DATE() do Oracle para informar o formato da data manipulada.

Utilizamos a função TO_DATE(), informamos a data e o formato que esta data está sendo enviada ao SGBDR.

A função TO_DATE(data, formato) é uma função do Oracle (PL/SQL) que converte o parâmetro informado em uma data no formato especificado.

Exemplo:
```
INSERT INTO <nome-tabela> [<nome-coluna-data>]
	VALUES (TO_DATA(<conteudo_data>, 'DD/MM/YYYY'));
```

## INFORMAÇÕES
Durante a manipulação dos dados, devemos considerar.

Quando um erro ocorrer, o registro (linha) não será inserido/alterado/excluído do bd.

O comando INSERT/UPDATE/DELETE é efetivado somente após um COMMIT.

É possível desfazer a operação de INSERT/UPDATE/DELETE através do comando ROLLBACK. Mas atenção, após o COMMIT das transações, não será possível desfazer operações, nem mesmo utilizando o ROLLBACK.

## ERROS COMUNS AO EXECUTAR *INSERT, UPDATE E DELETE*

### ERROS DE VIOLAÇÃO DE *PRIMAY KEY*
O erro de violação de chave primária ocorre na tentativa de inserção de um novo registro (linhas) ou atualização de um registro já existente, utilizando uma chave primária já existente (cadastrada) na tabela.

A mensagem de erro apresenta o texto `Restrição exclusica <nome-da-constraint> violada`.

### ERROS DE VIOLAÇÃO DE UNIQUE CONSTRAINT
O erro de violação de "unique constraint" ocorre na tentativa de inserção de um novo registro ou atualização de um registro ja existente, utilizando um contpeudo que não pode ser repetido na coluna declaraca como "unique constraint".

A mensagem de erro apresenta o texto `Restrição exclusiva <nome-da-constraint> violada`.

### ERROS DE VIOLAÇÃO DE FOREIGN KEY
O erro de violação de chave estrangeira ocorre na tentativa de inserção de um novo registro ou atualização de um registro ja existente, utilizando um valor para a chave estrangeira, que não esta definido como um valor para a chave primária.

A mensagem de erro apresenta o texto: `Restrição de integridade <nome-da-constraint> violada - chave mãe não localizada`.

### ERROS DE VIOLAÇÃO DE CONSTRAINT
O erro de violação de "check constraint" ocorre na tentativa de inserção de um novo registro ou atualização de um registro já existente, utilizando um valor, que viole a regra de validação estabelecida na "check constraint".

A mensagem de erro apresenta o texto `Restrição de verificação <nome-da-constraint> violada`.

### ERROS RELATIVOS A PRECISÃO DE UM CAMPO
O erro relativo a precisão de um campo, ocorre na tentativa de inserção de um novo registro ou atualização de um registro já existente, utilizando um valor com precisão que excede o tamanho especifico para a coluna.

A mensagem de erro apresenta o texto `valor maior que a precisão especificada usado para a coluna`.

### ERRO DE TIPO DE DADO INVÁLIDO
O erro de tipo de dado inválido ocorre na tentativa de inserção de um novo registro ou atualização de um registro ja existente, utilizando um valor cujo conteúdo não é compatível com a definição do tipo de dado referente a coluna.

A mensagem de erro apresenta o texto `número inválido`.

### ERRO REFERENTE A VALORES INSUFICIENTES PARA INSERÇÃO
O erro referente a valores insuficientes para inserção ocorre na tentativa de inserção de um novo registro, informando menos valores do que o esperado, conforme a estrutura da tabela.

A mensagem de erro apresenta o texto `não há valores suficientes - not enough values`.

### ERRO REFERENTE A VALORES DEMAIS PARA INSERÇÃO
O erro referente a valores demais para inserção, ocorre na tentativa de inserção de um novo registro, informando mais valores do que o esperado, conforme a estrutura da tabela.

A mensagem de erro apresenta o texto `valores demais - too many values`.













