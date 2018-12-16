## ARQUITETURA
#### Back-end
	- Java, Spring Boot, Spring Data Jpa, Lombok, Liquibase e Teste integrado com Junit

#### Front-end
	- Webpack 2, angularJs 1.7 e ES6

#### Banco de dados 
	- Postgres

## TUTORIAL PARA EXECUÇÂO
#### Subir banco postgres via docker
	- database: postgres
	- user: postgres
	- senha: postgres
	1 - executar `docker run --name postgres -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres:alpine`

#### Subir front-end com webpack dev server na porta 8080
	1 - navegar ate diretorio /client
	2 - instalar node e npm
	3 - executar 'npm install'
	4 - executar 'npm start'

#### Subir back-end com maven na porta 8082
	1 - navegar ate diretorio /server
	2 - executar 'mvn clean install'
	3 - executar 'mvn spring-boot:run'

#### Acessar aplicação
	- Acessar http://localhost:8080