FROM openjdk:23-jdk-slim-bullseye
WORKDIR /app
COPY target/*.jar /app/messaging-service.jar
COPY target/classes/techspot-objectorienters-firebase-adminsdk-bqho2-f5981f1058.json /app/messages-service/src/main/resources/techspot-objectorienters-firebase-adminsdk-bqho2-f5981f1058.json

CMD ["java", "-jar", "/app/messaging-service.jar"]
EXPOSE 8081
