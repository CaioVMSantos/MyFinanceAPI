# 💰 MyFinance - Gestor de Despesas Pessoais

> **Status do Projeto:** 🚧 Backend Concluído | Frontend em Desenvolvimento

Sistema Fullstack para gestão e controlo de finanças pessoais (receitas e despesas).
Este projeto foi desenvolvido com foco estrito em **Boas Práticas de Engenharia de Software**, simulando um ambiente corporativo real com contentores Docker, versionamento de base de dados e testes automatizados.

---

## 🚀 Tecnologias e Ferramentas

### ☕ Backend (API REST)
- **Java 17** & **Spring Boot 3**
- **Spring Data JPA** (Persistência de dados)
- **PostgreSQL** (Base de dados relacional via Docker)
- **Flyway** (Migrations e Versionamento de Schema)
- **MapStruct** (Mapeamento eficiente Entity ↔ DTO)
- **Bean Validation** (Validação de dados de entrada e tratamento de erros)
- **JUnit 5 & Mockito** (Testes Unitários da camada de Serviço)
- **Swagger / OpenAPI** (Documentação viva da API)
- **Docker Compose** (Orquestração do ambiente de desenvolvimento)

### 🅰️ Frontend (SPA) - *Em Breve*
- **Angular** (Framework Principal)
- **Bootstrap 5** (Estilização e Responsividade)
- **HttpClient** (Consumo da API REST)

---

## 🏛️ Arquitetura e Padrões de Projeto
O sistema foi desenhado seguindo uma arquitetura em camadas para garantir desacoplamento, manutenção e testabilidade:

1.  **Controller Layer:** Responsável apenas por receber as requisições HTTP e validar os DTOs de entrada.
2.  **Service Layer:** Contém toda a regra de negócio (cálculos, validações lógicas).
3.  **Repository Layer:** Interface de comunicação com a base de dados (Spring Data JPA).
4.  **DTOs (Data Transfer Objects):** Utilizados para não expor as Entidades JPA diretamente à API, garantindo segurança e flexibilidade.
5.  **Global Exception Handler:** Utilização de `@ControllerAdvice` para capturar exceções e devolver respostas HTTP padronizadas (400, 404, 500) com mensagens claras (JSON).

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos
- Java 17+
- Docker & Docker Compose instalado e a correr.
- IDE (IntelliJ IDEA ou Eclipse) com suporte a Lombok.

### 1. Subir a Infraestrutura (Base de Dados)
Na raiz do projeto (onde se encontra o arquivo `docker-compose.yml`), execute o comando:

```bash
docker-compose up -d
````

*Isto irá criar um contentor PostgreSQL e um volume para persistência dos dados.*

### 2. Executar o Backend

1. Abra o projeto na sua IDE.
2. Certifique-se de configurar as variáveis de ambiente na IDE, caso não esteja a usar o perfil padrão:

   * `DB_USER` (Padrão: admin)
   * `DB_PASSWORD` (Padrão: admin)
3. Execute a classe principal `MyFinanceApplication`.
4. O **Flyway** irá criar automaticamente as tabelas na base de dados ao iniciar.

### 3. Aceder à Documentação (Swagger)

Com o backend a correr, aceda ao seguinte endereço no navegador para testar os endpoints:

* **Swagger UI:** `http://localhost:8080/swagger-ui.html`

---

## 🧪 Testes Automatizados

O projeto possui cobertura de testes unitários na camada de serviço, garantindo a integridade das regras de negócio.

Para rodar os testes via terminal:

```bash
./mvnw test
```

## 📝 Licença

Este projeto foi desenvolvido para fins de estudo e portfólio, demonstrando competências em desenvolvimento Fullstack com Java e Angular.

```

Se quiser, posso **otimizar**, **deixar mais profissional**, **adicionar imagens**, **badges**, **diagrama da arquitetura**, ou **melhorar a descrição do projeto**.
```
