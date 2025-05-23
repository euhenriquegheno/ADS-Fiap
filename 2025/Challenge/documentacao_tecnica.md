# Documentação Técnica - Aplicativo Softtek Saúde Mental

## 1. Introdução

Este documento apresenta a documentação técnica do aplicativo Softtek Saúde Mental, desenvolvido para atender às exigências da NR1 relacionadas à saúde mental e riscos psicossociais no ambiente de trabalho. O aplicativo oferece ferramentas para avaliação de riscos, acompanhamento do bem-estar emocional, acesso a recursos de apoio, visualização de dados e lembretes personalizados.

## 2. Arquitetura do Aplicativo

### 2.1 Visão Geral

O aplicativo foi desenvolvido para a plataforma Android utilizando Kotlin e Jetpack Compose, seguindo a arquitetura MVVM (Model-View-ViewModel) com Clean Architecture. Esta abordagem proporciona uma clara separação de responsabilidades, facilitando a manutenção, testabilidade e escalabilidade do código.

### 2.2 Camadas da Arquitetura

#### 2.2.1 Camada de Apresentação (UI)
- Implementada com Jetpack Compose
- Contém as telas (Composables) e ViewModels
- Responsável pela interação com o usuário e exibição de dados

#### 2.2.2 Camada de Domínio
- Contém os modelos de dados e regras de negócio
- Independente de frameworks externos
- Define as entidades principais do sistema

#### 2.2.3 Camada de Dados
- Gerencia o acesso e persistência de dados
- Implementa repositórios para acesso aos dados
- Na Sprint 1, utiliza dados mockados para simulação

### 2.3 Diagrama de Arquitetura

```
+----------------------------------+
|                                  |
|  Camada de Apresentação (UI)     |
|                                  |
|  +----------------------------+  |
|  |                            |  |
|  |  Telas Compose             |  |
|  |  - TelaAvaliacao           |  |
|  |  - TelaBemEstar            |  |
|  |  - TelaRecursos            |  |
|  |  - TelaVisualizacao        |  |
|  |  - TelaLembretes           |  |
|  |                            |  |
|  +------------+---------------+  |
|               |                  |
+---------------|------------------+
                |
+---------------|------------------+
|               |                  |
|  Camada de Domínio               |
|                                  |
|  +------------v---------------+  |
|  |                            |  |
|  |  Modelos                   |  |
|  |  - Avaliacao               |  |
|  |  - RegistroHumor           |  |
|  |  - Recurso                 |  |
|  |  - NivelRisco              |  |
|  |  - TipoHumor               |  |
|  |                            |  |
|  +------------+---------------+  |
|               |                  |
+---------------|------------------+
                |
+---------------|------------------+
|               |                  |
|  Camada de Dados                 |
|                                  |
|  +------------v---------------+  |
|  |                            |  |
|  |  RepositorioDados          |  |
|  |  (Dados mockados)          |  |
|  |                            |  |
|  +----------------------------+  |
|                                  |
+----------------------------------+
```

## 3. Tecnologias Utilizadas

### 3.1 Linguagem e Framework
- **Kotlin**: Linguagem principal de desenvolvimento
- **Jetpack Compose**: Framework de UI declarativa para Android
- **Material Design 3**: Biblioteca de componentes visuais

### 3.2 Bibliotecas e Componentes
- **AndroidX**: Conjunto de bibliotecas de suporte
- **Navigation Compose**: Para navegação entre telas
- **ViewModel**: Para gerenciamento de estado da UI
- **Room** (preparado para implementação futura): Para persistência local de dados
- **Retrofit** (preparado para implementação futura): Para comunicação com APIs REST

## 4. Estrutura do Projeto

### 4.1 Organização de Pacotes
```
br.com.fiap.saudemental/
├── model/                  # Modelos de dados
├── data/                   # Camada de dados e repositórios
├── ui/
│   ├── screens/            # Telas Compose
│   └── theme/              # Definições de tema e estilo
└── MainActivity.kt         # Ponto de entrada do aplicativo
```

### 4.2 Principais Componentes

#### 4.2.1 Modelos (model/)
- **Avaliacao**: Representa uma avaliação de riscos psicossociais
- **RegistroHumor**: Representa um registro diário de humor
- **Recurso**: Representa um recurso de apoio
- **NivelRisco**: Enum para níveis de risco (Neutro, Leve, Moderado, Agudo)
- **TipoHumor**: Enum para tipos de humor disponíveis
- **TipoRecurso**: Enum para tipos de recursos (Artigo, Vídeo, Exercício, Contato)

#### 4.2.2 Repositório de Dados (data/)
- **RepositorioDados**: Fornece dados mockados para todas as funcionalidades

#### 4.2.3 Telas (ui/screens/)
- **TelaAvaliacao**: Avaliação de riscos psicossociais
- **TelaBemEstar**: Registro e acompanhamento do humor
- **TelaRecursos**: Acesso a recursos de apoio
- **TelaVisualizacao**: Visualização de dados consolidados
- **TelaLembretes**: Lembretes e dicas personalizadas

#### 4.2.4 Navegação
- **MainActivity**: Gerencia a navegação entre as telas principais
- **TelaApp**: Enum que define as telas principais do aplicativo

## 5. Fluxo da Aplicação

### 5.1 Fluxo Principal

1. O usuário inicia o aplicativo e é apresentado à tela de Bem-estar
2. Através da barra de navegação inferior, o usuário pode acessar as cinco funcionalidades principais:
   - Bem-estar
   - Avaliação
   - Recursos
   - Visualização
   - Lembretes

### 5.2 Fluxos Específicos

#### 5.2.1 Fluxo de Avaliação de Riscos
1. Usuário acessa a tela de Avaliação
2. Responde às perguntas sobre fatores de risco psicossocial
3. Ao finalizar, recebe um resultado com seu nível de risco
4. Recebe recomendações personalizadas com base no nível de risco

#### 5.2.2 Fluxo de Registro de Bem-estar
1. Usuário acessa a tela de Bem-estar
2. Seleciona seu humor atual e nível de estresse
3. Opcionalmente, adiciona observações
4. Salva o registro
5. Visualiza histórico recente de registros

#### 5.2.3 Fluxo de Acesso a Recursos
1. Usuário acessa a tela de Recursos
2. Pode filtrar recursos por tipo ou buscar por palavras-chave
3. Seleciona um recurso para ver detalhes
4. Acessa o conteúdo completo do recurso

#### 5.2.4 Fluxo de Visualização de Dados
1. Usuário acessa a tela de Visualização
2. Visualiza resumo do período selecionado
3. Analisa gráficos de evolução do humor e estresse
4. Recebe insights sobre tendências e recomendações

#### 5.2.5 Fluxo de Lembretes
1. Usuário acessa a tela de Lembretes
2. Visualiza lembretes diários configurados
3. Pode ativar/desativar lembretes
4. Recebe dicas personalizadas com base em seu histórico

## 6. Funcionalidades Implementadas

### 6.1 Avaliação de Riscos Psicossociais
- Questionário baseado nos fatores de risco da NR1
- Cálculo de nível de risco (Neutro, Leve, Moderado, Agudo)
- Recomendações personalizadas com base no resultado

### 6.2 Acompanhamento do Bem-estar Emocional
- Registro diário de humor com emojis
- Escala de nível de estresse (1-10)
- Histórico de registros recentes
- Campo para observações pessoais

### 6.3 Recursos de Apoio
- Biblioteca de recursos categorizados (artigos, vídeos, exercícios, contatos)
- Filtros por tipo de recurso
- Busca por palavras-chave
- Visualização detalhada de cada recurso

### 6.4 Visualização de Dados Consolidados
- Resumo do período selecionado
- Gráfico de evolução do humor
- Análise de tendência de estresse
- Recomendações baseadas nos dados

### 6.5 Lembretes e Dicas Personalizadas
- Lembretes diários configuráveis
- Dicas personalizadas com base no histórico
- Ativação/desativação de notificações

## 7. Conformidade com a NR1

### 7.1 Identificação de Riscos Psicossociais
O aplicativo implementa um sistema de avaliação baseado nos fatores de risco psicossocial definidos na NR1, permitindo a identificação precoce de situações que podem afetar a saúde mental dos trabalhadores.

### 7.2 Monitoramento Contínuo
Através do registro diário de humor e nível de estresse, o aplicativo possibilita o monitoramento contínuo do bem-estar emocional, atendendo à exigência de acompanhamento regular prevista na NR1.

### 7.3 Acesso a Recursos de Apoio
A biblioteca de recursos oferece materiais educativos e de apoio, cumprindo a diretriz da NR1 sobre disponibilização de informações e suporte aos trabalhadores.

### 7.4 Análise de Dados e Tendências
A visualização de dados permite identificar padrões e tendências, auxiliando na implementação de medidas preventivas conforme recomendado pela NR1.

### 7.5 Privacidade e Anonimato
O aplicativo garante o anonimato do usuário, não coletando informações que possam identificar o funcionário, em conformidade com as diretrizes de confidencialidade da NR1.

## 8. Considerações de Implementação

### 8.1 Persistência de Dados
Na Sprint 1, os dados são simulados em memória através do RepositorioDados. Em versões futuras, será implementada a persistência local com Room Database e sincronização com APIs REST.

### 8.2 Autenticação
O aplicativo não implementa autenticação de usuários para garantir o anonimato, conforme requisito do projeto. Cada dispositivo mantém seus próprios dados localmente.

### 8.3 Responsividade
A interface foi desenvolvida com Jetpack Compose, garantindo adaptabilidade a diferentes tamanhos de tela e orientações.

### 8.4 Acessibilidade
Foram aplicadas práticas de acessibilidade como contraste adequado, tamanhos de fonte ajustáveis e suporte a TalkBack.

## 9. Próximos Passos

### 9.1 Melhorias Planejadas
- Implementação de persistência local com Room Database
- Integração com APIs REST reais
- Adição de notificações push para lembretes
- Expansão dos recursos de visualização de dados
- Implementação de testes automatizados

### 9.2 Considerações para Sprints Futuras
- Sincronização de dados com servidores remotos
- Exportação de relatórios de bem-estar
- Gamificação para incentivar o uso regular
- Integração com wearables para monitoramento passivo

## 10. Conclusão

O aplicativo Softtek Saúde Mental atende a todos os requisitos da Sprint 1, oferecendo uma solução completa para apoio à saúde mental e psicossocial dos funcionários, em conformidade com as exigências da NR1. A arquitetura modular e a interface intuitiva proporcionam uma experiência de usuário acolhedora e eficaz, permitindo que os funcionários monitorem seu bem-estar emocional de forma anônima e segura.
