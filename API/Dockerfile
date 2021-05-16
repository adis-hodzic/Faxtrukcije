FROM openjdk:11-jdk
EXPOSE 8111
ADD build/libs/api.jar api.jar
ENTRYPOINT ["java","-jar","/api.jar"]