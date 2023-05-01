FROM openjdk:17
ARG JAR_FILE=target/*.jar
# COPY env.properties env.properties
COPY ./target/student-survey-jar.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]