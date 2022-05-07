FROM openjdk:17-jdk-slim-buster AS builder

ARG APP_NAME=gateway
ARG APP_VERSION=0.0.1-SNAPSHOT

COPY ./ /app
WORKDIR /app
RUN chmod +x ./mvnw

RUN ./mvnw clean package

From eclipse-temurin:17.0.3_7-jre

ENV ARTIFACT_NAME=${APP_NAME}-${APP_VERSION} \
    JAVA_TOOL_OPTIONS=-Duser.timezone="Europe/Madrid" \
    TZ=CET-1CEST,M3.5.0,M10.5.0/3

COPY --from=builder /app/target/gateway-0.0.1-SNAPSHOT.jar /app/gateway-0.0.1-SNAPSHOT.jar

RUN addgroup gateway \
    && adduser --system --shell /bin/sh --no-create-home --ingroup gateway gateway \
    && mkdir /logs \
    && chown gateway:gateway /logs \
    && chmod a+rw /logs

RUN chown gateway:gateway -R /app

USER gateway

WORKDIR /app

EXPOSE 8443

ENTRYPOINT java -jar ./gateway-0.0.1-SNAPSHOT.jar 