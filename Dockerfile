# Use a lightweight base image with Java 17
FROM openjdk:17-jdk-alpine

# Optional: create a volume to persist temporary files
VOLUME /tmp

# Copy the packaged jar file into the container
COPY target/order-management-0.0.1-SNAPSHOT.jar app.jar


# Expose the port your app listens on (adjust if necessary)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
