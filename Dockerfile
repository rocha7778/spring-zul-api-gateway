FROM openjdk:12
VOLUME /temp
EXPOSE 8090
ADD ./target/spring-zul-api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
ENTRYPOINT ["java", "-jar", "-Duser.timezone=America/Bogota",  "/api-gateway.jar"]