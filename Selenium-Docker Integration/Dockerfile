FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq
#workspace creation

WORKDIR	/usr/share/udemy

#Adding jar files from the host
ADD target/selenium-docker.jar  		selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs 						libs

# WE CAN add testcd .. data also , .csv, .xlsx
ADD Book-flightModule.xml 				Book-flightModule.xml
ADD search-module.xml					search-module.xml


#Adding healthCheck script

ADD healthcheck.sh                  healthcheck.sh
#BROWSER
#HUB_HOST
#MODULE 
ENTRYPOINT sh healthcheck.sh