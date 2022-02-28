FROM openjdk:14
COPY ./target/banco-0.0.1-SNAPSHOT.jar /tmp/app-banco.jar
WORKDIR /tmp
CMD ["java" , "-jar","app-banco.jar"]