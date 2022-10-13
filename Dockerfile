FROM openjdk:11-jre-slim
COPY target/audio-recorder-be-0.0.1-SNAPSHOT.jar audio-recorder-be-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/audio-recorder-be-0.0.1-SNAPSHOT.jar"]