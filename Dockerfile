FROM openjdk:17-alpine

ARG DB_URL
ARG DB_DATABASE

ENV MONGO_URI=$DB_URL
ENV MONGO_DATABASE=$DB_DATABASE

COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]






