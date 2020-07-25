# Selenium---Docker-Integration
Selenium - Test Execution using Docker Containers 
# Docker Introduction
Getting started with Docker; basic essentials things you need to know about docker: images, containers, volumes, creating docker image. And running a VM instance in AWS.


**What is Docker**
Docker provides the ability to package and run an application in a loosely isolated environment called a container. The isolation and security allow you to run many containers simultaneously on a given host.

### Getting Started 
 - [Install Docker](https://docs.docker.com/install/) 


## Packaging using Maven 
* Go to the root directory of the project and Run the following maven commands to create a jar file
* Once runned the 
$ mvn clean
$ mvn clean package -DskipTests


##### 3. Build Docker image using the DockerFile 
- create a file named DockerFile
- Check the attached DockerFile for creating the dockerImage

$ docker build yournewimagename . 

Run the below command to check whether the dockerimage is created

$ docker images 

#### 4.Starting the Docker container using Docker-compose 

- Check the attached docker-compose.yaml file for the container configuration

$ docker compose run

### Basic Docker Commands

| Commands |Description?|
| ------ | ------ |
| docker pull image |pulls an image from DockerHub|
| docker images | hows all the images in our machine  |
| docker ps | shows all the running containers |
| docker run image | creates a container from an image|
|docker stop ​container id/container name | stops a running container|
|docker system prune -f | To remove all the stopped containers|
|docker system prune -a | same as above + unused Images|

