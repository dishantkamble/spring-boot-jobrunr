FROM maven:3.8-openjdk-18-slim AS build
LABEL maintainer="dishantk@gmail.com"
WORKDIR /build
COPY src /build/src
COPY pom.xml .
RUN mvn dependency:go-offline -B
RUN mvn package -DskipTests

FROM sapmachine:lts-jre-headless-ubuntu
COPY --from=build /build/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
