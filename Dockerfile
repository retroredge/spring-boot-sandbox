FROM openjdk:17

ADD ./target/spring-boot-sandbox-1.0-SNAPSHOT.jar /root/app.jar

EXPOSE 8080

ENV MESSAGE="Message from Docker ENV config"

CMD java -Dserver.port=8080 -jar /root/app.jar
