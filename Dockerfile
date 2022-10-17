FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/audio-recorder-be-0.0.1-SNAPSHOT.jar .
RUN chmod ugo+w /app/files #giving write permission
ENTRYPOINT ["java","-jar","/audio-recorder-be-0.0.1-SNAPSHOT.jar"]