# backend/ms-config/Dockerfile

# Stage 1: build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copier pom et sources
COPY pom.xml .
COPY src ./src

# Build du projet
RUN mvn clean package -DskipTests

# Stage 2: run
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copier le JAR final en le renommant en app.jar
COPY --from=build /app/target/*.jar app.jar

# Exposer le port du Config Server
EXPOSE 8888

# Lancer l'application
ENTRYPOINT ["java","-jar","app.jar"]
