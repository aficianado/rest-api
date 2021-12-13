FROM openjdk:8-jdk-alpine
LABEL maintainer="db.aficianado@gmail.com"
EXPOSE 9091
ARG JAR_FILE=$PWD/target/rest-api-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} rest-api.jar

ENTRYPOINT ["java","-Dserver.port=9091","-jar","/rest-api.jar"]