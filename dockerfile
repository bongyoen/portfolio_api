FROM openjdk:17-alpine
ARG JAR_FILE=/build/libs/portfolio_api-0.0.2-SNAPSHOT.jar
COPY ${JAR_FILE} /portfolio_api.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod", "/portfolio_api.jar"]