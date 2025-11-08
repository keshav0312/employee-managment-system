# 1) Build stage: uses Maven to build the project
FROM eclipse-temurin:17-jdk as build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# 2) Run stage: lightweight image
FROM eclipse-temurin:17-jre
WORKDIR /app
ENV PORT=8080
EXPOSE 8080
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]
