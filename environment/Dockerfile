FROM openjdk:11-jre-slim

COPY app.jar /usr/app/

WORKDIR /usr/app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]