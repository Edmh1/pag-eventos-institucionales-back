# Usar una imagen base de Maven
FROM maven:3.8.4-openjdk-17-slim AS builder

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el código fuente al contenedor
COPY . /app

# Compilar el proyecto y generar el archivo JAR
RUN mvn clean package -DskipTests

# Usar una imagen base de OpenJDK para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR del contenedor builder al contenedor final
COPY --from=builder /app/target/pag-eventos-institucionales-back-0.0.1-SNAPSHOT.jar /app/pag-eventos-institucionales-back-0.0.1-SNAPSHOT.jar

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/pag-eventos-institucionales-back-0.0.1-SNAPSHOT.jar"]
