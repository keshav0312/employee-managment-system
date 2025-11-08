# Use Java (JRE) 17 to run our Spring Boot app
FROM eclipse-temurin:17-jre

# Render gives a PORT, so we use it
ENV PORT=8080

# Expose that port from the container
EXPOSE 8080

# Copy the final .jar file from Maven build into container and rename it to app.jar
COPY target/employee-management-system-0.0.1-SNAPSHOT.jar app.jar

# Start the application
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]
