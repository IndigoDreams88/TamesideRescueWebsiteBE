FROM openjdk:9
ADD target/animals-postgres.jar animals-postgres.jar
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "animals-postgres.jar"]