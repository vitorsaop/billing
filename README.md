# Billing Service API

Este projeto é um microserviço de bilhetagem que registra requisições feitas a outras APIs do ecossistema financeiro (como a API de PIX). Utiliza RabbitMQ para consumo de eventos e JWT para autenticação de acesso aos endpoints.


### ? Stack Tecnológica

-  Java 17
-  Spring Boot 3.2+
-  Spring Security (JWT)
-  Spring Data JPA + PostgreSQL
-  Spring for RabbitMQ
-  JJWT (Java JWT)
-  Docker + Docker Compose

### ? Funcionalidades

-  Recebe eventos de bilhetagem via fila RabbitMQ
-  Persiste os registros de cobrança
-  Expõe endpoint protegido JWT para listar registros
-  Endpoint de autenticação /auth/token para geração de token JWT

### ?? Requisitos

-  Docker & Docker Compose
-  Java 17+
-  Maven 3.9+

### ? Executar com Docker Compose

```

docker compose -f docker/docker-compose.yml -p containers-billing up --build

```
Esse comando inicializa o PostgreSQL e o Billing Service juntos.

### ? Autenticação via JWT

Obter Token

```

GET http://localhost:8090/auth/token

```

Resposta:
```
{
  "access_token": "<token>",
  "token_type": "Bearer",
  "expires_in": 3600
}
```

Usar token para acessar API protegida

```
GET http://localhost:8090/api/v1/billing
Authorization: Bearer <token>
```

### ? Estrutura de Pastas
```
src/main/java/br/com/itsolution/fintech/billing
|
|-- config/        # RabbitMQ, JWT e Spring Security
|-- controller/    # Endpoints REST (ex: AuthController)
|-- consumer/      # RabbitMQ Consumer
|-- dto/           # Objeto de mensagens da fila
|-- model/         # Entidades JPA
|-- repository/    # Interfaces JPA
|-- service/       # Lógica de negócio (persistência)
```

### ?? Variáveis de Ambiente (application.properties)

```
server.port=8090
spring.profiles.active=dev

billing.secret-key=billing-api-secret-key-256bit-minimum-safe-9876543210
billing.token-expiration-ms=3600000
```

Em produção, prefira usar billing.secret-key como variável de ambiente externa.
