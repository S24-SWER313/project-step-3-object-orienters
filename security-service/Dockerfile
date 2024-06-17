FROM openjdk:23-jdk-slim-bullseye
WORKDIR /app
COPY target/*.jar /app/security-service.jar
CMD ["java", "-jar", "/app/security-service.jar"]
EXPOSE 8082