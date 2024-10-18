#####################  Below feature added #######################

This branch contains below features
1. Spring Data JPA(MYSQL Connectivity)
2. Custom Exception
3. jacoco integration

-------------------------------------------------------------------

1. Docker image of Spring Boot MYSQL application
2. Pulled MYSQL docker image with "root" user and root "password" and deploy Spring Boot Docker application in Docker container
3. Create Docker container and connect mysql container to docker network 
4. run Spring boot docker image usingg mycsql container and docker network

###################### Docker Deployment Steps #####################
  
1. mvn clean install
   It will install jar in local m2 directory
2. docker build -t springbootrestimage .
   -t ----> refer tagName
   .  ----> refer current directory ( this need to be executed inside project directory)
3. docker pull mysql
   Note: if you not specify tagName =, it will pull latest, like the baove cmd becomes "docker pull mysql:latest"
4. docker run -p 3307:3306 --name mysqlcontainer -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=student -d mysql
   -p ----> refer port
   -e ----> refer environment variable
   -d ----> refer detach mode
   MYSQL_ROOT_PASSWORD, MYSQL_DATABASE ----> pass here while running mysqlcontainer
   --name----> refer name of container
5. docker network create networkmysql
   create ----> create docker network
6. docker network connect networkmysql mysqlcontainer
   Note: connect the above created myqlcontainer to  networkmysql
7. docker run -p 8089:9092 --name springbootrestcontainer --net networkmysql -e MYSQL_USER=root -e MYSQL_ROOT_PASSWORD=root -e MYSQL_HOST=mysqlcontainer -e MYSQL_PORT=3306 -e MYSQL_DB_NAME=student springbootrestimage
   Note: here "MYSQL_DB_NAME" is different while running for mysql , there we used "MYSQL_DATABASE"
