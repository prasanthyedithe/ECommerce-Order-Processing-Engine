# ECommerce-Order-Processing-Engine

The Application consists of 
1. Micro services
	1. order-service
	2. customer-service
	3. item-service
	4. address-service
	5. payment-method-service
2. Gateway service
	1. api-gateway
3. Discovery service
	1. discovery-service
4. Architectural Diagrams Folder
	1. New Database Schema.xlsx
	2. API's Exposed
	3. Microservices
	4. Table Relationships
	5. Tables Normalization
	
	
<img
src="https://github.com/prasanthyedithe/ECommerce-Order-Processing-Engine/blob/e9599ef6323e910655a608b1782c07284722244d/Architectural%20Diagrams/Microservices.jpg"
/>

## Features
1. Uses Netflix Eureka for service discovery
2. Uses Kafka for bulk order processing
3. Uses Swagger OpenApi for API documentation (available at http://localhost:8080/swagger)
4. Unit tests written for all Micro services
5. Exposes /orders-bulk endpoint as a client for processing orders in bulk
6. Exposes /orders-bulk/status endpoint as a client for processing order status updates in bulk

All the micro-services are dockerized and deployable to docker using docker-compose.yml file included in the project.

## Prerequisites

1. Java 11
2. Docker
3. Maven

## Steps to run the project

1. execute build_run.sh

## Improvements

1. Logging and metrics can be improved, can use ELK stack to ingest logs and generate metrics
2. Async communication among microservices. Instead of communicating via Http, the microservices can send messages to each other.
3. Unit testing can be improved
4. Integration tests can be added
5. Batch processing servers should be different from normal API servers

## Bugs

1. Some times the docker is not working need to have a look