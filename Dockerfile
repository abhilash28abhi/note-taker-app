FROM openjdk:8-jdk-alpine
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY build/libs/*.jar /opt/notes.jar
ENTRYPOINT exec java $JAVA_OPTS -jar notes.jar