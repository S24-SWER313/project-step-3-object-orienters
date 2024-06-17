FROM openjdk:23-jdk-slim-bullseye
WORKDIR /app
COPY target/*.jar /app/naming-server.jar
CMD ["java", "-jar", "/app/naming-server.jar"]
EXPOSE 8761
