# ---- Stage 1: Build & Test ----
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy only the POM first to leverage Docker layer caching for dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Now copy the source and run the full build (this executes JUnit tests too)
COPY src ./src
RUN mvn clean package -B

# ---- Stage 2: Run ----
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy only the built jar from the build stage
COPY --from=build /app/target/FibonacciSequence-1.5.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]