# Documentação da Implementação do Banco de Dados SQLite com Room

## Visão Geral

Este documento descreve a implementação de um banco de dados SQLite local usando a biblioteca Room no aplicativo de Saúde Mental. A migração de dados em memória para persistência local permite que o aplicativo mantenha os dados entre sessões, oferecendo uma experiência mais consistente ao usuário.

## Estrutura Implementada

### 1. Converters

Foi criada uma classe `Converters` para lidar com tipos complexos que o SQLite não suporta nativamente:
- Conversão de List<String>
- Conversão de Map<String, Int>
- Conversão de enums (NivelRisco, TipoRecurso, TipoHumor)
- Conversão de List<NivelRisco>

### 2. Entidades

As seguintes classes de modelo foram adaptadas como entidades Room:
- **Avaliacao**: Armazena avaliações de risco psicossocial
- **Pergunta**: Armazena perguntas para avaliação
- **Recurso**: Armazena recursos de apoio
- **RegistroHumor**: Armazena registros diários de humor

### 3. DAOs (Data Access Objects)

Foram criados DAOs para cada entidade com operações CRUD:
- **AvaliacaoDao**: Operações para Avaliacao
- **PerguntaDao**: Operações para Pergunta
- **RecursoDao**: Operações para Recurso
- **RegistroHumorDao**: Operações para RegistroHumor

### 4. Banco de Dados

A classe `AppDatabase` gerencia todas as entidades e DAOs, fornecendo acesso centralizado ao banco de dados.

### 5. Repositório

A classe `RepositorioDadosRoom` substitui o antigo `RepositorioDados`, fornecendo métodos para acessar e manipular dados persistentes.

## Alterações Realizadas

1. **Adição de Dependências**:
   - Room Runtime
   - Room KTX
   - Gson (para serialização de tipos complexos)

2. **Criação de Estrutura de Banco**:
   - Implementação de converters para tipos complexos
   - Adaptação de modelos para entidades Room
   - Criação de DAOs com operações CRUD
   - Implementação da classe principal do banco de dados

3. **Migração de Dados**:
   - Substituição do repositório de dados mockados por acesso ao banco
   - Implementação de método para inicializar dados padrão

4. **Adaptação de Telas**:
   - Todas as telas foram adaptadas para consumir dados do banco Room
   - Implementação de persistência em operações de criação e atualização

5. **Testes e Validação**:
   - Criação de classe utilitária para testar persistência e integridade
   - Validação de operações CRUD e consultas específicas

## Como Usar

### Inicialização do Banco

O banco de dados é inicializado na `MainActivity`:

```kotlin
val repositorio = RepositorioDadosRoom(this)
repositorio.inicializarDadosPadrao()
```

### Acesso aos Dados

Para acessar os dados em qualquer tela, use o repositório:

```kotlin
// Exemplo: Obter perguntas
val perguntas = repositorio.obterPerguntas()

// Exemplo: Salvar avaliação
val avaliacao = repositorio.salvarAvaliacao(respostas)

// Exemplo: Obter recursos por tipo
val recursos = repositorio.obterRecursosPorTipo(tipoRecurso)

// Exemplo: Salvar registro de humor
val registro = repositorio.salvarRegistroHumor(humor, nivelEstresse, observacoes)
```

## Benefícios da Implementação

1. **Persistência de Dados**: Os dados são mantidos entre sessões do aplicativo
2. **Consultas Eficientes**: Room otimiza as consultas SQL
3. **Segurança de Tipos**: Verificação em tempo de compilação para consultas SQL
4. **Integração com LiveData**: Possibilidade de observar mudanças nos dados (implementação futura)
5. **Escalabilidade**: Facilidade para adicionar novas entidades e relacionamentos

## Considerações Futuras

1. **Migração de Versão**: Implementar estratégias de migração para atualizações de esquema
2. **Operações Assíncronas**: Utilizar coroutines para operações de banco de dados em threads separadas
3. **LiveData/Flow**: Implementar observabilidade de dados para atualização automática da UI
4. **Injeção de Dependência**: Integrar com frameworks como Hilt ou Koin para gerenciamento de dependências
