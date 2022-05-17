FROM openjdk:17-jdk-alpine3.14

COPY "./target/e_sport_tournament.jar" "/application/e_sport_tournament.jar"

CMD ["java", "-jar", "/application/e_sport_tournament.jar"]