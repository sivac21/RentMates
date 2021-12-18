FROM openjdk:11
ADD ./target/tenant-matchmaking-service-0.0.1-SNAPSHOT.jar /usr/src/tenant-matchmaking-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "tenant-matchmaking-service-0.0.1-SNAPSHOT.jar"]
