FROM openjdk:17-oracle
EXPOSE 8080
ADD target/taskmanager.jar taskmanager.jar
LABEL authors="anast"
ENTRYPOINT ["java", "-jar", "/taskmanager.jar"]
