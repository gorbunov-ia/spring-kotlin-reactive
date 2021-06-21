#FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift:1.8
FROM registry.access.redhat.com/ubi8/openjdk-11:1.3

COPY target/*.jar /app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/app.jar"]