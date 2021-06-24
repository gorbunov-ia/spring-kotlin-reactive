## build the app
```
>mvnw clean package
```
## build the docker image of the mock
```
>cd spring-kotlin-reactive-mock
>docker build . -t spring-reactive-mock
>cd ..
```
## build the docker image of the service
```
>cd spring-kotlin-web-service
>docker build . -t spring-web-service
>cd ..
```
## configure user credentials
```
>cd docker
>cp template.db.env db.env
```
Write your username and password for the database to the `db.env` file.
```
>cp template.service.env service.env
```
Write the username and password of the database to the `service.env` file.
## run docker compose
```
>docker-compose -p spring-kotlin-reactive up
```