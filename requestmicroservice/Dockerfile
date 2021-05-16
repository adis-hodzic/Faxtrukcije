
FROM openjdk:11-jdk
EXPOSE 8080
ADD build/libs/request.jar request.jar
ENTRYPOINT ["java","-jar","/request.jar"]