# ============================
# Stage 1: build da aplicação
# ============================
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o pom.xml e baixa dependências
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# Copia o código e faz o build
COPY src ./src
RUN mvn -q -DskipTests clean package

# ============================
# Stage 2: imagem final (runtime)
# ============================
FROM eclipse-temurin:21-jre

WORKDIR /app

# copia o jar gerado do estágio de build
COPY --from=build /app/target/*.jar app.jar

# Porta que o Render expõe pra serviços Docker
EXPOSE 10000

# Render define a variável PORT=10000
ENV PORT=10000
ENV SPRING_PROFILES_ACTIVE=prod

ENTRYPOINT ["java","-jar","/app/app.jar","--server.port=${PORT}"]
