FROM openjdk:11-jre-slim
WORKDIR usr/src
# EXPOSE 8001
ADD ./target/tenant-profile-service-0.0.1-SNAPSHOT.jar /usr/src/tenant-profile-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","tenant-profile-service-0.0.1-SNAPSHOT.jar"]