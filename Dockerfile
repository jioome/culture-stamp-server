FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/*.jar
COPY culture-stamp-server/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

