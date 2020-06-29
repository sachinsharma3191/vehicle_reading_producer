FROM maven:3.6.1-jdk-11 AS MAVEN_BUILD

# copy the pom and src code to the container
COPY ./ ./

# build all dependencies for offline use
RUN mvn dependency:go-offline -B 

# package our application code
RUN mvn package -DskipTests=true

# the second stage of our build will use open jdk 8 on alpine 3.9
FROM openjdk:11

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /target/Trucker_Project-1.0.0.jar /app.jar

EXPOSE 9040

# set the startup command to execute the jar
CMD ["java", "-jar", "/app.jar"]