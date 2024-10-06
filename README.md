# Consumer Service

This repository contains the **Consumer Service**, a microservice that consumes messages from a Kafka topic and persists them into a MySQL database. The service is instrumented with OpenTelemetry to collect logs, metrics, and traces, which are visualized using Grafana.

## Description

The **Consumer Service** is responsible for consuming messages from a Kafka topic, processing them, and saving the data into a MySQL database. This service is part of a larger observability project and is used to demonstrate how to integrate Kafka-based message consumption with observability tools like OpenTelemetry and Grafana. The service collects logs, metrics, and traces via the OpenTelemetry Java Agent, which are then exported for analysis and visualization.

This repository is used as a **Git submodule** in the main [observability-project](https://github.com/saidRaiss/observability-project), which contains the full observability setup, including Grafana, Loki, Tempo, and Prometheus for monitoring and visualization.

## Environment Variables (Docker Compose)

The following environment variables are used in the **Consumer Service** configuration within the Docker Compose setup of the main observability project:

| Environment Variable                 | Description                                                         | Example Value                             |
|--------------------------------------|---------------------------------------------------------------------|-------------------------------------------|
| `APP_KAFKA_BOOTSTRAP`                | Kafka bootstrap server address.                                      | `PLAINTEXT://kafka:9090`                  |
| `APP_KAFKA_TOPIC`                    | Kafka topic from which messages are consumed.                        | `topic-observability`                     |
| `SPRING_DATASOURCE_URL`              | JDBC connection URL for the MySQL database.                          | `jdbc:mysql://mysql:3306/observabiliy_db` |
| `SPRING_DATASOURCE_USERNAME`         | MySQL database username.                                             | `kafkauser`                               |
| `SPRING_DATASOURCE_PASSWORD`         | MySQL database password.                                             | `kafkauserpassword`                       |
| `OTEL_SERVICE_NAME`                  | Name of the service for observability purposes.                      | `consumer-service`                        |
| `OTEL_RESOURCE_ATTRIBUTES`           | Attributes to identify the service in observability tools.           | `service.name=consumer-service`           |
| `OTEL_EXPORTER_OTLP_ENDPOINT`        | Endpoint for OpenTelemetry Collector to export telemetry data.       | `http://otel-collector:4317`              |
| `OTEL_EXPORTER_OTLP_PROTOCOL`        | Protocol used for telemetry data export.                             | `grpc`                                    |
| `OTEL_LOGS_EXPORTER`                 | Logs exporter protocol.                                              | `otlp`                                    |
| `OTEL_TRACES_EXPORTER`               | Traces exporter protocol.                                            | `otlp`                                    |
| `OTEL_METRICS_EXPORTER`              | Metrics exporter protocol.                                           | `otlp`                                    |

## Usage as a Submodule

To clone the entire observability project along with this submodule, run the following command:

```bash
git clone --recursive https://github.com/saidRaiss/observability-project.git
```

To initialize the submodule after cloning the main repository, use:
```bash
git submodule update --init --recursive
```
