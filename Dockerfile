FROM bellsoft/liberica-openjdk-alpine:23
COPY target/*.jar stamper.jar
EXPOSE 8988
ENTRYPOINT ["java", "-jar", "stamper.jar"]