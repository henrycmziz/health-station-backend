FROM openjdk:8u312-jre
MAINTAINER Henry<henrycmziz@gmail.com>
WORKDIR /app
COPY backend-admin.jar app.jar
CMD ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]