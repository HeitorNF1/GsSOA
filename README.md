# 📘 WorkOfFuture API — README

## 📝 Descrição do Projeto
Este projeto é uma API RESTful desenvolvida em **Java 17** com **Spring Boot 3.5.7**, responsável por gerenciar trilhas de aprendizado e usuários dentro da plataforma de capacitação para profissões do futuro.

---

## ⚙️ Tecnologias Utilizadas
- Java 17  
- Spring Boot 3.5.7  
- Spring Data JPA  
- Maven  
- MySQL 8  
- Lombok  

---

## ⚙️ Configurações — application.properties

spring.application.name=workOfFuture  
spring.datasource.url=jdbc:mysql://localhost:3306/gs_db  
spring.datasource.username=heitor  
spring.datasource.password=heitor123  
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  

spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect  

spring.jpa.defer-datasource-initialization=true  
spring.sql.init.mode=always  

---

## ▶️ Como Executar o Projeto

No diretório do projeto, execute:

mvn spring-boot:run

A API estará disponível em:  
http://localhost:8080

---

# 📚 Endpoints — TRILHAS DE APRENDIZADO

## ➕ Criar Trilha  
**POST /api/trilhas**

Exemplo de JSON:
{
  "nome": "Inteligência Artificial Aplicada",
  "descricao": "Trilha avançada para uso de IA no mercado.",
  "nivel": "AVANCADO",
  "criadorId": "11111111-1111-1111-1111-111111111111"
}

---

## 📋 Listar Todas  
**GET /api/trilhas**

---

## 🔍 Buscar por ID  
**GET /api/trilhas/{id}**

---

## ✏️ Atualizar Trilha  
**PUT /api/trilhas/{id}**

Exemplo:
{
  "nome": "IA Aplicada — Atualizado",
  "descricao": "Trilha revisada com novos conteúdos.",
  "nivel": "INTERMEDIARIO"
}

---

## ❌ Excluir Trilha  
**DELETE /api/trilhas/{id}**

---

# 👤 Endpoints — USUÁRIOS

## ➕ Criar Usuário  
**POST /users**

Exemplo:
{
  "nome": "Heitor Nobre",
  "email": "heitor@example.com",
  "senha": "123456"
}

---

## 📋 Listar Usuários  
**GET /users**

---

## 🔍 Buscar Usuário por ID  
**GET /users/{id}**

---

## ✏️ Atualizar Usuário  
**PUT /users/{id}**

---

## ❌ Excluir Usuário  
**DELETE /users/{id}**

---

## 🧪 Testes e Ferramentas
Você pode testar a API via:
- Postman  
- Insomnia  
- Thunder Client (VSCode)

---

## 🐳 Banco de Dados via Docker
Certifique-se de ter um container MySQL rodando:

docker run -d -p 3306:3306 --name mysql-gs -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=gs_db mysql:8
