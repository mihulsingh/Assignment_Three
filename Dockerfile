FROM openjdk:17
EXPOSE 8080
# ARG JAR_FILE=target/*.jar
# COPY env.properties env.properties
COPY ./target/student-survey-jar.jar student-survey-jar.jar
ENTRYPOINT ["java","-jar","/student-survey-jar.jar"]