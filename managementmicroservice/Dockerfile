FROM openjdk:11-jdk
EXPOSE 8085
ADD build/libs/management.jar management.jar
ENTRYPOINT ["java","-jar","/management.jar"]