FROM openjdk:23-jdk-slim-bullseye
WORKDIR /app
COPY target/*.jar /app/messaging-service.jar
CMD ["java", "-jar", "/app/messaging-service.jar"]
EXPOSE 8081
