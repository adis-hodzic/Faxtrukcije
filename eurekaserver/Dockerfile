FROM openjdk:11-jdk
EXPOSE 8761
ADD build/libs/eureka.jar eureka.jar
ENTRYPOINT ["java","-jar","/eureka.jar"]