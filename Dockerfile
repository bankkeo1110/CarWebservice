# Start with a base image containing Java runtime
FROM openjdk:11-jdk-slim as build

# Add the application's jar to the container
COPY target/car-service-0.0.1-SNAPSHOT.jar car-service.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/car-service.jar"]
