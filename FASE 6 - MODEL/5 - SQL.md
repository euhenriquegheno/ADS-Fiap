# 5 - SQL

## LINGUAGEM ESTRUTURADA PARA CONSULTA (Estructured Query Language - SQL)
*Estructured Query Language* (SQL) ou linguagem estruturada para consulta é uma linguagem de definição, manipulação e controle de banco de dados.

A linguagem SQL é totalmente padronizada e reconhecida pelo ANSI (*American National Standard Institute*) e possui uma sintaxe simples, facilitando o aprendizado e uso dessa linguagem.

* **DDL (DATA DEFINITION LANGUAGE) - LINGUAGEM DE DEFINIÇÃO DE DADOS**
Utilizada para definir tabelas e elementos associados a estrutura fisica do banco de dados.
Exemplo: CREATE, DROP, ALTER, RENAME, TRUNCATE.

* **DML (DATA MANIPULATION LANGUAGE) - LINGUAGEM DE MANIPULAÇÃO DE DADOS**
Utilizada para inserir, atualizar e apagar dados, ou seja, para modificar o conteúdo das tabelas.
Exemplo: INSERT, UPDATE, DELETE.
* **DCL (DATA CONTROLE LANGUAGE) - LINGUAGEM DE CONTROLE DE DADOS**
Utilizada para controlar autorização de acesso a dados e operações.
Exemplos: GRANT, REVOKE.
* **DTL (DATA TRANSACTION LANGUAGE) - LINGUAGEM DE TRANSAÇÃO DE DADOS**
Utilizada para controlar as transações de bando de dados, permitindo o registro permanente das alterações ou desfazendo as alterações.
Exemplo: COMMIT, ROLLBACK, SAVEPOINT.
* **DQL (DATA QUERY LANGUAGE) OU DRS (DATA RETRIEVE LANGUAGE) - LINGUAGEM DE CONSULTA DE DADOS. TAMBÉM CHAMADA DE DRS (DATA RETRIEVE LANGUAGE)**
Utilizada para especificar consultar; é composta por várias cláusulas e opções, o que possibilita a elaboração de consultar simples e complexas.
Exemplos: SELECT.
Alguns SGBDRs que utilizam a linguagem SQL: Apache Derby, Caché, DB2, Firebird, Informix, Interbase, SQL Server, MySQL, Oracle, PostGreSQL, Sybase.

### COMANDOS *DDL* PARA CRIAÇÃO E MANUTENÇÃO DE TABELAS

Instrução | Descrição
-------- | -----
CREATE | Criação das estruturas físicas do banco de dados.
ALTER | Alteração das estruturas físicas do banco de dados.
DROP | Eliminação das estruturas físicas do bando de dados.
TRUNCATE | Exclusão física das linhas da tabela.
RENAME | Renomeação das estruturas físicas do banco de dados.
COMMENT | Inserção de comentários relativos as estruturas físicas do banco de dados.

**COMANDO CREATE TABLE**
Criar a estrutura da tabela definindo as colunas (campos) e as chaves primárias e estrangeiras existentes.

```
-- Sintaxe:
CREATE TABLE <nome-tabela> (
<nome-coluna> <tipo-do-dado> [NOT NULL]
PRIMARY KEY (nome-coluna-chave)
FOREIGN KEY (nome-coluna-chave-estrangeira) 
REFERENCES <nome-tabela-pai> (nome-coluna-chave-primária));
```
**COMANDO ALTER TABLE**
Alterar a estrutura de uma tabela acrescentando, alterando, retirando e alterando nomes, formatos das colunas e a integridade referencial definidas em uma determinada tabela.

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

**COMANDO DROP TABLE**
Deletar a estrutura e os dados existentes em uma tabela. Após a execução deste comando, estarão deletados todos os dados, estrutura e índices de acessos que estejam a ela associados.

```
-- Sintaxe:
DROP TABLE <nome-tabela>;
```

### CONSTRAINTS - REGRAS OU RESTIÇÕES APLICADAS A ESTRUTURA FÍSICA DE ARMAZENAMENTO

As restições (constraints) evitam:
* Impedir que dados inválidos sejam cadastrados no banco de dados;
* Garantir a qualidade dos dados;
* Garantir que campos (atributos) obrigatórios sejam preenchidos;
* Garantir que uma tabela (entidade) não seja deletada se houver dependencias;
* Garantir a integridade referencial definida no modelo relacional.
* Em geral, fazem parte da especificação do projeto conceitual do banco de dados e estão descritas no modelo relacional;

**Tipos de Constraints no Oracle Database**

* PK - PRIMARY KEY
* FK - FOREIGN KEY
* NOT NULL/ NULL
* UN - UNIQUE CONSTRAINT
* CK - CHECK CONSTRAINT
* DEFAULT - Valor Padrão

**PRIMARY KEY**
Os campos (colunas) que formam uma PK são obrigatórios, ou seja, não podem aceitar valores nulos.

Os valores de uma chave primária não se repetem.

A chave primária é representada pela letra P (Primary Key)
![Constraint Primary Key](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/02/02133733/on-image-414-1024x666.jpg)

**FOREIGN KEY**
Garante a integridade referencial, ou seja, toda chave estrangeira faz referencia a uma chave primária de uma tabela referenciada.

A chave estrangeira é um campo (atributo) monovalorado, ou seja, possui um único valor.

A chave estrangeira é indicada com a letra F (Foreign Key).
![Constraint Foreign Key](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/02/02133738/on-image-517-1024x666.jpg)

**NOT NULL**
Um campo (atributo) obrigatório não pode aceitar valor nulo.

O not null é indicado com o * (asterisco), já que é um campo opcional, não possui nenhuma indicação (ausência de obrigatoriedade).
![Constraint NOT NULL/NULL](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/02/02133742/on-image-64-1024x666.jpg)

**UNIQUE (UNIQUE CONSTRAINT)**
Indica que uma determinada coluna de uma tabela não poderá ter repetição, ou seja, não poderá ter valores repetidos para o conteúdo da coluna.

Uma coluna definidade com Unique pode ser uma coluna opcional (aceita valores nulos). Mas vale ressaltar que em uma função Unique não permitir repetição de valores, apenas uma linha da tabela poderá ter a coluna com valor nulo.

O campo definido com a Constraint Unique é indicado com a letra (U - UNIQUE) na frente do campo.
![Constraint UNIQUE](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/02/02133746/on-image-74-1024x666.jpg)

**CHECK (CHECK CONSTRAINT)**
É a restição/regra que define o dominio de um determinado campo. É uma constraint de verificação ou validação.

O campo definido com a Constraint Check é configurado através da edição da tabela, através do data modeler. A constraint check não pe apresentada de forma explicita no modelo relacional.

![Constraint CHECK](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/02/02133750/on-image-84-1024x666.jpg)

**DEFAULT**
Atribui um conteúdo padrão a uma coluna da tabela sempre que for incluída uma nova linha na tabela.

Podemos definir a *Constraint Default* através da linguagem SQL, comando DDL, conforme fragmento de código abaixo.
```
-- Sintaxe:
.
.
.
        qt_vendida NUMBER(4) DEFAULT 1 ,
.
.
.
```

### RECOMENDAÇÕES PARA ADIÇÃO DE  CONSTRAINTS
Sugestões de prefixos para serem utilizados nos nomes das constraint, facilitando o entendimento e posterior manutenção.

Prefixos para constraints | Descrição
-------- | -----
PK | Constraint Primary Key
FK | Constraint Foreign Key
UN | Constraint Unique
CK | Constraint Check

### IMPLEMENTAÇÃO DE UMA TABELA UTILIZANDO O COMANDO CREATE TABLE

Quando implementamos uma tabela, é fundamental fazer isso a partir do modelo relacional de dados, que reflete o projeto físico do banco de dados.
![Tabela Departamento a partir do Data Modeler, modelo relacional](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/02/02133753/on-image-94-1024x666.jpg)

Seguindo o exemplo a cima, apresentamos abaixo o código na linguagem SQL, que permite criar a tabela.
```
-- CRIAÇÃO DA TABELA
CREATE TABLE t_sit_deparatamento (
	cd_depto NUMBER(3)		NOT NULL,
	nm_depto VARCHAR(30)	NOT NULL,
	sg_depto CHAR(3)		NOT NULL
);
```
**IMPLEMENTAÇÃO DA CONSTRAINT PRIMARY KEY**

O código SQL abaixo permite adicionar a constraint Primary Key.
```
-- IMPLEMENTAÇÃO DA PRIMARY KEY COM ALTER TABLE
   ALTER TABLE t_sip_departamento 
ADD CONSTRAINT pk_sip_departamento 
   PRIMARY KEY ( cd_depto );
```

Podemos também adicionar na criação da tabela, tanto ao nivel de coluna, como ao nivel de tabela, exemplos:
```
-- CONSTRAINT PRIMARY KEY A NIVEL DE TABELA
CREATE TABLE t_sip_departamento (
    cd_depto NUMBER(3)      NOT NULL,
    nm_depto VARCHAR2(30)   NOT NULL,
    sg_depto CHAR(3)        NOT NULL,
CONSTRAINT pk_sip_departamento PRIMARY KEY ( cd_depto )    
);
```

```
-- CONSTRAINT PRIMARY KEY A NÍVEL DE COLUNA
CREATE TABLE t_sip_departamento (
    cd_depto NUMBER(3)      NOT NULL 
                 CONSTRAINT pk_sip_departamento PRIMARY KEY,
    nm_depto VARCHAR2(30)   NOT NULL,
    sg_depto CHAR(3)        NOT NULL
);
```

**IMPLEMENTAÇÃO DA CONSTRAINT UNIQUE**
Com base na figura:
![Tabela Departamento – Constraint Unique, partir do Data Modeler, modelo relacional](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/02/02133800/on-image-118-1024x666.jpg)

Código SQL:

```
-- IMPLEMENTAÇÃO DA CONSTRAINT UNIQUE
   ALTER TABLE t_sip_departamento 
ADD CONSTRAINT un_sip_depto_nome 
        UNIQUE ( nm_depto );
```

**IMPLEMENTAÇÃO DA CONSTRAINT CHECK**
Com base na figura:
![Tabela Projeto, partir do Data Modeler, modelo relacional](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/02/02133806/on-image-124-1024x666.jpg)
![Tabela Projeto – Constraint CHECK, partir do Data Modeler, modelo relacional](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/02/02133809/on-image-134-1024x666.jpg)

Código SQL:
```
-- IMPLEMENTAÇÃO DA CONSTRAINT CHECK
   ALTER TABLE t_sip_projeto 
ADD CONSTRAINT ck_sip_projeto_data 
         CHECK ( dt_termino > dt_inicio );
```

**IMPLEMENTAÇÃO DA CONSTRAINT FOREIGN KEY**
Com base na figura:
![Relacionamento entre Funcionário e Departamento, partir do Data Modeler, modelo relacional](https://s3.amazonaws.com/b5fa8c4024182e6fb580b451bb51ed1719e4949feb566bd9b6b92b85df31576/wp-content/uploads/2023/02/02133814/on-image-144-1024x666.jpg)

Código SQL:
```
-- IMPLEMENTAÇÃO DA CONSTRAINT FOREIGN KEY
   ALTER TABLE t_sip_funcionario
ADD CONSTRAINT fk_sip_func_depto 
   FOREIGN KEY ( cd_depto )
    REFERENCES t_sip_departamento ( cd_depto );
```

### IMPLEMENTAÇÃO DA EXCLUSÃO DAS TABELAS, UTILIZANDO O COMANDO DROP TABLE
O comando DROP TABLE exclui uma tabela permanentemente, incluindo seus dados e índices.

Código SQL:
```
-- EXCLUIR A TABELA
DROP TABLE t_sip_departamento;
```

No momento da exclusão de tabelas, precisamos considerar que existem os relacionamento que criam dependências entre as tabelas.

Caso existir alguma referencia a tabela, não vai ser possível excluir.
Para auxiliar a exclusão, é possível excluir uma tabela e eliminar as referencia por meio da clausula "CASCADE CONSTRAINTS".

Código SQL:
```
-- EXCLUIR A TABELA ELIMINANDO AS REFERÊNCIAS
DROP TABLE t_sip_departamento CASCADE CONSTRAINTS;
```

A clausula PURGE, no final da instrução, permite que a tabela seja eliminada definitivamente, sem que fique na "lixeira" (***RECYCLE BIN***).

Código SQL:
```
-- EXCLUIR A TABELA COM PURGE
DROP TABLE t_sip_departamento PURGE;
-- EXCLUIR A TABELA COM PURGE, ELIMINANDO AS REFERÊNCIAS
DROP TABLE t_sip_departamento CASCADE CONSTRAINTS PURGE;
```

Para eliminar todas as linhas da tabela, sem excluir a estrutura dos campos, utilizamos o TRUNCATE TABLE.

Código SQL:
```
-- EXCLUIR TODOS OS DADOS DA TABELA, SEM ELIMINAR A ESTRUTURA
TRUNCATE TABLE < nome-tabela >;
```

### COMENTÁRIOS ASSOCIADOS A TABELAS E CAMPOS ATRAVÉS DA LINGUAGEM SQL
O comando **COMMENT** permite adicionar comentários sobre tabelas e colunas.

Código SQL:
```
-- COMENTÁRIO SOBRE TABELA E CAMPOS
COMMENT ON TABLE T_SIP_DEPARTAMENTO IS 'EXEMPLO DE COMENTÁRIO PARA A TABELA';
COMMENT ON COLUMN T_SIP_DEPARTAMENTO.SG_DEPTO IS 'EXEMPLO DE COMENTÁRIO DE COLUNA';
```

