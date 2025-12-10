
````markdown
# 💰 MyFinance - Controle de Finanças Pessoais

Projeto Fullstack desenvolvido para gerenciar despesas e receitas, focado em boas práticas de Engenharia de Software e simulação de ambiente corporativo.

## 🚀 Tecnologias Utilizadas

### Backend (API)
- **Java 17** & **Spring Boot 3**
- **PostgreSQL** (Banco de Dados Relacional)
- **Flyway** (Versionamento de Banco de Dados/Migrations)
- **MapStruct** (Mapeamento eficiente Entidade <-> DTO)
- **Validation** (Tratamento de erros e validação de dados)
- **JUnit 5 & Mockito** (Testes Unitários de regras de negócio)
- **Swagger/OpenAPI** (Documentação viva da API)
- **Docker Compose** (Containerização do ambiente de banco de dados)

### Frontend (Web)
- **Angular** (Framework SPA)
- **Bootstrap** (Estilização e Responsividade)
- **Integração via HttpClient** (Consumo da API REST)

## ⚙️ Como Rodar

### Pré-requisitos
- Java 17+
- Node.js e Angular CLI
- Docker

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/myfinance.git](https://github.com/seu-usuario/myfinance.git)


2.  **Suba o banco de dados:**
    Na raiz do projeto (onde está o `docker-compose.yml`):

    ```bash
    docker-compose up -d
    ```

3.  **Backend:**
    Abra o projeto no IntelliJ/Eclipse e execute a classe `MyFinanceApplication`.

      - A API estará disponível em: `http://localhost:8080`
      - Documentação Swagger: `http://localhost:8080/swagger-ui.html`

4.  **Frontend:**
    Entre na pasta do frontend:

    ```bash
    cd my-finance-front
    npm install
    ng serve
    ```

      - Acesse a aplicação em: `http://localhost:4200`

## 🧠 Aprendizados

Neste projeto, apliquei conceitos fundamentais para o mercado de trabalho:

  - **Arquitetura em Camadas:** Separação clara entre Controller, Service, Repository e Domain.
  - **DTOs (Data Transfer Objects):** Para desacoplar a entidade do banco da resposta da API.
  - **Tratamento Global de Erros:** Uso de `@ControllerAdvice` para padronizar respostas HTTP (400, 404, 500).
  - **Testes Automatizados:** Garantia de qualidade na camada de serviço simulando cenários de sucesso e erro.

<!-- end list -->
