For  MySql Container Command

- docker run --detach --name="mySql_docker" --env="MYSQL_ROOT_PASSWORD=root123" --publish 6603:3306 --volume=D:/mySql:/var/lib/mysql mysql

Reference: https://phoenixnap.com/kb/mysql-docker-container

For Java - downloaded the docker image

For Kafka - refer docker-compose

After installaing all the images, we need to connect all the containers under one network

- docker network create NETWORK_NAME

after successful creation, then we need to map all the container under the newly created network

- docker network connect NETWORK_NAME CONTAINER_NAME

Then we need to move builded jar file to Java Container

- docker cp D:\Sample-spring-boot\target\sample-spring-boot-0.0.1-SNAPSHOT.jar Java-16-oracle:/opt/

- java -jar sample-spring-boot-0.0.1-SNAPSHOT.jar


Happy Coding! :-)

