FROM eclipse-temurin:17.0.9_9-jdk-jammy

ARG JAR_FILE=target/*.jar

COPY target/backend-0.0.1-SNAPSHOT.jar backend.jar

EXPOSE 8080

CMD ["java", "-jar", "/backend.jar"]
