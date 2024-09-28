# 5 - SQL

## Linguagem estruturada para consulta (Estructured Query Language - SQL)
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

### Comandos DDL para criação e manutenção de tabelas

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

### Constraints - Regras ou restrições aplicadas a estrutura física de armazenamento

As restições (constraints) evitam:
* Impedir que dados inválidos sejam cadastrados no banco de dados;
* Garantir a qualidade dos dados;
* Garantir que campos (atributos) obrigatórios sejam preenchidos;
* Garantir que uma tabela (entidade) não seja deletada se houver dependencias;
* Garantir a integridade referencial definida no modelo relacional.
* Em geral, fazem parte da especificação do projeto conceitual do banco de dados e estão descritas no modelo relacional;

**Tipos de Constraints no Oracle Database**
```
* PK - PRIMARY KEY
* FK - FOREIGN KEY
* NOT NULL/ NULL
* UN - UNIQUE CONSTRAINT
* CK - CHECK CONSTRAINT
* DEFAULT - Valor Padrão
```

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

### Recomendações para adição de CONSTRAINTS
Sugestões de prefixos para serem utilizados nos nomes das constraint, facilitando o entendimento e posterior manutenção.

Prefixos para constraints | Descrição
-------- | -----
PK | Constraint Primary Key
FK | Constraint Foreign Key
UN | Constraint Unique
CK | Constraint Check


