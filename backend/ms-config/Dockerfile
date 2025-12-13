# backend/ms-config/Dockerfile

# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Optimisation du cache des dépendances
COPY pom.xml .
RUN mvn dependency:go-offline -B -Dmaven.wagon.http.retryHandler.count=5 -Dmaven.wagon.httpconnectionManager.ttlSeconds=600
# Copie des sources et build
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copier le JAR final
COPY --from=build /app/target/*.jar app.jar

# Copier les configurations
COPY contracts ./contracts

# Exposer le port
EXPOSE 8888

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
