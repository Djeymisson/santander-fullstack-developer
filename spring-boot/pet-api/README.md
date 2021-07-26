<h2>Pet API</h2>

Projeto desenvolvido baseado no apresentado pelo especialista Rodrigo Peleias na trilha de Spring Boot do Bootcamp de Desenvolvedor Fullstack.

Essa API foi desenvolvida para servir como um serviço de Gerenciamento de Animais Domésticos e seus donos. Ela trabalha com três entidades:
* _Owner_: Que guarda as informações gerais e de contato sobre o dono do animal.
* _Pet_: Que registra as informações do animal, como data de nascimento, nome, e espécie.
* _Phone_: Que guarda as informações de telefones para contato do _Owner_.

A relação entre as entidades está como mostra o diagrama ER abaixo:

![DIAGRAMA_ER](https://github.com/Djeymisson/santander-fullstack-developer/blob/main/spring-boot/pet-api/er_diagram.png)

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, os seguintes _endpoints_ servem de ponto de partida para as operações:

```
// Para as operações com Owners
http://localhost:8081/api/owner 
```

```
// Para as operações com Pets
http://localhost:8081/api/pet
```

Os _endpoints_ adicionais podem ser vistos na documentação do _Swagger2_ disponível em:

```
// Para as operações com Pets
http://localhost:8081/swagger-ui/
```

O serviço também possui um arquivo de configuração de desenvolvimento como perfil ativo, que pode ser visualizado em [_src/main/resources/application-dev.yml_](https://github.com/Djeymisson/santander-fullstack-developer/blob/main/spring-boot/pet-api/src/main/resources/application-dev.yml).

São necessários os seguintes pré-requisitos para a execução dos projetos da aula:

* Java 11 ou versões superiores.
* Maven 3.6.3 ou versões superiores.
