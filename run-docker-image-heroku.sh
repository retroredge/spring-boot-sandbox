#!/usr/bin/env bash
# This script builds and runs a Docker image that has it's run command in the Docker file for running on Heroku
# You must run 'mvn clean package' first to create the JAR

echo "$(tput setaf 3)Running Spring Boot Sandbox in Docker...$(tput sgr 0)"
docker build -t spring-boot-sandbox-heroku-docker .
docker rm -f spring-boot-sandbox-heroku-docker
docker run -d -p 8080:8080 --name spring-boot-sandbox-heroku-docker  spring-boot-sandbox-heroku-docker
docker ps
echo "$(tput setaf 2)Click here --> http://localhost:8080/$(tput sgr 0)"
