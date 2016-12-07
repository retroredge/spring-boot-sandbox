FROM java:8 

ADD ./target/spring-boot-sandbox-1.0-SNAPSHOT.jar /root/app.jar

EXPOSE 8080

ENV MESSAGE="message from Heroku config"
