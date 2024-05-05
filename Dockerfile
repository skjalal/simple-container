FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY build/libs/simple-container-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 80
ENTRYPOINT ["java", "-Dserver.port=80","-jar","/app.jar"]