FROM openjdk:23-jdk-slim-bullseye
WORKDIR /app
EXPOSE 8761
COPY target/*.jar /app/naming-server.jar
CMD ["java", "-jar", "/app/naming-server.jar"]

