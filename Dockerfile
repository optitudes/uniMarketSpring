#
# Package stage
#
FROM eclipse-temurin:11 AS build
ARG JAR_FILE=negocio/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
EXPOSE ${PORT}
ENTRYPOINT ["java","-jar","/app.jar"]