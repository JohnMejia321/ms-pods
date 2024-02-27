FROM openjdk:17
WORKDIR /GenerateAutomaticId
COPY "./target/GenerateAutomaticId-0.0.1-SNAPSHOT.jar" "GenerateAutomaticId.jar"
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "GenerateAutomaticId.jar"]
