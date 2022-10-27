FROM adoptopenjdk/openjdk11
MAINTAINER farahani.dev@gmail.com
COPY target/StockManagement-0.0.1-SNAPSHOT.jar StockManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/StockManagement-0.0.1-SNAPSHOT.jar"]