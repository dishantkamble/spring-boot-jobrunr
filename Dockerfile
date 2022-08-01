FROM maven:3.8.6-openjdk-11-slim AS build
LABEL maintainer="dishantk@gmail.com"
WORKDIR /build
COPY src /build/src
COPY pom.xml .
RUN mvn dependency:go-offline -B
RUN mvn package -DskipTests

FROM openjdk:20-jdk-slim
COPY --from=build /build/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
