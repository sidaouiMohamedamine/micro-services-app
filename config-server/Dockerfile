FROM openjdk:17-jdk
EXPOSE 8082
ADD target/config-server-0.0.1-SNAPSHOT.jar config-server.jar
ENTRYPOINT ["java","-jar","config-server.jar"]