FROM openjdk:8-jdk-alpine
COPY target/rest-api-0.0.1-SNAPSHOT.jar rest-api-1.0.0.jar
ENTRYPOINT ["java","-jar","/rest-api-1.0.0.jar"]
