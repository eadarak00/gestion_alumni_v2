# backend/ms-cv-v2/Dockerfile

# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

# 1. Copier les contrats (nécessaire pour le SPI)
COPY contracts /app/contracts

# 2. Copier et builder le SPI CV
COPY spi/spi-cv-v2 /app/spi/spi-cv-v2
WORKDIR /app/spi/spi-cv-v2
RUN mvn clean install -DskipTests

# 3. Builder le microservice CV
WORKDIR /app/backend/ms-cv-v2

# Optimisation du cache des dépendances pour ms-cv
COPY backend/ms-cv-v2/pom.xml .
#RUN mvn dependency:go-offline -B

# Copie des sources et build
COPY backend/ms-cv-v2/src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copier le JAR final
COPY --from=build /app/backend/ms-cv-v2/target/*.jar app.jar

# Exposer le port
EXPOSE 8072

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
