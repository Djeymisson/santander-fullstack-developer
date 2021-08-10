# Spring Cloud Project

Projeto criado para demonstrar como funciona uma arquitetura de software baseada em micros serviços usando Spring Cloud (2.5.3) e containers Dockers para armazenamento com ElasticSearch (7.13.3) e Redis (3.0.1).

## Arquitetura do projeto

![arquitetura do projeto](https://github.com/Djeymisson/santander-fullstack-developer/blob/main/spring-cloud/arch.png)

O projeto está consistido por:

- [product-catalog](https://github.com/Djeymisson/santander-fullstack-developer/tree/main/spring-cloud/product-catalog) - serviço para controle dos produtos disponíveis no catálogo utilizando ElasticSearch para armazenamento e consulta.
- [shopping-cart](https://github.com/Djeymisson/santander-fullstack-developer/tree/main/spring-cloud/shopping-cart) - serviço para gerenciamento de carrinho de compras utilizando Redis para armazenamento em memória.
- [config-server](https://github.com/Djeymisson/santander-fullstack-developer/tree/main/spring-cloud/config-server) - serviço de configuração centralizada.
- [gateway](https://github.com/Djeymisson/santander-fullstack-developer/tree/main/spring-cloud/gateway) - serviço da api-gateway.
- [service-discovery](https://github.com/Djeymisson/santander-fullstack-developer/tree/main/spring-cloud/service-discovery) - servidor Eureka.
- [config-repo](https://github.com/Djeymisson/santander-fullstack-developer/tree/main/spring-cloud/config-repo) - pasta com todas os arquivos de configuração dos micro serviços que é carregada pelo config-server.

Os containers dockers podem ser inicializados usando na raiz do projeto:

```sh
docker-compose up -d
```
