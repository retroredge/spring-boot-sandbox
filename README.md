spring-boot-sandbox
====

A simple Spring Boot project for experimenting with the framework.

It uses Jetty rather than the default Tomcat Web server.

Build
----
```
mvn clean package
```

Run
----
```
java -jar target/spring-boot-sandbox-1.0-SNAPSHOT.jar
or
mvn spring-boot:run
```

Endpoints
----
Application - http://localhost:8080/

Run in Docker container
----
```
./run-docker-image.sh
```

Run on Heroku
----
```
heroku create
git push heroku master
heroku ps:scale web=1
heroku open
```

