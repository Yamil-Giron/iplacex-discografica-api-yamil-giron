FROM gradle:8.4-jdk17 AS builder

COPY --chown=gradle:gradle . /app
WORKDIR /app

RUN gradle clean build --no-daemon

FROM openjdk:17-jdk-slim AS runner

WORKDIR /app

COPY --from=builder /app/build/libs/mi-api-rest-1.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
