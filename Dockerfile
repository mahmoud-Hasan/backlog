FROM openjdk:8

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

copy ./target/backlog-0.0.1-SNAPSHOT.jar /usr/src/app

entrypoint ["java","-Dspring.data.mongodb.uri=mongodb://mongodbimage/BackLog" ,"-jar" ,"/usr/src/app/backlog-0.0.1-SNAPSHOT.jar"]
expose 8080