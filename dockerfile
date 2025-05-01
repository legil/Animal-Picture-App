# Use an official OpenJDK 21 image as the base
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR file into the image
COPY target/animal-picture-app-0.0.1-SNAPSHOT.jar app.jar

# Expose the app port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]