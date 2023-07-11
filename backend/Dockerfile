FROM openjdk:20

ENV ENVIROMENT=prod

MAINTAINER Marcell Dechant <marcell.dechant@proton.me>

EXPOSE 8080

ADD target/backend.jar app.jar

CMD ["sh", "-c", "java -jar /app.jar"]