# backend/ms-user/Dockerfile

# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Builder le microservice User
WORKDIR /app/backend/ms-user

# Optimisation du cache des dépendances pour ms-user
COPY backend/ms-user/pom.xml .
RUN mvn dependency:go-offline -B

# Copie des sources et build
COPY backend/ms-user/src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copier le JAR final
COPY --from=build /app/backend/ms-user/target/*.jar app.jar

# Exposer le port
EXPOSE 8081

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
