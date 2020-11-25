FROM openjdk:11.0.8-jre-slim

EXPOSE 61616

LABEL maintainer="Jorge Vargas <jorgevargasmateo@hotmail.com>"

COPY /build/libs/PracticaJMSSensors-0.0.1-SNAPSHOT.jar practicajmssensors.jar

ENTRYPOINT ["java", "-jar", "practicajmssensors.jar"]