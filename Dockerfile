FROM openjdk:8-jdk-alpine
VOLUME /app
COPY target/*.jar spring-mongo-bundle.jar
ENTRYPOINT ["java", "-jar","/spring-mongo-bundle.jar", "--spring.profiles.active=prod"]
