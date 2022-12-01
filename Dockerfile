FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/*.jar
COPY culture-stamp-server/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

