FROM adoptopenjdk/openjdk11
MAINTAINER farahani.dev@gmail.com
WORKDIR /app
ARG JAR_FILE=./target/*.jar
COPY ./target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]