# Etapa 1: Compilación del proyecto
FROM maven:3.9.5-eclipse-temurin AS builder

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con OpenJDK
FROM openjdk:17-jdk-slim AS runtime

WORKDIR /app
COPY --from=builder /app/target/programacion-reactiva-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
