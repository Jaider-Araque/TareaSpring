FROM eclipse-temurin:21-jdk
COPY "./target/spring-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT:-8086}", "app.jar"]