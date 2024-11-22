Para rodar o projeto:

1- Apagar a pasta build

2- Rodar o mysql com docker-compose up -d database

3- Gerar o .jar do projeto pelo powershell (fechar IntelliJ):
    ./gradlew build

4- matar o mysql com docker-compose down -v

5- 
    wsl 
    docker-compose up --build

6- acessar http://localhost:8080

Por utilizar a dependência 'spring-boot-starter-security' do Spring Boot,
um formulário com username e password será exibido ao acessar alguma rota.
username: user
password: gerada no terminal ao executar o projeto