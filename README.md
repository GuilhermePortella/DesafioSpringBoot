# Documentação do Projeto Spring Boot - Sistema Bancário

## Resumo do Projeto
Este projeto é uma API REST desenvolvida com Spring Boot para gerenciar transações bancárias e fornecer estatísticas das transações realizadas. O sistema permite o registro de transações e a obtenção de estatísticas agregadas, como soma, média, mínimo, máximo e quantidade de transações.

## Sobre o Spring Boot
O Spring Boot é um framework open source baseado no Spring, que facilita a criação de aplicações Java stand-alone e prontas para produção. Ele elimina grande parte da configuração manual, fornecendo um ambiente de desenvolvimento rápido, seguro e com boas práticas integradas. O Spring Boot oferece:
- Inicialização rápida de projetos
- Configuração automática
- Servidor embutido (Tomcat, Jetty, etc.)
- Facilidade de integração com bancos de dados e outros serviços

## Como Rodar a Aplicação
### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+

### Passos para execução
1. Clone o repositório ou baixe o código-fonte.
2. Navegue até a pasta do projeto:
   ```sh
   cd springboot
   ```
3. Compile o projeto e execute os testes (opcional):
   ```sh
   ./mvnw clean install
   ```
4. Inicie a aplicação:
   ```sh
   ./mvnw spring-boot:run
   ```
   Ou execute o JAR gerado:
   ```sh
   java -jar target/springboot-0.0.1-SNAPSHOT.jar
   ```
5. A aplicação estará disponível em: `http://localhost:8080`

## Endpoints Disponíveis

### 1. Registrar Transação
- **URL:** `/transactions`
- **Método:** `POST`
- **Descrição:** Registra uma nova transação bancária.
- **Request Body:**
  ```json
  {
    "valor": 100.0,
    "dataHora": "2025-06-03T10:15:30Z"
  }
  ```
- **Respostas:**
  - `201 Created`: Transação registrada com sucesso
  - `400 Bad Request`: Dados inválidos

### 2. Limpar Transações
- **URL:** `/transactions`
- **Método:** `DELETE`
- **Descrição:** Remove todas as transações registradas.
- **Respostas:**
  - `204 No Content`: Transações removidas

### 3. Estatísticas das Transações
- **URL:** `/statistics`
- **Método:** `GET`
- **Descrição:** Retorna estatísticas (soma, média, mínimo, máximo, quantidade) das transações registradas.
- **Response Body:**
  ```json
  {
    "sum": 200.0,
    "avg": 100.0,
    "max": 150.0,
    "min": 50.0,
    "count": 2
  }
  ```

## Dependências Principais
- **Spring Boot Starter Web:** Para criação de APIs REST
- **Spring Boot Starter Validation:** Para validação de dados
- **Jakarta Validation:** Anotações de validação
- **Maven Wrapper:** Facilita o build sem necessidade de instalação prévia do Maven

As dependências estão listadas no arquivo `pom.xml`.

## Estrutura do Projeto
- `controller/` - Controllers REST (endpoints)
- `dto/` - Objetos de transferência de dados
- `model/` - Modelos de domínio
- `service/` - Lógica de negócio