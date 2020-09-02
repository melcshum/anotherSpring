# anotherSpring


##Setup the Postgres database

docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine  


#check the port 
docker port postgres-spring 

#connect with docker
docker exec -it 1561e60c5b01d82e16f59fc2687a3402209336f6cf8e4778b0ac66bdf12b7887  bin/bash

##connect with postgres

bash-5.0# psql -U postgres



##Reference from 

Spring Boot Tutorial for Beginners (Java Framework)

https://www.youtube.com/watch?v=vtPkZShrvXQ
