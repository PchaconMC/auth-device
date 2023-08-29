FROM openjdk:17
VOLUME /tmp
ADD ./target/device-service-0.0.1-SNAPSHOT.jar device-service.jar
ENTRYPOINT ["java","-jar","/device-service.jar"]