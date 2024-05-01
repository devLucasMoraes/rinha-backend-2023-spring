# Use a imagem oficial do Maven como base para construir o aplicativo
FROM maven:3.9.5-amazoncorretto-17 as build

# Defina o diretório de trabalho
WORKDIR /app

# Copie todo o código-fonte para o contêiner
COPY . .

# Compile e empacote o aplicativo (sem executar testes)
RUN mvn clean package -DskipTests

# Use uma imagem menor do OpenJDK para executar o aplicativo
FROM openjdk:17-jdk-alpine

# Copie o arquivo JAR empacotado do estágio de construção
COPY --from=build /app/target/*.jar app.jar

# Exponha a porta em que o aplicativo irá rodar
EXPOSE 8080

# Defina o comando para executar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]