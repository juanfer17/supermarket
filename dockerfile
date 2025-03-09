# Usamos una imagen oficial de OpenJDK
FROM openjdk:17-jdk-slim

# Configuramos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo JAR de nuestra aplicación al contenedor
COPY target/programacion-reactiva-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto en el que corre la app (ajústalo si usas otro)
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
