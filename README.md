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
>cd spring-kotlin-reactive-service
>docker build . -t spring-reactive-service
>cd ..
```
## run docker compose
```
>cd docker
>docker-compose -p spring-kotlin-reactive up
```