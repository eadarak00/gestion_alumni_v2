# backend/ms-invitation/Dockerfile

# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

# 1. Copier les contrats (nécessaire pour le SPI)
COPY contracts /app/contracts

# 2. Copier et builder le SPI User
COPY spi/spi-user /app/spi/spi-user
WORKDIR /app/spi/spi-user
RUN mvn clean install -DskipTests

# 3. Copier et builder le SPI Invitation
COPY spi/spi-invitation /app/spi/spi-invitation
WORKDIR /app/spi/spi-invitation
RUN mvn clean install -DskipTests

# 4. Builder le microservice Invitation
WORKDIR /app/backend/ms-invitation

# Optimisation du cache des dépendances pour ms-invitation
COPY backend/ms-invitation/pom.xml .
RUN mvn dependency:go-offline -B -Dmaven.wagon.http.retryHandler.count=5 -Dmaven.wagon.httpconnectionManager.ttlSeconds=600
# Copie des sources et build
COPY backend/ms-invitation/src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copier le JAR final
COPY --from=build /app/backend/ms-invitation/target/*.jar app.jar

# Exposer le port
EXPOSE 8083

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
