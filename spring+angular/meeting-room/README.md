# Meeting Room API

## Versões utilizadas

- Gradle 7.1.1
- Spring Boot 2.5.3
- Java 11+

## Dependências

- Spring Data JPA
- Spring Web
- Spring Cloud
- Spring Devtools
- Jakarta Bean Validation
- Lombok

## Configuração

A API está configurada com os seguintes parâmetros no *application.yml* e banco de dados H2 em memória:

```yaml
server:
  port: 8080

spring:
  # H2 Connection
  h2:
    console:
      enabled: true # Enabling H2 Console
      path: /h2-console
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      dialect: org.hibernate.dialect.H2Dialect
      ddl-auto: create
      type: TRACE
    show_sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.H2Dialect

```



## Executando o projeto

```sh
gradlew bootRun
```

