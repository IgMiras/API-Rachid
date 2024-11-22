# Usar uma imagem base para o JDK 23
FROM eclipse-temurin:23-jdk

# Diretório de trabalho no contêiner
WORKDIR /app

# Copiar o JAR gerado para o contêiner
COPY build/libs/rachid-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
