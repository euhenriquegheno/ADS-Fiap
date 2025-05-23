# Lista de Tarefas do Projeto: Serviço RESTful de Eficiência Energética

Este documento acompanha o desenvolvimento do serviço RESTful para eficiência energética e sustentabilidade.

## Planejamento e Definição

- [X] Escolher o tema ESG: Eficiência energética e sustentabilidade.
- [X] Confirmar requisitos gerais com o usuário.
- [X] Definir endpoints RESTful e funcionalidades detalhadas:
    - **Gerenciamento de Dispositivos de Medição:**
        - `POST /api/dispositivos`: Cadastrar novo dispositivo.
        - `GET /api/dispositivos`: Listar todos os dispositivos.
        - `GET /api/dispositivos/{id}`: Obter detalhes de um dispositivo.
    - **Registro e Consulta de Leituras de Consumo:**
        - `POST /api/leituras`: Registrar nova leitura de consumo.
        - `GET /api/leituras/dispositivo/{idDispositivo}`: Consultar histórico de leituras de um dispositivo.
        - `GET /api/leituras/dispositivo/{idDispositivo}/periodo?inicio={data}&fim={data}`: Consultar leituras de um dispositivo em um período.
    - **Configuração e Monitoramento de Alertas de Consumo:**
        - `POST /api/alertas/configuracoes`: Criar/atualizar configuração de alerta.
        - `GET /api/alertas/configuracoes/dispositivo/{idDispositivo}`: Consultar configurações de alerta de um dispositivo.
        - `GET /api/alertas/ocorrencias/dispositivo/{idDispositivo}`: Listar ocorrências de alertas de um dispositivo.

## Desenvolvimento e Implementação

- [X] Criar a estrutura do projeto Spring Boot (Java).
- [X] Implementar Models (Entidades JPA) para Dispositivo, Leitura, ConfiguracaoAlerta, OcorrenciaAlerta.
- [X] Implementar Repositories (Spring Data JPA) para as entidades.
- [X] Implementar Services para a lógica de negócio (Dispositivos, Leituras - Alertas pendentes).
- [X] Implementar Controllers para os endpoints RESTful definidos (Dispositivos, Leituras - Alertas pendentes).

## Segurança

- [X] Configurar Spring Security.
- [X] Definir regras de autenticação (ex: JWT ou Basic Auth) - (Implementado Basic Auth em memória).
- [X] Definir regras de autorização para os endpoints (Implementado proteção para /api/**).
## Banco de Dados

- [X] Configurar a integração com o banco de dados Oracle.
- [X] Implementar migrações de banco de dados (ex: Flyway ou Liquibase).
    - [X] Criar script inicial de criação das tabelas (Dispositivos, Leituras, ConfiguracoesAlertas, OcorrenciasAlertas).

## Containerização

- [X] Criar Dockerfile para a aplicação Spring Boot.
- [X] Criar arquivo `docker-compose.yml` para orquestrar a aplicação e o banco de dados Oracle (se possível, ou fornecer instruções para execução separada do Oracle).
- [X] Documentar o processo de build e execução com Docker.
## Testes e Validação

- [ ] Escrever testes unitários para Services.
- [ ] Escrever testes de integração para os Controllers/Endpoints.
- [ ] Validar o funcionamento completo da aplicação e testar todos os endpoints manualmente (ex: usando Postman ou curl).

## Documentação e Entrega

- [ ] Gerar documentação de uso da API (ex: Swagger/OpenAPI).
- [ ] Preparar um README.md com instruções de setup, build, execução e deploy.
- [ ] Reportar e entregar o projeto finalizado ao usuário com todos os artefatos.

