FROM openjdk:23-jdk-slim-bullseye
WORKDIR /app
COPY target/*.jar /app/api-gateway.jar
CMD ["java", "-jar", "/app/api-gateway.jar"]
EXPOSE 8765
