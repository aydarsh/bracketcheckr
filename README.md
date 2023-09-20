# Bracket Checkr
This is a simple web service for checking the correctness of brackets in a text.

## Docker Hub Repository
The Docker image for this application is available at [`aydarsh/bracketcheckr`](https://hub.docker.com/r/aydarsh/bracketcheckr) repository on Docker Hub.

## API Access
The API for this application is accessible via `http://localhost:8080/api`.

## API Documentation
The API documentation can be accessed at `http://localhost:8080/swagger-ui.html` once the application is running.

## Functionality
- Brackets correctness checking

## GitHub Actions CI Pipeline
The repository has a GitHub Actions CI pipeline configured to build a Docker image and push it to Docker Hub. In order to build a Docker image with a SemVer or `latest` tag, the repository must be tagged and the tag must be pushed.

## Endpoints
- `/api/checkBrackets`: Endpoint for checking correctness of brackets in text.

## Requirements
The following tools are required to run this application:
- Java 17 or higher
- Docker and Docker Compose
- Gradle

## Running the Application
You can run this application using Docker and Docker Compose. Simply run the following command in the root directory of the application:
```
docker-compose up --pull always
```
This will start the application and you can access the API at `http://localhost:8080/api`.
