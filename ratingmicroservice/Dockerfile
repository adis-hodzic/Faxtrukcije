FROM openjdk:11-jdk
EXPOSE 8083
ADD build/libs/rating.jar rating.jar
ENTRYPOINT ["java","-jar","/rating.jar"]