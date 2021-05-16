FROM openjdk:11-jdk
EXPOSE 8084
ADD build/libs/messaging.jar messaging.jar
ENTRYPOINT ["java","-jar","/messaging.jar"]