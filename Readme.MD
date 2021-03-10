This Application is working on below Spring Boot Version
<version>1.5.10.RELEASE</version>
doing change for testing github to jenkins poll configuration

Steps to be followed to proeprly work this project
1. clone this project
2. add oracle6-11.2.0.3.jar in local maven repo

Docker Deployment Steps:
1. Add Docker file
2. execute below command
   docker build -t springbootrestapi11:latest .
   docker run springbootrestapi11
