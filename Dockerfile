# First stage: Build the application
FROM eclipse-temurin:17-jdk AS builder
# Set the working directory
WORKDIR /app

# Copy the Gradle Wrapper files
COPY gradlew .
COPY gradle gradle
RUN chmod +x ./gradlew

# Copy the Gradle files and build the dependencies
COPY build.gradle .
COPY settings.gradle .
COPY gradle.properties .
RUN ./gradlew dependencies --no-daemon

# Copy the application code
COPY src src

# Build the application
RUN ./gradlew bootJar --no-daemon

# Second stage: Run the application
FROM eclipse-temurin:17-jre
# Set the working directory
WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Set the command to run the application
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
