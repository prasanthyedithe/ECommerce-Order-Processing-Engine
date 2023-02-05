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
	
	


<BR>
List of Tables:
1. orders	
2. order_addresses	
3. order_payments	
4. order_items	
5. addresses	
6. payment_methods	
7. items	
8. customers	
9. lookup_data	



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

## The Twelve Factors
<B>I. Codebase </B><BR>
	Implemented One codebase tracked in revision control, many deploys<BR>
<B>II. Dependencies </B><BR>
	Implemented Explicitly declare and isolate dependencies<BR>
<B>III. Config </B><BR>
	Implemented Store config in the environment, we can improve by moving the configuration detials to HarshiVault<BR>
<B>IV. Backing services</B><BR>
	Treat backing services as attached resources<BR>
<B>V. Build, release, run </B><BR>
	We can implement Initialize, Build, Static Code Analysis-SONAR, Push to Artifactory, Create a Sanpshot, Deploy in PCF or any cloude environment, Workflow Cleanup<BR>
<B>VI. Processes</B><BR>
	Execute the app as one or more stateless processes<BR>
<B>VII. Port binding</B><BR>
	Export services via port binding<BR>
<B>VIII. Concurrency </B><BR>
	We can configure Scale-in and Scale-out based on the workload over the application in cluster<BR>
<B>IX. Disposability </B><BR>
	Implemented Maximize robustness with fast startup and graceful shutdown<BR>
<B>X. Dev/prod parity </B> <BR>
	Keep development, staging, and production as similar as possible<BR>
<B>XI. Logs </B><BR>
	Implemented Treat logs as event streams using Log4J<BR>
<B>XII. Admin processes </B><BR>
	We can implement on full fledge environment.Run admin/management tasks as one-off processes<BR>


## Improvements

1. Can a single RESTful API service handle all these requirements? Or do you
need more than one microservice to support these two types of clients?
Are these different kinds of services: RESTful, batch, message queue
based?
<BR><B> Answer :</B> We need to have more Microservice to avoid dependenciences, and RESTful API to be exposed and for bulk operations we can use Kafka as messaging queue. 
2. How would you deal with network connectivity issues or data quality
errors? Between client and your service? Between your service and the
database?
<BR><B> Answer :</B> We can use Discovery SErvice nad API gate way like Netflix
3. How would you handle order_id generation: autoincremented database
sequencer? Remember, you are dealing with distributed systems where
other services can generate these identifiers on their own.
<BR><B> Answer :</B> In generall for large application we generally prefer to use UUID , so that tracking them will be easy when connected with Dynatrace or Splunk
4. How would you improve performance of the bulk order processing? While
you are at it, prioritize customer-facing apps’ performance over the
internal client services’ performance.
<BR><B> Answer :</B> In case of bulk operation we can use any messaging service so that it works at back end to avoid any distrubnece we are using Kafka
5. How would you make your life easier for debugging any issues with your
services? Logging? Custom Metrics? Once deployed to production, you
would be asked: “What happened to that order by customer xyz?”.
<BR><B> Answer :</B> The bease way to identify the Issue is to configure the Dynatrace or Splunk using UUID
6. What if this migration is going to take months? How do you keep the
current business running while the new development is going on? Do you
want to keep both databases online during this time?
<BR><B> Answer :</B> One of the principles of a microservices architecture is to have one database for each microservice. Therefore, when you modernize your monolithic application into microservices, you must split the monolithic database based on the service boundaries that you identify. 
7. Would a NoSQL database be better choice than the relational one for this
use case? In what scenario for this use case, we should think of moving to
a NoSQL one?
<BR><B> Answer :</B>
	<BR><ins><I> When to use SQL</I></ins>
<BR> SQL is a good choice when working with related data. Relational databases are efficient, flexible and easily accessed by any application. A benefit of a relational database is that when one user updates a specific record, every instance of the database automatically refreshes, and that information is provided in real-time.<BR> SQL and a relational database make it easy to handle a great deal of information, scale as necessary and allow flexible access to data — only needing to update data once instead of changing multiple files, for instance. It’s also best for assessing data integrity. Since each piece of information is stored in a single place, there’s no problem with former versions confusing the picture.<BR> Most of the big tech companies use SQL, including Uber, Netflix and Airbnb. Even major companies like Google, Facebook and Amazon, which build their own database systems, use SQL to query and analyze data.
	<BR><ins><I>When to use NoSQL</I></ins>
<BR> While SQL is valued for ensuring data validity, NoSQL is good when it’s more important that the availability of big data is fast. It’s also a good choice when a company will need to scale because of changing requirements. NoSQL is easy-to-use, flexible and offers high performance.<BR> NoSQL is also a good choice when there are large amounts of (or ever-changing) data sets or when working with flexible data models or needs that don't fit into a relational model. When working with large amounts of unstructured data, document databases (e.g., CouchDB, MongoDB, and Amazon DocumentDB) are a good fit. For quick access to a key-value store without strong integrity guarantees, Redis may be the best choice. When a complex or flexible search across a lot of data is needed, Elastic Search is a good choice.<BR> Scalability is a significant benefit of NoSQL databases. Unlike with SQL, their built-in sharding and high availability requirements allow horizontal scaling. Furthermore, NoSQL databases like Cassandra, developed by Facebook, handle massive amounts of data spread across many servers, having no single points of failure and providing maximum availability.<BR> Other big companies that use NoSQL systems because they are dependent on large volumes of data not suited to a relational database include Amazon, Google and Netflix. In general, the more extensive the dataset, the more likely that NoSQL is a better choice.
8. Logging and metrics can be improved, can use ELK stack to ingest logs and generate metrics
9. Async communication among microservices. Instead of communicating via Http, the microservices can send messages to each other.
10. Unit testing can be improved
11. Integration tests can be added
12. Batch processing servers should be different from normal API servers
13. In items table, we have product_id where we can have seperate table with all the product ids to be saved

## Bugs

1. Some times the docker is not working need to have a look