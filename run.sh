#!/usr/bin/env bash
# This script builds and runs Docker image containing the application
# You must run 'mvn clean package' first to create the JAR

echo "$(tput setaf 3)Running Spring Boot Sandbox in Docker...$(tput sgr 0)"
docker build -t spring-boot-sandbox .
docker rm -f spring-boot-sandbox
docker run -d -p 8080:8080 --name spring-boot-sandbox  spring-boot-sandbox
docker ps
echo "$(tput setaf 2)Click here --> http://localhost:8080/$(tput sgr 0)"
