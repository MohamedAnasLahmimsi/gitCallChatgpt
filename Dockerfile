FROM maven:3.8.7-eclipse-temurin-17-alpine AS MAVEN_BUILD

WORKDIR /app

COPY ./ ./

RUN mvn package

FROM openjdk:17-alpine3.14

WORKDIR /

RUN mkdir /data
RUN touch /data/data.csv
RUN echo "question;reponse" > /data/data.csv


COPY --from=MAVEN_BUILD /target/*.jar app.jar

RUN pwd
RUN ls -l
RUN ls ./data

EXPOSE 8080
CMD [ "java", "-jar", "app.jar" ]