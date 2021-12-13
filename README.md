# Table of Contents
- [**Introduction**](#introduction)
- [**Getting Started**](#getting-started)
    - [Maven](#maven)
    - [Docker](#docker)
    - [Rest-API](#rest-api)

# **Introduction**
The rest-api service demostrates the use of Spring Boot project to expose REST API.
This service is integrated with,
*  Spring Boot v2.6
*  H2 InMem database & JPA for CRUD Operations,
*  Spring Actuator for health check, application and server metrics
*  Swagger-ui using Springdoc-openapi

# **Getting Started**

## Maven
Clone / download the project and run the below mvn command. Prerequisite - install Maven on your system.

```
mvn clean install
```

## Docker
Build docker image amd push to Docker Registry. Prerequisite docker daemon is up and running.
Refer "Dockerfile" for pushing the image to Docker registry.

```
##Build docker image & tag
docker build -t dbaficianado/dh2.0:${BUILD_NUMBER} .

##Run container. Port forwarding via inbound request to 80 -> 9091.
docker run -d -p 80:9091 --name rest-api-${BUILD_NUMBER} dbaficianado/dh2.0:${BUILD_NUMBER}
```

## Rest-API

Swagger UI
```
http://13.233.138.190/actuator/health
```
Spring Actuator
```
http://13.233.138.190/actuator/health
```
Rest APIs
```
http://13.233.138.190/hello
http://13.233.138.190/rider
```
