FROM openjdk:11-jre-slim
WORKDIR usr/src
EXPOSE 8222
ADD ./target/property-owner-service-0.0.1-SNAPSHOT.jar /usr/src/property-owner-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","property-owner-service-0.0.1-SNAPSHOT.jar"]