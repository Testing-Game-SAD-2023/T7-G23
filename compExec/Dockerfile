FROM maven:3.8.3-openjdk-17
RUN mkdir projectUT
RUN mkdir App
COPY project_under_test/ projectUT/
COPY compExec-0.0.1-SNAPSHOT.jar App/CompExec.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/App/CompExec.jar"]