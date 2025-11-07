# Use Java 21 runtime
FROM eclipse-temurin:21-jre

# Set working directory
WORKDIR /app

# Copy final JAR to container (keep name simple)
COPY target/employee-management-system.jar app.jar

# Expose backend port (change if your server runs on different port)
EXPOSE 8081

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
