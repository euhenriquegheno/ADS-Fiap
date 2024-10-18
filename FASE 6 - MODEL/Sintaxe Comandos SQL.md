# SINTAXE DOS COMANDOS SQL

## TIPOS
**DDL (DATA DEFINITION LANGUAGE)**
CREATE, ALTER, DROP, TRUNCATE, RENAME;

**DML (DATA MANIPULATION LANGUAGE)**
INSERT, UPDATE, DELETE;

**DCL (DATA CONTROL LANGUAGE)**
GRANT, REVOKE;


## COMANDOS DDL (DATA DEFINITION LANGUAGE)

## Criação de tabela
```sql
CREATE TABLE <nome-tabela> (
<nome-coluna> <tipo-do-dado> [NOT NULL]
PRIMARY KEY (nome-coluna-chave)
FOREIGN KEY (nome-coluna-chave-estrangeira) 
REFERENCES <nome-tabela-pai> (nome-coluna-chave-primária));
```

## Alteração da tabela
```sql
ALTER TABLE <nome-tabela>
DROP COLUMN <nome-coluna>
ADD 	<nome-coluna> <tipo-do-dado> [NOT NULL]
[NOT NULL WITH DEFAULT] 
RENAME <nome-coluna> <novo-nome-coluna>
MODIFY <nome-coluna> <tipo-do-dado> [NULL]
[NOT NULL]
```

**AUMENTAR TAMANHO DE COLUNA**
```sql
-- AUMENTANDO O TAMANHO DE UMA COLUNA EM UMA TABELA EXISTENTE
ALTER TABLE <nome-tabela>
     MODIFY <nome-coluna> VARCHAR2(80);
```

**MODIFICAR O TIPO DE DADO**
```sql
-- MODIFICANDO O TIPO DE DADO DE UMA COLUNA EM 
-- UMA TABELA EXISTENTE   
ALTER TABLE <nome-tabela>
     MODIFY <nome-coluna> CHAR(30);
```

**REMOVER UMA COLUNA DA TABELA**
```sql
-- REMOVENDO UMA COLUNA DA TABELA
ALTER TABLE <nome-tabela> DROP COLUMN <nome-coluna>;
```

**REMOVER MAIS DE UMA COLUNA DA TABELA**
```sql
-- REMOVENDO UMA COLUNA DA TABELA
ALTER TABLE <nome-tabela> DROP (<nome-coluna>, <nome-coluna>);
```

**REMOÇÃO DE CHAVE PRIMÁRIA**
```sql
-- REMOVENDO CONSTRAINT CHAVE PRIMÁRIA
ALTER TABLE <nome-tabela> DROP CONSTRAINT <nome-da-pk>;

-- REMOVENDO CONSTRAINT CHAVE PRIMÁRIA COM RELACIONAMENTOS
ALTER TABLE <nome-tabela> DROP CONSTRAINT <nome-da-pk> CASCADE;
```

**REMOÇÃO  DE FOREIGN KEY**
```sql
-- REMOVENDO CONSTRAINT CHAVE ESTRANGEIRA
    ALTER TABLE <nome-tabela>
DROP CONSTRAINT <FK_NOME_CONSTRAINT_FOREIGN_KEY>;
```

**RENOMEANDO UMA TABELA**
```sql
-- RENOMEANDO UMA TABELA
ALTER TABLE <nome-tabela> RENAME TO <novo-nome-tabela>;
```

**RENOMEANDO UMA COLUNA**
```sql
-- RENOMEANDO UMA COLUNA
ALTER TABLE <nome-tabela> RENAME COLUMN 
            <nome-coluna> TO <novo-nome-coluna>;
```

## Exclusão de tabela
```sql
DROP TABLE <nome-tabela>;
```
```sql
-- EXCLUIR A TABELA ELIMINANDO AS REFERÊNCIAS
DROP TABLE t_sip_departamento CASCADE CONSTRAINTS;
```

## Eliminar todos dados sem eliminar a estrutura
```sql
-- EXCLUIR TODOS OS DADOS DA TABELA, SEM ELIMINAR A ESTRUTURA
TRUNCATE TABLE < nome-tabela >;
```

## Adicionar comentário
```sql
-- COMENTÁRIO SOBRE TABELA E CAMPOS
COMMENT ON TABLE T_SIP_DEPARTAMENTO IS 'EXEMPLO DE COMENTÁRIO PARA A TABELA';
COMMENT ON COLUMN T_SIP_DEPARTAMENTO.SG_DEPTO IS 'EXEMPLO DE COMENTÁRIO DE COLUNA';
```

## Implementação de Constraint
**PRIMARY KEY**
```sql
-- IMPLEMENTAÇÃO DA PRIMARY KEY COM ALTER TABLE
   ALTER TABLE t_sip_departamento 
ADD CONSTRAINT pk_sip_departamento 
   PRIMARY KEY ( cd_depto );
```

**UNIQUE**
```sql
-- IMPLEMENTAÇÃO DA CONSTRAINT UNIQUE
   ALTER TABLE t_sip_departamento 
ADD CONSTRAINT un_sip_depto_nome 
        UNIQUE ( nm_depto );
```

**CHECK**
```sql
-- IMPLEMENTAÇÃO DA CONSTRAINT CHECK
   ALTER TABLE t_sip_projeto 
ADD CONSTRAINT ck_sip_projeto_data 
         CHECK ( dt_termino > dt_inicio );
```

**FOREIGN KEY**
```sql
-- IMPLEMENTAÇÃO DA CONSTRAINT FOREIGN KEY
   ALTER TABLE t_sip_funcionario
ADD CONSTRAINT fk_sip_func_depto 
   FOREIGN KEY ( cd_depto )
    REFERENCES t_sip_departamento ( cd_depto );
```

## Criando uma Sequencia
```sql
CREATE SEQUENCE nome_sequencia
[ START WITH num_inicio ]
[ INCREMENT BY  num_incremento ]
[ { MAXVALUE  num_maximo | NOMAXVALUE } ]
[ { MINVALUE  num_minimo | NOMINVALUE } ]
[ { CYCLE | NOCYCLE} ]
[ { CACHE   num_cache | NOCACHE } ]
[ { ORDER | NOORDER } ];
```

Exemplo:
```sql
-- COMENTÁRIOS SOBRE A ESTRUTURA DA SEQUENCE
CREATE SEQUENCE <nome_da_sequencia>
     START WITH 1  -- Primeiro número a ser gerado
   INCREMENT BY 1  -- Valor do incremento (≠ zero)
     NOMAXVALUE    -- Sem definição de limite máximo
    CACHE 50 -- O default é "CACHE 20" 
  NOCYCLE ;  -- Após chegar ao limite, não reinicia
```

**NEXTVAL**: Pode causar GAP;
**CURRVAL**: Não causa GAP;

## *Identify* no Oracle Database
Identify é um gerado de sequencia. É criado como parte do CREATE TABLE.
```sql
-- COLUNA IDENTITY CRIADA COM GENERATE ALWAYS
CREATE TABLE <nome-tabela> (
    <nome-coluna1> INTEGER GENERATED ALWAYS AS IDENTITY
    (START WITH 2 INCREMENT BY 2 MAXVALUE 200 NO CYCLE),
    <nome-coluna2> STRING,
    PRIMARY KEY (<nome-coluna1>)
);
```

## COMANDOS DML (DATA MANIPULATION LANGUAGE)
## Iserção de dados em uma tabela
```sql
INSERT INTO  <nome-tabela> 
	(<nome-coluna>, <nome-coluna>,...)
VALUES 
	(<conteúdo>, <conteúdo>, ...);
```

**INSERÇÃO DE DADOS A PARTIR DE UMA SUBCONSULTA**
```sql
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

## Atualização de dados em uma tabela
```sql
UPDATE <nome-tabela>
SET <nome-coluna> = <novo conteúdo para o campo>         
  ,<nome-coluna> = <novo conteúdo para o campo>
WHERE <condição>
```

## Deleção de dados de uma tabela
```sql
DELETE FROM  <nome-tabela>
	WHERE <condição>
```

## COMANDOS DRS (DATA RETRIEVE LANGUAGE) OU DQL (DATA QUERY LANGUAGE)

## Seleção de dados de uma tabela

```sql
SELECT [ DISTINCT | ALL] { * | coluna  [, coluna, … ] }
  FROM tabela
 WHERE condição
    ORDER BY coluna [, coluna, ...]
```

**OPERADOR BETWEEN**
```sql
-- OPERADOR BETWEEN
SELECT NR_MATRICULA, NM_FUNCIONARIO, 
 CD_DEPTO, VL_SALARIO_MENSAL  
FROM   T_SIP_FUNCIONARIO 
WHERE  VL_SALARIO_MENSAL BETWEEN 1000 AND 2500;
```

**OPERADOR IN**
```sql
-- OPERADOR IN
SELECT NR_MATRICULA, NM_FUNCIONARIO, CD_DEPTO
  FROM   T_SIP_FUNCIONARIO
 WHERE  CD_DEPTO IN (1,2,3);
```

**OPERADOR DE CONCATENAÇÃO**
   ```sql
-- EXIBIR O TEXTO: "O FUNCIONARIO <NOME> FOI 
-- ADMITIDO EM <DATA ADMISSAO>"
SELECT nr_matricula,
 'O FUNCIONARIO ' || 
 NM_FUNCIONARIO ||
 ', FOI ADMITIDO EM: ' || 
 DT_ADMISSAO "TEXTO"
  FROM T_SIP_FUNCIONARIO;
   ```

## JUNÇÃO DE TABELAS
* Identicas: equijoins;
* Não identicas: non-equijoins;
* Interna: inner join;
* Externas: left join, right join ou full join;
* Autojunções: self-join;

Aqui está uma explicação simples das diferentes junções (joins) utilizadas em SQL, com a respectiva sintaxe ao lado:

1. **CROSS JOIN**:
   - **Descrição**: Faz o produto cartesiano entre duas tabelas, ou seja, combina cada linha da primeira tabela com todas as linhas da segunda. Gera um grande número de combinações.
   - **Sintaxe**: 
     ```sql
     SELECT tabela1.coluna, tabela2.coluna
     FROM tabela1
     CROSS JOIN tabela2;
     ```

2. **NATURAL JOIN**:
   - **Descrição**: Faz a junção automaticamente entre colunas que têm o mesmo nome e tipo nas duas tabelas. Não é necessário especificar explicitamente as colunas.
   - **Sintaxe**: 
     ```sql
     SELECT tabela1.coluna, tabela2.coluna
     FROM tabela1
     NATURAL JOIN tabela2;
     ```

3. **JOIN USING**:
   - **Descrição**: Faz a junção entre tabelas usando uma coluna comum, que deve ter o mesmo nome nas duas tabelas.
   - **Sintaxe**: 
     ```sql
     SELECT tabela1.coluna, tabela2.coluna
     FROM tabela1
     JOIN tabela2 USING (nome_coluna);
     ```

4. **INNER JOIN** (com condição explícita):
   - **Descrição**: Retorna apenas as linhas que têm correspondência entre as duas tabelas, baseado em uma condição de junção especificada na cláusula `ON`.
   - **Sintaxe**: 
     ```sql
     SELECT tabela1.coluna, tabela2.coluna
     FROM tabela1
     JOIN tabela2
     ON tabela1.nome_coluna = tabela2.nome_coluna;
     ```

5. **LEFT|RIGHT|FULL OUTER JOIN**:
   - **Descrição**:
     - **LEFT OUTER JOIN**: Retorna todas as linhas da tabela da esquerda (tabela1), mesmo que não haja correspondência na tabela da direita (tabela2). Se não houver correspondência, o valor da tabela2 será `NULL`.
     - **RIGHT OUTER JOIN**: Retorna todas as linhas da tabela da direita (tabela2), mesmo que não haja correspondência na tabela da esquerda (tabela1). Se não houver correspondência, o valor da tabela1 será `NULL`.
     - **FULL OUTER JOIN**: Retorna todas as linhas de ambas as tabelas, com `NULL` preenchido onde não houver correspondência.
   - **Sintaxe**:
     ```sql
     SELECT tabela1.coluna, tabela2.coluna
     FROM tabela1
     LEFT OUTER JOIN tabela2
     ON tabela1.nome_coluna = tabela2.nome_coluna;

     SELECT tabela1.coluna, tabela2.coluna
     FROM tabela1
     RIGHT OUTER JOIN tabela2
     ON tabela1.nome_coluna = tabela2.nome_coluna;

     SELECT tabela1.coluna, tabela2.coluna
     FROM tabela1
     FULL OUTER JOIN tabela2
     ON tabela1.nome_coluna = tabela2.nome_coluna;
     ```

Esses são os principais tipos de junções, cada um com seu propósito dependendo do tipo de relação e resultados desejados entre as tabelas.

Aqui está uma explicação sobre o **`USING`** e a **auto junção (self join)** em SQL:

### 1. **`USING`**:
   - **Descrição**: O `USING` é usado para especificar uma coluna ou um conjunto de colunas comuns entre as duas tabelas nas quais será feita a junção. Ele simplifica a sintaxe quando as colunas têm o mesmo nome em ambas as tabelas.
   - **Quando Usar**: Use o `USING` quando as colunas de junção nas duas tabelas tiverem exatamente o mesmo nome. Ele é uma forma simplificada do `ON`, evitando a repetição da coluna.

   - **Sintaxe**:
     ```sql
     SELECT tabela1.coluna, tabela2.coluna
     FROM tabela1
     JOIN tabela2
     USING (nome_coluna);
     ```

   - **Exemplo**:
     Suponha que você tenha duas tabelas `pedidos` e `clientes` com uma coluna comum chamada `cliente_id`. Você pode usar `USING` para fazer a junção nessa coluna:
     ```sql
     SELECT pedidos.numero_pedido, clientes.nome
     FROM pedidos
     JOIN clientes
     USING (cliente_id);
     ```
     Aqui, o SQL faz automaticamente a junção entre as tabelas `pedidos` e `clientes` com base na coluna comum `cliente_id`.

---

### 2. **Auto Junção (Self Join)**:
   - **Descrição**: Uma **auto junção** ocorre quando você junta uma tabela consigo mesma. Isso pode ser útil quando você precisa comparar linhas dentro da mesma tabela, como relacionamentos hierárquicos, conexões entre registros, ou ao buscar registros com base em uma comparação interna.

   - **Quando Usar**: Use uma auto junção quando quiser comparar ou relacionar registros da mesma tabela. Por exemplo, se uma tabela armazena relações entre funcionários e seus gerentes, você pode precisar comparar funcionários com seus respectivos gerentes, tudo dentro da mesma tabela.

   - **Sintaxe**:
     ```sql
     SELECT A.coluna, B.coluna
     FROM tabela A
     JOIN tabela B
     ON A.nome_coluna = B.nome_coluna;
     ```

   - **Exemplo**:
     Suponha que você tenha uma tabela `funcionarios` que contém uma coluna `gerente_id`, e você deseja listar os funcionários e seus gerentes (todos armazenados na mesma tabela). Você pode usar uma auto junção para fazer isso:
     ```sql
     SELECT f1.nome AS funcionario, f2.nome AS gerente
     FROM funcionarios f1
     JOIN funcionarios f2
     ON f1.gerente_id = f2.id;
     ```
     Neste exemplo, a tabela `funcionarios` é usada duas vezes com aliases (`f1` e `f2`), onde a junção ocorre entre o `gerente_id` de um funcionário e o `id` do gerente, ambos na mesma tabela.

### Diferenças e quando usar:
- **`USING`**: Especifica a coluna comum entre duas tabelas diferentes para uma junção simplificada.
- **Auto Junção (Self Join)**: Útil quando você precisa comparar ou fazer relações dentro da mesma tabela.

## GRUPO E AGRUPAMENTOS
```sql
SELECT [ coluna, ] funçao_de_grupo (coluna)
   FROM tabela
[ WHERE condição ]
   [ GROUP BY coluna ]
     [ HAVING condiçao ]
  [  ORDER BY coluna [, coluna, ...]
```

**CONTAR A QUANTIDADE DE REGISTROS**
```sql
-- EXEMPLO – FUNÇÃO COUNT (*)
SELECT COUNT(*) FROM <nome-tabela>;
```

**SOMATÓRIO DOS VALORES DE UMA COLUNA**
```sql
-- EXEMPLO – FUNÇÃO SUM (coluna) 
SELECT SUM(<nome-coluna>) FROM <nome-tabela>;
```

**MÉDIA ARITMÉTICA DOS VALORES DE UMA COLUNA**
```sql
-- EXEMPLO – FUNÇÃO AVG (coluna) 
SELECT AVG(<nome-coluna>) FROM <nome-tabela>;
```

**MENOR VALOR DE UMA COLUNA**
```sql
-- EXEMPLO – FUNÇÃO MIN (coluna) 
SELECT MIN(<nome-coluna>) FROM <nome-tabela>;
```

**MAIOR VALOR DE UMA COLUNA**
```sql
-- EXEMPLO – FUNÇÃO MAX (coluna) 
SELECT MAX(<nome-coluna>) FROM <nome-tabela>;
```

## Criando um agrupamento de dados
```sql
-- EXEMPLO – GROUP BY 
SELECT NR_MATRICULA, 
       COUNT(CD_DEPENDENTE) "QTDE. DEPENDENTES"
  FROM T_SIP_DEPENDENTE
    GROUP BY NR_MATRICULA;
```

**CLÁUSULA HAVING**
Podemos utilizar a cláusula HAVING para aplicar uma condição de seleção sobre as linhas agrupadas. A cláusula **HAVING** é utilizada para realizar restrições ao agrupamento com a cláusula **GROUP BY**.

```sql
-- EXEMPLO – GROUP BY COM HAVING
  SELECT CD_DEPTO,
   COUNT(NR_MATRICULA) "QTDE. FUNCIONARIO NO DEPTO",
   SUM(VL_SALARIO_MENSAL) "TOTAL SALARIO POR DEPTO",
   ROUND(AVG(VL_SALARIO_MENSAL),2) "MEDIA SALARIAL POR DEPTO"
    FROM T_SIP_FUNCIONARIO
GROUP BY CD_DEPTO
HAVING   SUM(VL_SALARIO_MENSAL) > 10000;
```
Nesse exemplo serão filtrados os agrupamentos formados, recuperando apenas os agrupamentos onde a somatória de salários for superior a R$10.000,00.

**DESVIO CONDICIONAL *(INSTRUÇÃO CASE)***
```sql
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
Exemplo:
```sql
-- EXEMPLO – INSTRUÇÃO CASE
SELECT
        NM_PROJETO,
        DT_TERMINO,
CASE
  WHEN DT_TERMINO IS NULL THEN 'EM ANDAMENTO'
  ELSE 'FINALIZADO'
END STATUS_PROJETO
  FROM T_SIP_PROJETO
ORDER BY NM_PROJETO;
```

