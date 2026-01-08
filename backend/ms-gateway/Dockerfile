# Stage 1: Build
FROM maven:3.9.9-amazoncorretto-17 AS build
WORKDIR /app

# Copy only pom for faster caching
COPY pom.xml .

# Use a stable, retry-enabled offline preparation
RUN mvn -B -e -U dependency:go-offline \
    -Dmaven.wagon.http.retryHandler.count=10 \
    -Dmaven.wagon.http.pool=false \
    -Dmaven.wagon.httpconnectionManager.ttlSeconds=1200 \
    -Dmaven.wagon.rto=100000

# Copy project source
COPY src ./src

# Build the application (with retry)
RUN mvn clean package -DskipTests -B \
    -Dmaven.wagon.http.retryHandler.count=10 \
    -Dmaven.wagon.rto=100000

# Stage 2: Run
FROM amazoncorretto:17
WORKDIR /app

# Copy executable JAR
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8088
ENTRYPOINT ["java", "-jar", "app.jar"]
