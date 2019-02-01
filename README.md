# Desafio

## Como executar
Clone o Projeto para um diretório qualquer em seu computador

```bash
git clone https://github.com/napalm23zero/cv-challenge_spring.git
```

Depois navegue até o diretório criado
```bash
cd cv-challenge_spring
```

### Com Docker
É necessário instalar em sua maquina:
- [Docker](https://www.docker.com/) 

Execute o comando:
```bash
docker-compose up
```

### Sem Docker
É necessário instalar em sua maquina:
- [MySQL](https://www.mysql.com/)
- [Apache Maven](https://maven.apache.org/)

Execute o comando:
```bash
mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=local"
```

## Como acessar
Uma vez que o projeo esteja rodando corretamente, abra seu navegador e acesso a url
```
http://localhost:8080/challenge/api/swagger-ui.html
```

Uma inteface do Swagger será exibida para que você possa navegar entre os endpoint criados

## Sobre o Desafio
- Teste 1: Pode ser validada através do metodo GET /broker/hotel/price/all em azul no Swagger
- Teste 2: Pode ser validada através do metodo GET /broker/hotel/price em azul no Swagger

P.S.: A aplicação tambem comporta a persistencia de dados no banco obedecendo o mesmo padrão do Broker, sinta-se a vontade para explorar a api.

## Duvidas
- skype: napalm23zero
- email: rodrigodantas.91@gmail.com