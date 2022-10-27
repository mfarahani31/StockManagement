FROM adoptopenjdk/openjdk11
MAINTAINER farahani.dev@gmail.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]