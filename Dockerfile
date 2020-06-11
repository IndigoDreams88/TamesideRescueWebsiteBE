FROM openjdk:9
ADD target/animals-postgres.jar animals-postgres.jar
EXPOSE 8080
ENTRYPOINT ['java', '-jar'. 'animals-postgres.jar']