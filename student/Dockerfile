FROM openjdk:17-jdk
EXPOSE 8090
ADD target/student-0.0.1-SNAPSHOT.jar student.jar
ENTRYPOINT ["java","-jar","student.jar"]