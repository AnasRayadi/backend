FROM maven:alpine AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install package -DskipTests

FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]