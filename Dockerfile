FROM eclipse-temurin:25-jdk AS build
LABEL authors="Natnael Tegegne"

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw clean package -DskipTests

# run stage
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

# NTS: this tells the container to run a -jar file called app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]