# Utiliza una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR al contenedor
COPY target/pag-eventos-institucionales-back-0.0.1-SNAPSHOT.jar /app/pag-eventos-institucionales-back-0.0.1-SNAPSHOT.jar

# Expone el puerto en el que la aplicación escuchará (ajusta si tu aplicación usa otro puerto)
EXPOSE 8080

# Comando para ejecutar la aplicación JAR
ENTRYPOINT ["java", "-jar", "/app/pag-eventos-institucionales-back-0.0.1-SNAPSHOT.jar"]
