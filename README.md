spring-boot-sandbox
====

A simple Spring Boot project for experimenting with the framework.

The application uses Jetty rather than the default Tomcat Web server. See `spring-boot-starter-jetty` in the POM file.

The root endpoint outputs a parameterised message. The parameters are picked up from Java 
system properties and environment variables.

The project has Docker file and a Heroku Procfile and .env file.

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
http://localhost:8080/
http://localhost:8080/greeting


Actuator Endpoints
----
http://localhost:8080/actuator/info
http://localhost:8080/actuator/metircs
http://localhost:8080/actuator/health
http://localhost:8080/actuator/trace
http://localhost:8080/actuator/beans


Run locally in Docker container
----
```
./run-docker-image.sh
http://localhost:8080/
```

Run on Heroku
----
```
heroku create
git push heroku master
heroku ps:scale web=1
./run-docker-image.sh
heroku open
```

Test Locally with Heroku
----
```
heroku local web
http://localhost:5000/
```

Note the .env file provides the environment variables when running Heroku locally.

Demonstrate the correlation id filter
----
```curl -H "X-Correlation_ID: 1234" http://localhost:8080/greeting```

TODO
----

- Slf4j
- Add a filter
- @MockBean
- @Bean
- @Configuration
- Profiles




