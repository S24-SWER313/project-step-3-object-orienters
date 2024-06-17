FROM openjdk:23-jdk-slim-bullseye
WORKDIR /app
COPY target/*.jar /app/content-service.jar
CMD ["java", "-jar", "/app/content-service.jar"]
EXPOSE 8080
