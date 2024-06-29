FROM maven:3.8.7-eclipse-temurin-19-alpine as build

COPY . /usr/src/mymaven/

WORKDIR /usr/src/mymaven/
RUN mvn clean install -Dmaven.test.skip=true -P prod

EXPOSE 8080
ENTRYPOINT ["java","-jar","target/Mandarinit-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]