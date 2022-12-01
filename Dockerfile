FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

