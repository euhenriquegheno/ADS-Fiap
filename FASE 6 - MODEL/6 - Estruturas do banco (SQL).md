# VERIFICANDO AS ESTRUTURAS DE ARMAZENAMENTO

## SQL - COMANDOS DDL - ALTER TABLE, SEQUENCE E IDENTIFY
Focaremos no comando ALTER TABLE e abordaremos como alterar, eliminar ou inserir elementos em uma estrutura de armazenamento (bando de dados).

### COMANDO ALTER TABLE
Permite alterar a estrutura de uma tabela acrescentando, alterando e retirando nomes, formatos das colunas e a integridade referencial definidas em uma determinada tabela.

Código SQL: 
```
-- Sintaxe:
ALTER TABLE <nome-tabela>
DROP COLUMN <nome-coluna>
ADD 	<nome-coluna> <tipo-do-dado> [NOT NULL]
[NOT NULL WITH DEFAULT] 
RENAME <nome-coluna> <novo-nome-coluna>
MODIFY <nome-coluna> <tipo-do-dado> [NULL]
[NOT NULL]
```

Observamos que é possível executar as seguintes ações:
* DROP COLUMN - Permite eliminar colunas de uma tabela.
* ADD - Permite adicionar colunas ou restrições a uma tabela existente.
* RENAME - Permite renomear a própria tabela, coluna e constraints.
* MODIFY - Permite modificar a estrutura das colunas, como um tipo de dados, tamanho ou restrições.


**EXEMPLO DE CRIAÇÃO DE UMA TABELA, E ALTERAÇÃO**
```
-- CRIAR A TABELA
CREATE TABLE T_TESTE_DDL
(
    CD_TESTE    NUMBER(3)       NOT NULL ,
    NM_TESTE    VARCHAR2(30)    NOT NULL ,
    DS_TESTE    VARCHAR2(60)        NULL ,
    DT_TESTE    DATE                NULL
);
-- CHAVE PRIMARIA
   ALTER TABLE T_TESTE_DDL 
ADD CONSTRAINT PK_TESTE_DDL 
   PRIMARY KEY (CD_TESTE);
-- CONSTRAINT UNIQUE
   ALTER TABLE T_TESTE_DDL 
ADD CONSTRAINT UN_TESTE_DDL_NOME 
        UNIQUE (NM_TESTE);
   ALTER TABLE T_TESTE_DDL 
ADD CONSTRAINT UN_TESTE_DDL_DESC 
        UNIQUE (DS_TESTE);
```

### ADICIONANDO ELEMENTOS A UMA TABELA
Utilizando o comando **ALTER TABLE** com a cláusula **ADD**, podemos adicionar colunas e constraints em uma tabela existente.

Código SQL:
```
-- ADIÇÃO DE UMA COLUNA(OPCIONAL) A UMA TABELA EXISTENTE
ALTER TABLE T_TESTE_DDL ADD DS_EMAIL VARCHAR2(80);
```

Adição de duas colunas, uma mandatória e outra opcional:
```
-- ADIÇÃO DE DUAS OU MAIS COLUNAS A UMA TABELA EXISTENTE
ALTER TABLE T_TESTE_DDL 
  ADD ( DS_OBS1 VARCHAR2(50) NOT NULL, 
        DS_OBS2 VARCHAR2(50) );
```

### MODIFICANDO DEFINIÇÕES DE UMA TABELA
Utilizando o comando **ALTER TABLE** com a cláusula **MODIFY**, podemos modificar várias definições de uma coluna: tipo, tamanho, obrigatoriedade (not null) e valor *default*.

Exemplo de aumento do tamanho de uma coluna:
```
-- AUMENTANDO O TAMANHO DE UMA COLUNA EM UMA TABELA EXISTENTE
ALTER TABLE T_TESTE_DDL
     MODIFY DS_OBS1 VARCHAR2(80);
```

Modificação do tipo de dado de uma coluna:
```
-- MODIFICANDO O TIPO DE DADO DE UMA COLUNA EM
-- UMA TABELA EXISTENTE
ALTER TABLE T_TESTE_DDL
	MODIFY NM_TESTE CHAR(30);
```

Modificação de NULL para NOT NULL:
```
-- MODIFICANDO UMA COLUNA NULL (OPCIONAL) PARA NOT NULL (OBRIGATORIA)
ALTER TABLE T_TESTE_DDL
     MODIFY DS_TESTE NOT NULL;
```

Modificação de valor default:
```
-- MODIFICANDO UM VALOR DEFAULT
-- SYSDATE -> FUNÇÃO DO ORACLE QUE RETORNA 
-- DATA/HORA DO SERVIDOR DE BD
ALTER TABLE T_TESTE_DDL
     MODIFY DT_TESTE DEFAULT SYSDATE;
```

### REMOVENDO COLUNAS E CONSTRAINTS DE UMA TABELA
Utilizando o comando **ALTER TABLE** com a cláusula **DROP**, podemos remover colunas e constraints.

Exemplo remoção de uma coluna:
```
-- REMOVENDO UMA COLUNA DA TABELA
ALTER TABLE T_TESTE_DDL DROP COLUMN DS_OBS2;
```

Remoção da constraint chave primária (unique é parecido):
```
-- REMOVENDO CONSTRAINT CHAVE PRIMÁRIA
ALTER TABLE T_TESTE_DDL DROP CONSTRAINT PK_TESTE_DDL;
-- REMOVENDO CONSTRAINT CHAVE PRIMÁRIA COM RELACIONAMENTOS
ALTER TABLE T_TESTE_DDL DROP CONSTRAINT PK_TESTE_DDL CASCADE;
```

Remoção da constraint foreign key (check é parecido):
```
-- REMOVENDO CONSTRAINT CHAVE ESTRANGEIRA
    ALTER TABLE T_TESTE_DDL
DROP CONSTRAINT <FK_NOME_CONSTRAINT_FOREIGN_KEY>;
```

## COMANDOS DDL - SEQUENCES
Sua função é gerar uma série de números inteiros. Normalmente utilizado para preencher uma coluna chave primária numérica, com valores numéricos inteiros.

### CRIANDO UMA SEQUÊNCIA
Sintaxe básica do comando CREATE SEQUENCE:
```
CREATE SEQUENCE nome_sequencia
[ START WITH num_inicio ]
[ INCREMENT BY  num_incremento ]
[ { MAXVALUE  num_maximo | NOMAXVALUE } ]
[ { MINVALUE  num_minimo | NOMINVALUE } ]
[ { CYCLE | NOCYCLE} ]
[ { CACHE   num_cache | NOCACHE } ]
[ { ORDER | NOORDER } ];
```
Na qual:
*nom_sequencia*: Nome da sequencia;

*nom_inicio*: Número inteiro usado para iniciar sequencia. O número inicial padrão é 1;

*num_incremento*: Número inteiro para incrementar a sequencia. O número de incremento padrão é 1;

*num_maximo*: Número inteiro máximo de sequencia. Deve ser maior ou igual ao número inicial. Deve ser maior que o numero mínimo;

NOMAXVALUE: Especifica que o máximo é 10 na 27 para uma sequencia crescente ou -1 para uma sequencia decrescente. A opção NOMAXVALUE é padrão;

*num_minimo*: Número inteiro mínimo da sequencia. Deve ser menor ou igual ao número inicial sequencia. Deve ser menor que o número máximo da sequencia.

NOMINVALUE: Especifica que o mínimo é 1 para uma sequência crescente ou 10^-26 para uma sequência decrescente. NOMINVALUE é o padrão.
 
CYCLE: Significa que a sequência gera números inteiros mesmo depois de atingir seu valor máximo ou mínimo. Quando uma sequência crescente atinge seu valor máximo, o próximo valor gerado é o mínimo. Quando uma sequência decrescente atinge seu valor mínimo, o próximo valor gerado é o máximo.
 
NOCYCLE: Significa que a sequência não pode gerar mais número inteiro algum após atingir seu valor máximo ou mínimo. NOCYCLE é o padrão.
 
*num_cach*e: é o número de valores inteiros a manter na memória. O número de valores inteiros padrão colocados na cache é 20. O número mínimo de valores inteiros que podem ser colocados no cache é 2. O número máximo de valores inteiros que podem ser colocados no cache é determinado pela fórmula CEIL ( num_maximo - num_minimo ) / ABS ( num_incremento ).
 
NOCACHE: Significa sem cache. Isso impede o banco de dados de alocar valores previamente para a sequência, o que evita lacunas numéricas na sequência, mas reduz o desempenho. As lacunas ocorrem porque os valores alocados no cache são perdidos quando um banco de dados é fechado. Se for omitida CACHE/NOCACHE, o banco de dados colocará 20 números de sequência na CACHE, por padrão.
 
ORDER: Garante que os números inteiros sejam gerados na ordem da solicitação.
 
NOORDER: Não garante que os números inteiros sejam gerados na ordem de solicitação. NOORDER é o padrão.

Exemplos e comentários sobre a estrutura de uma SEQUENCE:
```
-- COMENTÁRIOS SOBRE A ESTRUTURA DA SEQUENCE
CREATE SEQUENCE <nome_da_sequencia>
     START WITH 1  -- Primeiro número a ser gerado
   INCREMENT BY 1  -- Valor do incremento (≠ zero)
     NOMAXVALUE    -- Sem definição de limite máximo
    CACHE 50 -- O default é "CACHE 20" 
  NOCYCLE ;  -- Após chegar ao limite, não reinicia
```

```
-- COMENTÁRIOS SOBRE A ESTRUTURA DA SEQUENCE
CREATE SEQUENCE <nome_da_sequencia>
   INCREMENT BY 1   -- Primeiro número a ser gerado
     START WITH 1   -- Valor do incremento (≠ zero)
 MAXVALUE 999 –- Valor máximo da sequência
  NOCACHE     -- sem cache
    CYCLE; --Após chegar ao limite, reinicia a sequência
```
**Importante**: Lacunas/Intervalos "Gaps" de valores da sequencia podem ocorrer quando: ocorrer um rollback (uma transação é desfeita), falha no sistema e quando uma sequencia é usada por duas ou mais tabelas.

**EXEMPLOS DE APLICAÇÕES UTILIZANDO SEQUENCE**
Código SQL:
```
-- CRIAÇÃO DE TABELA PARA EXEMPLIFICAR SEQUENCES
-- APAGAR A TABELA PARA TESTES
DROP TABLE T_TESTE_DDL_SEQUENCE;
-- CRIAR UMA TABELA PARA TESTES
CREATE TABLE T_TESTE_DDL_SEQUENCE
(
    CD_TESTE_SQ     NUMBER(3)        NOT NULL,
    NM_TESTE_SQ     VARCHAR2(30)    NOT NULL
);
-- ADICIONAR A CONSTRAINT CHAVE PRIMARIA
   ALTER TABLE T_TESTE_DDL_SEQUENCE 
ADD CONSTRAINT PK_TESTE_DDL_SEQUENCE 
   PRIMARY KEY (CD_TESTE_SQ);
```

Exemplo do comando DDL, para criar sequencia de números inteiros que será utilizando na chave primária para a tabela de testes, descrita acima.

```
-- CRIAR A SEQUÊNCIA PARA GERAR UM CODIGO AUTO NUMERICO
CREATE SEQUENCE Q_TESTE_DDL_SEQUENCE
   INCREMENT BY 1
  START WITH 1
    MAXVALUE 999
     NOCACHE
     NOCYCLE;
```

### SEQUENCIA: PSEUDOCOLUNAS CURRVAL E NEXTVAL

Podemos utilizar as duas pseudoscolunas contidas nas sequencias para saber o valor atual da sequencia e o próximo valor da sequencia.

Quando utilizamos o NEXTVAL para determinar o próximo valor da sequencia, o próximo valor é alterado, causando um "GAP" de valores, dependendo de como for utilizado.

Quando utilizamos o CURRVAL para determinar o valor atual da sequencia, não há alteração no próximo valor.

### REALIZANDO AINSERÇÃO DE VALORES AUTO NUMÉRICOS A PARTIR DA SEQUENCIA

**Atenção**: Quando utilizamos a sequencia para preencher uma coluna de chave primária, recomenda-se usar NOCACHE para evitar "GAPS" na sequencia. Vale ressaltar que utilizando NOCACHE, há uma redução de desempenho. Se as lacunas "GAPS" não forem um problema, utilize CACHE.




